package com.gsh.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder locatorBuilder){
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("path_route1",r->r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
