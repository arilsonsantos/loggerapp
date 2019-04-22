package com.orion.logger.logtoqueue.model;

import com.orion.logger.logtoqueue.enums.AcaoEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * LogModel
 */
@Getter
@Setter
@NoArgsConstructor
public class LogModel {

    String usuario;
    AcaoEnum acao;

    
}