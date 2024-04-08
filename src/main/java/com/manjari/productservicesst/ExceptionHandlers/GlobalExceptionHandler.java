package com.manjari.productservicesst.ExceptionHandlers;
import com.manjari.productservicesst.DTOs.ExceptionDto;
import com.manjari.productservicesst.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto dto  = new ExceptionDto();
        dto.setSetMessage("Arithmetic Exception");
        dto.setSetResolution("go home snd sleep!");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundsException(){
        ExceptionDto dto  = new ExceptionDto();
        dto.setSetMessage("Array Index Out Of Bounds Exception");
        dto.setSetResolution("go home snd sleep!");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handelGeneralException(){
        ExceptionDto dto  = new ExceptionDto();
        dto.setSetMessage("General Exception");
        dto.setSetResolution("go home snd sleep!");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handelProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDto dto  = new ExceptionDto();
        dto.setSetMessage("Product Not Found Exception");
        dto.setSetResolution("Invalid product id "+ productNotFoundException.getId() +" passed");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

}
