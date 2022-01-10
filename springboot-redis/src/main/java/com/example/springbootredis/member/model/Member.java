package com.example.springbootredis.member.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * 회원 객체
 * @author gihyung.lee
 * @since 2022/01/07
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@RedisHash("member")
public class Member implements Serializable {

    @Id
    private String id;
    private String name;
    private MemberStatus status;

}
