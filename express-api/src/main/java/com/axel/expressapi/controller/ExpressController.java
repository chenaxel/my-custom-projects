package com.axel.expressapi.controller;

import com.axel.expressapi.common.ExpressCompanyVO;
import com.axel.expressapi.common.ReturnMsgVO;
import com.axel.expressapi.service.ExpressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("express")
public class ExpressController {

    private final ExpressService expressService;

    public ExpressController(ExpressService expressService) {
        this.expressService = expressService;
    }

    @GetMapping("queryExpress")
    public ReturnMsgVO<List<ExpressCompanyVO>> queryExpress() {
        return ExpressCompanyVO.convert(expressService.processExpressCompany());
    }

    @GetMapping("query")
    public ReturnMsgVO<String> query() {
        return new ReturnMsgVO<String>().ok();
    }
}
