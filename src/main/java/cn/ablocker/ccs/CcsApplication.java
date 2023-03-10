package cn.ablocker.ccs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CcsApplication {
	private static Logger logger =  LogManager.getLogger("ccs");
	@Value("${server.port:80}")
	private int port;

	public static void main(String[] args) {
		SpringApplication.run(CcsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runInfo() {
		return args -> {
			logger.error("服务运行在 {} 端口", port);
		};
	}
}
