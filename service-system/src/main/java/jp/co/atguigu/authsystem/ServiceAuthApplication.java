package jp.co.atguigu.authsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class ServiceAuthApplication {
	public static void main(final String[] args) {
		SpringApplication.run(ServiceAuthApplication.class, args);
		log.info("アプリは起動されました。");
	}
}