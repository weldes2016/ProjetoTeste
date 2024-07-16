package com.projetoteste.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import redis.embedded.RedisServer;

@Component
public class EmbeddedRedisConfig {

	@Value("${spring.redis.port}")
	private int redisPort;

	
	private RedisServer redisServer;

	@PostConstruct
	public void startRedis() throws IOException {
		redisServer = new RedisServer(redisPort);
		redisServer.start();
	}

	@PreDestroy
	public void stopRedis() {
		try {
			redisServer.stop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
