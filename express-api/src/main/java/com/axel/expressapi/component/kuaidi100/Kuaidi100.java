package com.axel.expressapi.component.kuaidi100;

import com.axel.expressapi.config.Kuaidi100Config;
import com.google.gson.Gson;
import com.kuaidi100.sdk.api.QueryTrack;
import com.kuaidi100.sdk.api.QueryTrackMap;
import com.kuaidi100.sdk.core.IBaseClient;
import com.kuaidi100.sdk.pojo.HttpResult;
import com.kuaidi100.sdk.request.QueryTrackParam;
import com.kuaidi100.sdk.request.QueryTrackReq;
import com.kuaidi100.sdk.response.QueryTrackMapResp;
import com.kuaidi100.sdk.response.QueryTrackResp;
import com.kuaidi100.sdk.utils.SignUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kuaidi100 {

    private final Kuaidi100Config config;
    private static final Logger log = LoggerFactory.getLogger(Kuaidi100.class);

    public Kuaidi100(Kuaidi100Config config) {
        this.config = config;
    }

    /**
     * 实时快递查询
     */
    public QueryTrackResp query(String trackNum, String code) throws Exception {
        QueryTrackReq queryTrackReq = new QueryTrackReq();
        QueryTrackParam queryTrackParam = new QueryTrackParam();
        queryTrackParam.setCom(code);
        queryTrackParam.setNum(trackNum);
        queryTrackParam.setPhone(config.getPhone());
        String param = new Gson().toJson(queryTrackParam);

        queryTrackReq.setParam(param);
        queryTrackReq.setCustomer(config.getCustomer());
        queryTrackReq.setSign(SignUtils.querySign(param, config.getKey(), config.getCustomer()));

        IBaseClient client = new QueryTrack();
        HttpResult result = client.execute(queryTrackReq);
        log.info(result.getBody());
        return new QueryTrackResp();
    }

    public QueryTrackMapResp queryMapTrack(String num, String code, String from, String to) throws Exception {
        QueryTrackReq queryTrackReq = new QueryTrackReq();
        QueryTrackParam queryTrackParam = new QueryTrackParam();
        queryTrackParam.setCom(code);
        queryTrackParam.setNum(num);
        queryTrackParam.setPhone(config.getPhone());
        queryTrackParam.setFrom(from);
        queryTrackParam.setTo(to);
        queryTrackParam.setResultv2("2");
        String param = new Gson().toJson(queryTrackParam);

        queryTrackReq.setParam(param);
        queryTrackReq.setCustomer(config.getCustomer());
        queryTrackReq.setSign(SignUtils.querySign(param, config.getKey(), config.getCustomer()));

        IBaseClient baseClient = new QueryTrackMap();
        HttpResult result = baseClient.execute(queryTrackReq);

        QueryTrackMapResp queryTrackMapResp = new Gson().fromJson(result.getBody(), QueryTrackMapResp.class);
        log.info(queryTrackMapResp.getTrailUrl());
        return queryTrackMapResp;
    }
}
