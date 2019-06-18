package com.cmcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

//import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;


// Ã·Ωª≤‚ ‘
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
//@EnableDistributedTransaction
@ServletComponentScan
public class BootApplication {

	@Autowired
	RestTemplateBuilder builder;

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return builder.build();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
