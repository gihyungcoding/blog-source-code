package com.example.springbootredis.member.application.event;

import com.example.springbootredis.member.application.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * Redis Message Listener
 * @author gihyung.lee
 * @since 2022/01/07
 */
@Log4j2
@RequiredArgsConstructor
@Component
public class RedisListener implements MessageListener {

    private final MemberService memberService;

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // redis에서 expire 이벤트 수신 시 대상 키값 조회
        final RedisSerializer<?> keySerializer = redisTemplate.getKeySerializer();
        final String key = (String) keySerializer.deserialize(message.getBody());

        log.info("onMessage body : {}", key);

        memberService.changeStatus(key);
    }

}
