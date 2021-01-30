 package com.zio.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages={"com.zio.*"})
@EnableJpaRepositories(basePackages = {"com.zio.repositories", "com.zio.main"})
@EntityScan(basePackages = {"com.zio.*", "com.zio.main"})
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Main.class, args);
		System.out.println("test");
	}

}
