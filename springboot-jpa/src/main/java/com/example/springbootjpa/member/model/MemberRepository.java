package com.example.springbootjpa.member.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Jpa Repository for Member
 * @author gihyung.lee
 * @since 2022/01/14
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
