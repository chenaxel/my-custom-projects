package com.axel.expressapi.service.impl;

import com.axel.expressapi.common.EnumExpressCompany;
import com.axel.expressapi.common.Pair;
import com.axel.expressapi.component.kuaidi100.Kuaidi100;
import com.axel.expressapi.config.Kuaidi100Config;
import com.axel.expressapi.service.ExpressService;
import com.kuaidi100.sdk.response.QueryTrackMapResp;
import com.kuaidi100.sdk.response.QueryTrackResp;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ExpressServiceImpl implements ExpressService {

    private final Kuaidi100Config kuaidi100Config;

    public ExpressServiceImpl(Kuaidi100Config kuaidi100Config) {
        this.kuaidi100Config = kuaidi100Config;
    }


    @Override
    public List<Pair<String, String>> processExpressCompany() {
        return Arrays.stream(EnumExpressCompany.values())
                .map(v -> new Pair<>(v.getName(), v.getCode()))
                .toList();
    }

    @Override
    public QueryTrackResp query(String trackNum, String code) throws Exception {
        return new Kuaidi100(kuaidi100Config).query(trackNum, code);
    }

    @Override
    public QueryTrackMapResp queryMapTrack(String trackNum, String code, String from, String to) throws Exception {

        return new Kuaidi100(kuaidi100Config).queryMapTrack(trackNum, code, from, to);
    }
}
