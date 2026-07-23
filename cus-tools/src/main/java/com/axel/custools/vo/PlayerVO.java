package com.axel.custools.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PlayerVO {
    @JsonProperty("account_id")
    private Long accountId;
    @JsonProperty("player_slot")
    private Integer playerSlot;
    @JsonProperty("team_number")
    private Integer teamNumber;
    @JsonProperty("team_slot")
    private Integer teamSlot;
    @JsonProperty("hero_id")
    private Integer heroId;
    @JsonProperty("hero_variant")
    private Integer heroVariant;
    private String heroName;
}
