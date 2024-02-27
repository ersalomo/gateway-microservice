package com.example.gateway.routes;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteGateway {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("employeeManagement", r -> r.path("/emp/**")
                        .filters(f -> f.rewritePath("/emp/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8001")
                )
                .route("sky-ex", r -> r.path("/sky/**")
                        .filters(f -> f.rewritePath("/sky/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8080")
                )
                .build();
    }
}