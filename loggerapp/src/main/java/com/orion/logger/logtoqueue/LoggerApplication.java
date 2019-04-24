package com.orion.logger.logtoqueue;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = "com.orion.logger.logtoqueue")
@EnableElasticsearchRepositories(basePackages = "com.orion.logger.logtoqueue.repository")
public class LoggerApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoggerApplication.class, args);
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

	/*
	 * @Bean public DirectExchange tipsExchange() { return new
	 * DirectExchange(EXCHANGE_NAME.toString()); }
	 * 
	 * @Bean public Queue defaulParsinsQueue() { return new Queue(QUEUE.toString());
	 * }
	 * 
	 * @Bean public Binding queueToExchangeBinding() { return
	 * BindingBuilder.bind(defaulParsinsQueue()).to(tipsExchange()).with(ROUTING_KEY
	 * .toString()); }
	 */

}
