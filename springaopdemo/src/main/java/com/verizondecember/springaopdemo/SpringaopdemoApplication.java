package com.verizondecember.springaopdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringaopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringaopdemoApplication.class, args);
	}

}
