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
                .route("swtvap-api-auth", r -> r.path("/api/auth/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-AUTH"))
                .route("swtvap-api-setting", r -> r.path("/swtvap-api-setting/v3/api-docs").and().method(HttpMethod.GET).uri("lb://SWTVAP-API-SETTING"))
                .route("swtvap-api-setting", r -> r.path("/api/parameters/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-SETTING"))
                .route("swtvap-api-review", r -> r.path("/swtvap-api-review/v3/api-docs").and().method(HttpMethod.GET).uri("lb://SWTVAP-API-REVIEW"))
                .route("swtvap-api-review", r -> r.path("/api/review/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-REVIEW"))
                .route("swtvap-api-relationship", r -> r.path("/swtvap-api-relationship/v3/api-docs").and().method(HttpMethod.GET).uri("lb://SWTVAP-API-RELATIONSHIP"))
                .route("swtvap-api-relationship", r -> r.path("/api/relationship/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-RELATIONSHIP"))
                .route("swtvap-api-product", r -> r.path("/swtvap-api-product/v3/api-docs").and().method(HttpMethod.GET).uri("lb://SWTVAP-API-PRODUCT"))
                .route("swtvap-api-product", r -> r.path("/api/product/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-PRODUCT"))
                .route("swtvap-api-order", r -> r.path("/swtvap-api-order/v3/api-docs").and().method(HttpMethod.GET).uri("lb://SWTVAP-API-ORDER"))
                .route("swtvap-api-order", r -> r.path("/api/order/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-ORDER"))
                .route("swtvap-api-logistic", r -> r.path("/swtvap-api-logistic/v3/api-docs").and().method(HttpMethod.GET).uri("lb://SWTVAP-API-LOGISTIC"))
                .route("swtvap-api-logistic", r -> r.path("/api/logistic/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-LOGISTIC"))
                .route("swtvap-api-inventory", r -> r.path("/swtvap-api-inventory/v3/api-docs").and().method(HttpMethod.GET).uri("lb://SWTVAP-API-INVENTORY"))
                .route("swtvap-api-inventory", r -> r.path("/api/catalogs/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-INVENTORY"))
                .route("swtvap-api-inventory", r -> r.path("/api/categories/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-INVENTORY"))
                .route("swtvap-api-inventory", r -> r.path("/api/category-catalogs/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-INVENTORY"))
                .route("swtvap-api-cart", r -> r.path("/swtvap-api-cart/v3/api-docs").and().method(HttpMethod.GET).uri("lb://SWTVAP-API-CART"))
                .route("swtvap-api-cart", r -> r.path("/api/cart/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-CART"))
                .route("swtvap-api-campaing", r -> r.path("/swtvap-api-campaing/v3/api-docs").and().method(HttpMethod.GET).uri("lb://SWTVAP-API-CAMPAING"))
                .route("swtvap-api-campaing", r -> r.path("/api/campaing/**").filters(f -> f.filter(filterFactory.apply())).uri("lb://SWTVAP-API-CAMPAING"))
                .build();
    }
}
