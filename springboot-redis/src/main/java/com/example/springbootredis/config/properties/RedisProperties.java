package com.example.springbootredis.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gihyung.lee
 * @since 2022/01/07
 */
@Getter
@Setter
@ConfigurationProperties("spring.redis")
@Component
public class RedisProperties {
    private String host;
    private Integer port;
}
