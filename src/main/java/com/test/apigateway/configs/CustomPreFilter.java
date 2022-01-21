package com.test.apigateway.configs;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class CustomPreFilter implements GlobalFilter{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CustomPreFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		LOGGER.info("Request path is -> {}", exchange.getRequest().getPath());
		return chain.filter(exchange);
	}
}
