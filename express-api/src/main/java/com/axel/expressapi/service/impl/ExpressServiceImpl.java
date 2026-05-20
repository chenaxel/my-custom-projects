package com.axel.expressapi.service.impl;

import com.axel.expressapi.common.EnumExpressCompany;
import com.axel.expressapi.common.Pair;
import com.axel.expressapi.service.ExpressService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ExpressServiceImpl implements ExpressService {

    @Override
    public List<Pair<String, String>> processExpressCompany() {
        return Arrays.stream(EnumExpressCompany.values())
                .map(v -> new Pair<>(v.getName(), v.getCode()))
                .toList();
    }
}
