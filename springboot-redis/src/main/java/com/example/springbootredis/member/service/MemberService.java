package com.example.springbootredis.member.service;

import com.example.springbootredis.member.model.Member;

/**
 * Member Service
 * @author gihyung.lee
 * @since 2022/01/07
 */
public interface MemberService {

    /**
     * 회원 저장
     * @param member 회원 정보
     */
    void register(Member member);

    /**
     * 회원 상태 변경
     * @param id 회원 식별자
     */
    void changeStatus(String id);
}
