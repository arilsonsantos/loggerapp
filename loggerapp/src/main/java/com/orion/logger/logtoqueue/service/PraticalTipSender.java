package com.orion.logger.logtoqueue.service;

import static com.orion.logger.logtoqueue.enums.RabbitMqEnum.EXCHANGE_NAME;
import static com.orion.logger.logtoqueue.enums.RabbitMqEnum.ROUTING_KEY;
import com.orion.logger.logtoqueue.model.PraticalTipMessage;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * PraticalTipSender
 */
@Slf4j
@Service
public class PraticalTipSender {

    private final RabbitTemplate rabbitTemplate;

    public PraticalTipSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 5000)
    public void sendPraticalTip() {
        PraticalTipMessage tip = new PraticalTipMessage("O texto é para teste!", 1, Boolean.FALSE);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME.toString(),ROUTING_KEY.toString(), tip);
        log.info("Mensagem enviada para a fila");
    }
}