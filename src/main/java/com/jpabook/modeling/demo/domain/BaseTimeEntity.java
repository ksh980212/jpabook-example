package com.jpabook.modeling.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseTimeEntity {

    private Date createdDate;

    private Date modifiedDate;
}
