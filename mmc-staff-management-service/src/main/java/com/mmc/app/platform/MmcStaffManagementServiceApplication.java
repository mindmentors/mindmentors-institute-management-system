package com.mmc.app.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mmc")
public class MmcStaffManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmcStaffManagementServiceApplication.class, args);
    }

}
