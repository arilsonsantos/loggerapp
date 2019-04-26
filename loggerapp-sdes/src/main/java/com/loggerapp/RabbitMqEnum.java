package com.loggerapp;

/**
 * RabbitMqEnum
 */
public enum RabbitMqEnum {

    EXCHANGE_NAME("JumiaExchange"), QUEUE("JumiaQueue"), ROUTING_KEY("JumiaKey");

    private String nome;

    private RabbitMqEnum(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}