package com.manjari.productservicesst.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {
    String setMessage;
    String setResolution;
    public ExceptionDto(){
        setMessage = "";
        setResolution = "";
    }
}
