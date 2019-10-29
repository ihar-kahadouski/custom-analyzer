package by.iharkahadouski.analyzer.config;

import by.iharkahadouski.analyzer.util.AnalyzerArgumentsBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@Configuration
public class RabbitConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitConfig.class);

	private final ObjectMapper objectMapper;

	public RabbitConfig(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter(objectMapper);
	}

	@Bean
	public ConnectionFactory connectionFactory(@Value("${amqp.address}") URI addresses, @Value("${amqp.virtual-host}") String virtualHost) {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(addresses);
		cachingConnectionFactory.setVirtualHost(virtualHost);
		return cachingConnectionFactory;
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}

	@Bean
	public AmqpAdmin amqpAdmin(RabbitTemplate rabbitTemplate) {
		return new RabbitAdmin(rabbitTemplate);
	}

	@Bean
	public Exchange analyzerExchange(AmqpAdmin amqpAdmin, @Value("${analyzer.name}") String analyzerName,
			@Value("${analyzer.priority}") int priority, @Value("${analyzer.index-support}") boolean indexSupport,
			@Value("${analyzer.search-support}") boolean searchSupport, @Value("${analyzer.version}") String version) {
		Exchange exchange = ExchangeBuilder.directExchange(analyzerName)
				.durable(false)
				.autoDelete()
				.withArguments(new AnalyzerArgumentsBuilder().withName(analyzerName)
						.withPriority(priority)
						.withIndexSupport(indexSupport)
						.withSearchSupport(searchSupport)
						.withVersion(version)
						.build())
				.build();
		amqpAdmin.declareExchange(exchange);
		LOGGER.info("Exchange '{}' has declared.", analyzerName);
		return exchange;
	}
}
