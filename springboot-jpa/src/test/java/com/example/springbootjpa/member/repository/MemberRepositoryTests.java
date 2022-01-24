package com.example.springbootjpa.member.repository;

import com.example.springbootjpa.member.model.Member;
import com.example.springbootjpa.member.model.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

/**
 * @author gihyung.lee
 * @since 2022/01/14
 */
@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    MemberRepository repository;

    @Test
    public void crud() {
        //create
        Member member = Member.builder()
                .id(1L)
                .email("example@google.com")
                .name("example")
                .phone("010-1234-5678")
                .address("address").build();
        repository.save(member);

        //read
        Optional<Member> opt = repository.findById(1L);
        member = opt.get();

        //update
        member.setName("example2");
        repository.save(member);

        //delete
        repository.delete(member);
    }

}
