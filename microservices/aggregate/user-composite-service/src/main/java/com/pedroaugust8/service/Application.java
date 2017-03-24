package com.pedroaugust8.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan
public class Application {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  /** Main entry point. */
  public static void main(final String... args) {
    SpringApplication.run(Application.class, args);
  }
}
