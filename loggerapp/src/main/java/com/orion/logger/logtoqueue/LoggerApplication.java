package com.orion.logger.logtoqueue;

import static com.orion.logger.logtoqueue.enums.RabbitMqEnum.EXCHANGE_NAME;
import static com.orion.logger.logtoqueue.enums.RabbitMqEnum.QUEUE;
import static com.orion.logger.logtoqueue.enums.RabbitMqEnum.ROUTING_KEY;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LoggerApplication {

	// public static final String EXCHANGE_NAME = "JumiaExchange";
	// public static final String QUEUE = "JumiaQueue";
	// public static final String ROUTING_KEY ="JumiaKey";

	public static void main(String[] args) {
		SpringApplication.run(LoggerApplication.class, args);
	}

	@Bean
	public DirectExchange tipsExchange() {
		return new DirectExchange(EXCHANGE_NAME.toString());
	}

	@Bean
	public Queue defaulParsinsQueue() {
		return new Queue(QUEUE.toString());
	}

	@Bean
	public Binding queueToExchangeBinding() {
		return BindingBuilder.bind(defaulParsinsQueue()).to(tipsExchange()).with(ROUTING_KEY.toString());
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
