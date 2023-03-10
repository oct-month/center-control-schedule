package cn.ablocker.ccs.mq;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MqTests {
	@Autowired
	private RabbitTemplate template;
	@Autowired
	private Queue edgeReportQueue;
	
	@Test
	void sendReport() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		ReportData m = new ReportData();
		m.setDevice("sfd");
		template.convertAndSend(edgeReportQueue.getName(), m);
	}
}
