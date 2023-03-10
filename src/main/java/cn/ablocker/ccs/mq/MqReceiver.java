package cn.ablocker.ccs.mq;

import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "edge.report")
public class MqReceiver {
	@Autowired
	private Logger mqLogger;
	
	@RabbitHandler
	public void receive(ReportData in) {
		mqLogger.error(in);
		// TODO 接收report后处理
	}
}
