package com.axel.expressapi.common;

import lombok.Data;

import java.util.List;

@Data
public class ExpressCompanyVO {

    private String name;
    private String code;

    public ExpressCompanyVO(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static com.axel.common.constant.ReturnMsgVO<List<ExpressCompanyVO>> convert(List<Pair<String, String>> pairs) {
        return new com.axel.common.constant.ReturnMsgVO<List<ExpressCompanyVO>>().ok(pairs
                .stream()
                .map(v -> new ExpressCompanyVO(v.getF(), v.getS()))
                .toList()
        );
    }
}
