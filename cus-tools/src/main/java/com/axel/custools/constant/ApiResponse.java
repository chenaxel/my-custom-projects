package com.axel.custools.constant;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private T result;
}
