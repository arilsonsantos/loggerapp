package com.orion.logger.loggerapp.listener;

// import static com.orion.logger.loggerapp.enums.RabbitMqEnum.EXCHANGE_NAME;
// import static com.orion.logger.loggerapp.enums.RabbitMqEnum.QUEUE;
// import static com.orion.logger.loggerapp.enums.RabbitMqEnum.ROUTING_KEY;

// import org.springframework.amqp.rabbit.annotation.Exchange;
// import org.springframework.amqp.rabbit.annotation.Queue;
// import org.springframework.amqp.rabbit.annotation.QueueBinding;
// import org.springframework.amqp.rabbit.annotation.RabbitListener;
// import org.springframework.messaging.Message;
// import org.springframework.stereotype.Service;

// import lombok.extern.slf4j.Slf4j;

// /**
// * PraticalTipListener
// */
// @Slf4j
// @Service
// public class PraticalTipListener {

// @RabbitListener(
// bindings = @QueueBinding(
// value = @Queue(name = QUEUE.getNome()),
// exchange = @Exchange(name = EXCHANGE_NAME.getNome()),
// key = ROUTING_KEY.getNome()
// )
// )
// public void conumeFila(final Message<?> message) {
// log.info("Mensagem recebida: {}", message.toString());
// }
// }