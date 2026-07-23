package com.axel.custools.service;

import com.axel.common.constant.ReturnMsgVO;
import com.axel.custools.vo.MatchResultVO;

public interface DotaMatchService {
    ReturnMsgVO<MatchResultVO> getMatchHistory(Long steamId, Long startSeq);
}
