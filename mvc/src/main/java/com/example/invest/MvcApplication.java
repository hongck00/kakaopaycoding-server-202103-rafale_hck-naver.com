package com.example.invest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
        log.info("info");
        log.debug("debug");
        log.warn("warn");
        log.error("error");
        log.trace("trace");
    }
}
