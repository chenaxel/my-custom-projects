package com.axel.expressapi.service;

import com.axel.expressapi.common.Pair;
import com.kuaidi100.sdk.response.QueryTrackMapResp;
import com.kuaidi100.sdk.response.QueryTrackResp;

import java.util.List;

public interface ExpressService {
    List<Pair<String, String>> processExpressCompany();

    QueryTrackResp query(String trackNum, String code) throws Exception;

    QueryTrackMapResp queryMapTrack(String trackNum, String code, String from, String to) throws Exception;
}
