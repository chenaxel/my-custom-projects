package com.axel.custools.controller;

import com.axel.common.constant.ReturnMsgVO;
import com.axel.custools.service.DotaMatchService;
import com.axel.custools.vo.MatchResultVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dota")
public class DotaMatchController {

    private final DotaMatchService dotaMatchService;

    public DotaMatchController(DotaMatchService dotaMatchService) {
        this.dotaMatchService = dotaMatchService;
    }

    @GetMapping("/player/{steamId}/matches")
    public ReturnMsgVO<MatchResultVO> getPlayerMatchList(@PathVariable Long steamId, @RequestParam(required = false) Long startSeq) {
        return dotaMatchService.getMatchHistory(steamId, startSeq);
    }
}
