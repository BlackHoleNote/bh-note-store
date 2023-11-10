package com.blackHoleNote.mainBack.shared.Exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ErrorResponse {

    private int code;
    private Object error;

    public ErrorResponse(int code, Object error) {
        this.code = code;
        this.error = error;
    }
}