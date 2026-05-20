package com.axel.expressapi.service;

import com.axel.expressapi.common.Pair;

import java.util.List;

public interface ExpressService {
    List<Pair<String, String>> processExpressCompany();
}
