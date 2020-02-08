package com.jpabook.modeling.demo.domain.delivery;

import com.jpabook.modeling.demo.domain.common.Address;
import com.jpabook.modeling.demo.domain.order.Order;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;

    private String street;

    private String zipCode;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public void setOrder(Order order) {
        this.order = order;
    }

}