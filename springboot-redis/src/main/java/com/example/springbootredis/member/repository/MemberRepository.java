package com.example.springbootredis.member.repository;

import com.example.springbootredis.member.model.Member;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring Redis Data Repository for Member
 * @author gihyung.lee
 * @since 2022/01/07
 */
public interface MemberRepository extends CrudRepository<Member, String> {
}
