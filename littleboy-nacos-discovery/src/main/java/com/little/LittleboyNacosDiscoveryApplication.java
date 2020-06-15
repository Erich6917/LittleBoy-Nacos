package com.little;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class LittleboyNacosDiscoveryApplication {

  public static void main(String[] args) {
    SpringApplication.run(LittleboyNacosDiscoveryApplication.class, args);
  }


  @RestController
  public class EchoController {
    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
      return "Hello Nacos Discovery " + string;
    }
  }

}
