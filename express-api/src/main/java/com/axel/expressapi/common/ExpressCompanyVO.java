package com.axel.expressapi.common;

import java.util.List;

public class ExpressCompanyVO {

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ExpressCompanyVO(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static ReturnMsgVO<List<ExpressCompanyVO>> convert(List<Pair<String, String>> pairs) {
        return new ReturnMsgVO<List<ExpressCompanyVO>>().ok(pairs
                .stream()
                .map(v -> new ExpressCompanyVO(v.getF(), v.getS()))
                .toList()
        );
    }
}
