package cn.ablocker.ccs.mq;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MqSender {
	@Autowired
	private RabbitTemplate template;
	@Autowired
	private FanoutExchange attentionSoft;
	@Autowired
	private FanoutExchange attentionResource;
	@Autowired
	private FanoutExchange attentionCollection;
	@Autowired
	private FanoutExchange attentionTheme;
	
	public void send() {
		// TODO 拆分为多个sender
	}
}
