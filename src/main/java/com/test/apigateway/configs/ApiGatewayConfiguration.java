package com.test.apigateway.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p->p.path("/my-users/**")
						.filters(f->f.rewritePath("/my-users(?<path>.*)", "${path}"))
						.uri("lb://user-ms"))
				.route(p->p.path("/my-subscribers/**")
						.filters(f->f.rewritePath("/my-subscribers(?<path>.*)", "${path}"))
						.uri("lb://subscriber-ms"))
				.build();
	}
}
