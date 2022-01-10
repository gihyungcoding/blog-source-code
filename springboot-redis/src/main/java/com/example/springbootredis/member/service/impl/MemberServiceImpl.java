package com.example.springbootredis.member.service.impl;

import com.example.springbootredis.member.model.Member;
import com.example.springbootredis.member.model.MemberStatus;
import com.example.springbootredis.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Member Service Impl
 * @author gihyung.lee
 * @since 2022/01/07
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final RedisTemplate<String, Object> redisTemplate;

    // 별도의 DB를 사용하지 않아 Map으로 구현
    private ConcurrentHashMap<String, Member> map = new ConcurrentHashMap<>();

    @PreDestroy
    private void clear() {
        map.clear();
    }

    @Override
    public void register(Member member) {
        // 만료 기간 설정 5초
        final int expireMinutes = 5;

        // redis에 데이터 저장
        redisTemplate.opsForValue().set(member.getId(), member, expireMinutes, TimeUnit.SECONDS);

        // map에 데이터 저장(데이터 확인용)
        map.put(member.getId(), member);
    }

    @Override
    public void changeStatus(String id) {
        // 회원 정보 조회 및 상태변경
        Member member = map.get(id);
        member.setStatus(MemberStatus.DORMANCY);

        log.info("Member id : {} status : {}", member.getId(), member.getStatus());
    }

}
