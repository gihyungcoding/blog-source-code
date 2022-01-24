package com.example.springbootjpa.member.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author gihyung.lee
 * @since 2022/01/14
 */
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    Long id;

    String email;

    String name;

    String phone;

    String address;

}
