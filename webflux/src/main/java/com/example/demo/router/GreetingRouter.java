package com.example.demo.router;

import com.example.demo.handler.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), greetingHandler::hello)
                .andRoute(POST("/hello")
                        .and(contentType(MediaType.APPLICATION_JSON)), greetingHandler::hello)
                .andRoute(PUT("/hello")
                        .and(contentType(MediaType.APPLICATION_JSON)), greetingHandler::hello)
                .andRoute(DELETE("/hello")
                        .and(contentType(MediaType.APPLICATION_JSON)), greetingHandler::hello)
                ;
    }
}
