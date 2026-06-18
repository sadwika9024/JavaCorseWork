package com.pabbasadwika.module4.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ErrorDto {

    private LocalDateTime time;
    private String errorMessage;
    private Long statusCode;

}
