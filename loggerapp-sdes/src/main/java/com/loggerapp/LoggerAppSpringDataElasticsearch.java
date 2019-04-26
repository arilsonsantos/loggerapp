
package com.loggerapp;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableScheduling
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.loggerapp")
public class LoggerAppSpringDataElasticsearch {

	public static void main(String[] args) {
		SpringApplication.run(LoggerAppSpringDataElasticsearch.class, args);
	}

	@Bean
	public Jackson2JsonMessageConverter producerMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerMessageConverter());
		return rabbitTemplate;
	}
}
