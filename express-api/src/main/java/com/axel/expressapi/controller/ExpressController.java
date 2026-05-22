package com.axel.expressapi.controller;

import com.axel.expressapi.common.ExpressCompanyVO;
import com.axel.expressapi.common.ReturnMsgVO;
import com.axel.expressapi.service.ExpressService;
import com.kuaidi100.sdk.response.QueryTrackMapResp;
import com.kuaidi100.sdk.response.QueryTrackResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ReturnMsgVO<QueryTrackResp> query(@RequestParam String trackNum, @RequestParam String code) throws Exception {
        QueryTrackResp resp = expressService.query(trackNum, code);
        return new ReturnMsgVO<QueryTrackResp>().ok(resp);
    }

    @GetMapping("mapTrack")
    public ReturnMsgVO<String> mapTrack(@RequestParam String trackNum, @RequestParam String code, @RequestParam String from, @RequestParam String to) throws Exception {
        QueryTrackMapResp resp = expressService.queryMapTrack(trackNum, code, from, to);
        return new ReturnMsgVO<String>().ok(resp.getTrailUrl());
    }
}
