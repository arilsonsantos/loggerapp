package com.loggerapp;

import static com.loggerapp.RabbitMqEnum.EXCHANGE_NAME;
import static com.loggerapp.RabbitMqEnum.ROUTING_KEY;

import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Scheduled(fixedDelay = 5000)
    public void sendPraticalTip() {
        Random r = new Random();
        Pessoa b1 = new Pessoa(r.nextInt(), "Teste - SDES" + r.nextDouble());
        rabbitTemplate.convertAndSend(EXCHANGE_NAME.toString(), ROUTING_KEY.toString(), b1);

        log.info("Mensagem enviada pelo LoggerApp-SDES para a fila");
        log.info(teste);
    }
}