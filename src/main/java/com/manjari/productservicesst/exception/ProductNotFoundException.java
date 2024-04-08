package com.manjari.productservicesst.exception;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends RuntimeException{
    private long id;
    public ProductNotFoundException(Long id,String m){
        super(m);
        this.id = id;
    }
}
