package com.mmc.app.platform.mmcserviceconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableConfigServer
@RestController
@RequestMapping(path = "config")
public class MmcServiceConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmcServiceConfigServerApplication.class, args);
    }

    @RequestMapping("/hello")
    public String test(){
        return "test string";
    }
}
