package cn.ablocker.ccs.mq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {
	@Bean
	public Queue edgeReportQueue() {
		return new Queue("edge.report");
	}
	
	@Bean
	public MqReceiver reportReceiver() {
		return new MqReceiver();
	}
	
	@Bean
	public FanoutExchange attentionSoft() {
		return new FanoutExchange("attention.soft");
	}
	
	@Bean
	public FanoutExchange attentionResource() {
		return new FanoutExchange("attention.resource");
	}
	
	@Bean
	public FanoutExchange attentionCollection() {
		return new FanoutExchange("attention.collection");
	}
	
	@Bean
	public FanoutExchange attentionTheme() {
		return new FanoutExchange("attention.theme");
	}
	
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public Logger mqLogger() {
		return LogManager.getLogger("ccs.mq");
	}
}
