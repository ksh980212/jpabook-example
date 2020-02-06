package com.jpabook.modeling.demo.domain.category;

import com.jpabook.modeling.demo.domain.item.ItemCategoryMapper;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<ItemCategoryMapper> itemCategoryMapperList;

}