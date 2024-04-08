package com.manjari.productservicesst.models;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Product {
//    @Id
    private Long id;
    private String title;
    private String description;
    private Double price;
//    @ManyToOne
//    private Category Cat;
    private String Category;
    private String img;
}
