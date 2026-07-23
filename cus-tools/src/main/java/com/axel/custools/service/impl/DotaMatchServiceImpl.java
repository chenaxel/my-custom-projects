package com.axel.custools.service.impl;

import com.axel.common.constant.EnumReturnCodeInfo;
import com.axel.common.constant.ReturnMsgVO;
import com.axel.custools.config.DotaHeroConst;
import com.axel.custools.config.DotaSteamConfigProperties;
import com.axel.custools.constant.ApiResponse;
import com.axel.custools.constant.ConstantSteamUrl;
import com.axel.custools.service.DotaMatchService;
import com.axel.custools.vo.MatchResultVO;
import com.axel.custools.vo.MatchVO;
import com.axel.custools.vo.PlayerVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class DotaMatchServiceImpl implements DotaMatchService {

    @Resource
    private WebClient webClient;
    @Resource
    private DotaSteamConfigProperties steamConfig;

    /**
     * 泛型标记：接收Steam原始外层 { "result": {...} }
     */
    private static final ParameterizedTypeReference<ApiResponse<MatchResultVO>> RESP_TYPE
            = new ParameterizedTypeReference<ApiResponse<MatchResultVO>>() {};

    @Override
    public ReturnMsgVO<MatchResultVO> getMatchHistory(Long steamId, Long startSeq) {
        try {
            WebClient.RequestHeadersSpec<?> requestSpec = webClient.get()
                    .uri(ConstantSteamUrl.STEAM_DOTA_GET_MATCH_HISTORY_URL, uriBuilder -> {
                        uriBuilder
                                .queryParam("account_id", steamId)
                                .queryParam("key", steamConfig.getApiKey())
                                .queryParam("matches_requested", steamConfig.getPageSize());
                        if (startSeq != null && startSeq > 0) {
                            uriBuilder.queryParam("start_match_seq_num", startSeq);
                        }
                        return uriBuilder.build();
                    });
            requestSpec.header("content-type", "application/json");
            ApiResponse<MatchResultVO> steamResp = requestSpec.retrieve()
                    .bodyToMono(RESP_TYPE)
                    .block();

            if (steamResp == null || steamResp.getResult() == null) {
                ReturnMsgVO<MatchResultVO> res = new ReturnMsgVO<>();
                res.setCode(EnumReturnCodeInfo.ERROR.getCode());
                res.setMessage("Steam接口未返回对局数据");
                return res;
            }

            MatchResultVO result = steamResp.getResult();
            // 填充英雄名称
            for (MatchVO match : result.getMatches()) {
                for (PlayerVO player : match.getPlayers()) {
                    player.setHeroName(DotaHeroConst.getHeroName(player.getHeroId()));
                }
            }

            // 成功，对局数据放入data
            return new ReturnMsgVO<MatchResultVO>().ok(result);
        } catch (WebClientResponseException e) {
            throw new RuntimeException("Steam接口调用失败，状态码：" + e.getStatusCode());
        }
    }
}
