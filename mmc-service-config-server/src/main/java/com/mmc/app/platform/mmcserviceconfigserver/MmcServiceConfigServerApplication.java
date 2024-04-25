package com.mmc.app.platform.mmcserviceconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MmcServiceConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmcServiceConfigServerApplication.class, args);
    }

}
