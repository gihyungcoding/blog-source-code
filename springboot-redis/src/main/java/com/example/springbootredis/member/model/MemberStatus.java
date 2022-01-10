package com.example.springbootredis.member.model;

import lombok.Getter;

/**
 * 회원 상태
 * 상태 변경 테스트이므로 두가지 상태 생성
 * ACTIVATION : 활성
 * DORMANCY : 휴면
 * @author gihyung.lee
 * @since 2022/01/07
 */
@Getter
public enum MemberStatus {
    ACTIVATION,
    DORMANCY
}
