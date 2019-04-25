package com.orion.logger.loggerapp.service;

import static com.orion.logger.loggerapp.enums.RabbitMqEnum.EXCHANGE_NAME;
import static com.orion.logger.loggerapp.enums.RabbitMqEnum.ROUTING_KEY;

import java.util.UUID;

import com.orion.logger.loggerapp.model.Book;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * PraticalTipSender
 */
@Slf4j
@Service
public class BookSenderService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.host}")
    private String teste;

    public BookSenderService(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    //@Scheduled(fixedDelay = 5000)
    public void sendPraticalTip() {
        UUID id = UUID.randomUUID();
        Book b1 = new Book(id.toString(), "Liro " + id.toString());
        rabbitTemplate.convertAndSend(EXCHANGE_NAME.toString(), ROUTING_KEY.toString(), b1);

        log.info("Mensagem enviada para a fila");
        log.info(teste);
    }
}