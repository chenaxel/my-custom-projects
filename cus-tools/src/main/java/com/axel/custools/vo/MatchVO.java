package com.axel.custools.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MatchVO {
    @JsonProperty("match_id")
    private Long matchId;
    @JsonProperty("match_seq_num")
    private Long matchSeqNum;
    @JsonProperty("start_time")
    private Long startTime;
    @JsonProperty("lobby_type")
    private Integer lobbyType;
    @JsonProperty("radiant_team_id")
    private Long radiantTeamId;
    @JsonProperty("dire_team_id")
    private Integer direTeamId;
    private List<PlayerVO> players;
}
