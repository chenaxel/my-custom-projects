package com.axel.custools.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MatchResultVO {
    private Integer status;
    @JsonProperty("num_results")
    private Integer numResults;
    @JsonProperty("total_results")
    private Integer totalResults;
    @JsonProperty("results_remaining")
    private Integer resultsRemaining;
    private List<MatchVO> matches;
}
