package com.codingshuttle.module2.advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    @JsonFormat(pattern = "hh-mm-ss dd-MM-yyyy")
    private LocalDateTime timeStamp;
    private  T data;
    private ApiError error;

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(ApiError error) {
        //calling default constructor
        this();
        this.error = error;
    }
}
