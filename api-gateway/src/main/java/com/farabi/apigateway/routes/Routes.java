package com.farabi.apigateway.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.web.servlet.function.RequestPredicates.path;

@Configuration
public class Routes {

    private final String userServiceUri;
    private final String companyServiceUri;

    public Routes(
            @Value("${USER_SERVICE_URI:http://userservice:8080}") String userServiceUri,
            @Value("${COMPANY_SERVICE_URI:http://companyservice:8081}") String companyServiceUri
    ) {
        this.userServiceUri = userServiceUri;
        this.companyServiceUri = companyServiceUri;
    }

    @Bean
    public RouterFunction<ServerResponse> userServiceRoute() {
        return route("user_service")
                .route(path("/users/**"), http(userServiceUri))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> companyServiceRoute() {
        return route("company_service")
                .route(path("/api/companies/**"), http(companyServiceUri))
                .build();
    }
}