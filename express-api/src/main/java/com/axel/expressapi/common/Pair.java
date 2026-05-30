package com.axel.expressapi.common;

import lombok.Data;

@Data
public class Pair <F, S>{
    private F f;
    private S s;

    public Pair(F f, S s) {
        this.f = f;
        this.s = s;
    }
}

