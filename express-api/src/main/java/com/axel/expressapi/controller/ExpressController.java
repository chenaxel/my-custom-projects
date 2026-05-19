package com.axel.expressapi.controller;

import com.axel.expressapi.common.ReturnMsgVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("express")
public class ExpressController {

    @GetMapping("query")
    public ReturnMsgVO<String> query() {
        return new ReturnMsgVO<String>().ok();
    }
}
