package com.orion.logger.logtoqueue;

import com.orion.logger.logtoqueue.enums.AcaoEnum;
import com.orion.logger.logtoqueue.model.LogModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerApplicationTests {

	
	@Test
	public void contextLoads() {
		LogModel logmModel = new LogModel();
		logmModel.setAcao(AcaoEnum.CREATE);
		logmModel.setUsuario("Joao");

		System.out.println("teste");

		log.info("teste");

	}

}
