package com.jersson.arrivasplata.swtvap.gatewayserver.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API Gateway", version = "1.0", description = "Documentation API Gateway v1.0"))
public class OpenApiConfig {

    @Autowired
    TokenRelayGatewayFilterFactory filterFactory;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("swtvap-api-auth", r -> r.path("/swtvap-api-auth/v3/api-docs").and().method(HttpMethod.GET).uri("lb://SWTVAP-API-AUTH"))
                .route("swtvap-api-parameter", r -> r.path("/swtvap-api-parameter/v3/api-docs").and().method(HttpMethod.GET).uri("lb://SWTVAP-API-PARAMETER"))
                .route("swtvap-api-auth", r -> r.path("/api/v1/auth/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-AUTH"))
                .route("swtvap-api-parameter", r -> r.path("/api/v1/parameter/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-PARAMETER"))
                .build();
    }
}
