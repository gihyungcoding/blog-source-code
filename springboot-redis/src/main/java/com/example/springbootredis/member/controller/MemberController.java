package com.example.springbootredis.member.controller;

import com.example.springbootredis.member.model.Member;
import com.example.springbootredis.member.model.MemberStatus;
import com.example.springbootredis.member.application.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.SplittableRandom;

/**
 * @author gihyung.lee
 * @since 2022/01/07
 */
@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<String> save() {
        String id = randomId();

        Member member = Member.builder()
                .id(id)
                .name(String.format("%s/%s", "홍길동", id))
                .status(MemberStatus.ACTIVATION)
                .build();

        log.info("save id : {}", member.getId());

        memberService.register(member);

        return ResponseEntity.ok(member.getId());
    }

    private String randomId() {
        SplittableRandom random = new SplittableRandom();
        return String.valueOf(random.nextInt(1, 1_000_000_000));
    }
}
