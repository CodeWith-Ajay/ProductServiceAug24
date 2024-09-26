package com.example.ProductServiceAug24.Configurations;

import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfi {

    @Bean
    public RedisTemplate<String,Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> RedisTemplate = new RedisTemplate<>();
        RedisTemplate.setConnectionFactory(redisConnectionFactory);
        return RedisTemplate;

    }
}
