package com.orion.loggerappdata.service;

import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orion.loggerappdata.model.Book;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
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

    public BookSenderService(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 20000)
    public void sendPraticalTip() {
        Random r = new Random();
        Book book = new Book(String.valueOf(r.nextInt()), "Teste " + String.valueOf(r.nextInt()));
        log.info("Tentando enviar mensagem para a fila");
        try {
            ObjectMapper mapper = new ObjectMapper();
            String bookJson = mapper.writeValueAsString(book);

            //rabbitTemplate.convertAndSend(exchangeName, routingKey, book);
            rabbitTemplate.convertAndSend(Book.class.getSimpleName(), bookJson);
            log.info("Mensagem enviada pelo LoggerApp para a fila");
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}