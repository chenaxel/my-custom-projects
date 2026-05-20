package com.axel.expressapi.common;

public class Pair <F, S>{
    private F f;
    private S s;

    public F getF() {
        return f;
    }

    public void setF(F f) {
        this.f = f;
    }

    public S getS() {
        return s;
    }

    public void setS(S s) {
        this.s = s;
    }

    public Pair(F f, S s) {
        this.f = f;
        this.s = s;
    }
}

