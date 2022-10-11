package com.sfg.gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile("google")
//@Configuration
public class GoogleConfigs {

    @Bean
    public RouteLocator googleConfig(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("google",
                       r -> r.path("/search2")
                               .filters(f -> f.rewritePath("/search2(?<segment>/?.*)", "/${segment}"))
                               .uri("https://google.com"))
                .build();
    }
}
