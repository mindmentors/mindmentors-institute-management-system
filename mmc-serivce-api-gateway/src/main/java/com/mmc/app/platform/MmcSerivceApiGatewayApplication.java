package com.mmc.app.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mmc")
public class MmcSerivceApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmcSerivceApiGatewayApplication.class, args);
    }

}
