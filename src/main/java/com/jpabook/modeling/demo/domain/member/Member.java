package com.jpabook.modeling.demo.domain.member;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.jpabook.modeling.demo.domain.BaseTimeEntity;
import com.jpabook.modeling.demo.domain.common.Address;
import com.jpabook.modeling.demo.domain.order.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipCode;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}