package com.services.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()

                // Movie info Service
                .route(p -> p.path("/students/**")
                        .uri("lb://student-info-service"))

                // Rating data Service

                .route(p -> p.path("/courses**")
                        .uri("lb://grades-data-service"))

                // Movie catalog Service
                .route(p -> p.path("/api/catalog/**")
                        .uri("lb://catalog-service"))

                .build();
    }
}
}
