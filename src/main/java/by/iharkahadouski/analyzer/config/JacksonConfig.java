package by.iharkahadouski.analyzer.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@Configuration
public class JacksonConfig {

	@Bean(name = "objectMapper")
	public ObjectMapper objectMapper() {
		ObjectMapper om = new ObjectMapper();
		om.setAnnotationIntrospector(new JacksonAnnotationIntrospector());
		om.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		om.registerModule(new JavaTimeModule());
		return om;
	}
}
