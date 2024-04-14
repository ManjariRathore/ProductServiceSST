package com.manjari.productservicesst.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
public class Category {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @OneToMany
//    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products;


}
