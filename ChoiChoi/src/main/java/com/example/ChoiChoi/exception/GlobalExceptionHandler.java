package com.example.ChoiChoi.exception;

import com.example.ChoiChoi.dto.Request.ApiResponse;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception){
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(ErorrCode.UNCATEGORIZED_EXECPTION.getCode());
        apiResponse.setMessage(ErorrCode.UNCATEGORIZED_EXECPTION.getMessage());

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException exception){
        ErorrCode erorrCode = exception.getErorrCode();

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(erorrCode.getCode());

        apiResponse.setMessage(erorrCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException exception){
        String enumkey = exception.getFieldError().getDefaultMessage();


        ErorrCode erorrCode = ErorrCode.KEY_INVALID;
        try {
             erorrCode = ErorrCode.valueOf(enumkey);
        }catch(IllegalArgumentException e){

        }

        ApiResponse apiResponse = new ApiResponse();


        apiResponse.setCode(erorrCode.getCode());
        apiResponse.setMessage(erorrCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);

    }

}
