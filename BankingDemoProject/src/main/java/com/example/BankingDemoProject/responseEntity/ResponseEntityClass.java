package com.example.BankingDemoProject.responseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseEntityClass<T> {
    private T data;
    private String message;


    public ResponseEntityClass(T data, String message ) {
        this.data = data;
        this.message = message;
    }
}
