package cn.ablocker.ccs.controller;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {
	@Bean
	public Logger controllerLogger() {
		return LogManager.getLogger("ccs.controller");
	}
	
	@Bean
	public Random controllerRandom() {
		return new Random();
	}
}
