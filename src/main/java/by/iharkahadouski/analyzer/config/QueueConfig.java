package by.iharkahadouski.analyzer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@Configuration
public class QueueConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(QueueConfig.class);

	private AmqpAdmin amqpAdmin;

	private Exchange analyzerExchange;

	private final QueuesDefinition queuesDefinition;

	@Autowired
	public QueueConfig(AmqpAdmin amqpAdmin, Exchange analyzerExchange, QueuesDefinition queuesDefinition) {
		this.amqpAdmin = amqpAdmin;
		this.analyzerExchange = analyzerExchange;
		this.queuesDefinition = queuesDefinition;
	}

	@Bean
	public List<Queue> analyzeQueues() {
		return Arrays.stream(queuesDefinition.values())
				.map(it -> QueueBuilder.nonDurable(it).autoDelete().exclusive().build())
				.peek(amqpAdmin::declareQueue)
				.peek(it -> LOGGER.info("Queue '{}' has declared.", it.getName()))
				.collect(Collectors.toList());
	}

	@Bean
	public List<Binding> bindings(List<Queue> queues) {
		return queues.stream()
				.map(it -> BindingBuilder.bind(it).to(analyzerExchange).with(it.getName()).noargs())
				.peek(amqpAdmin::declareBinding)
				.peek(it -> LOGGER.info(
						"Queue '{}' has bind to exchange '{}'. Routing key is '{}'",
						it.getDestination(),
						it.getExchange(),
						it.getRoutingKey()
				))
				.collect(Collectors.toList());
	}
}
