package com.michaelrichardhall.companySearch.TruProxyAPI.responses;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TruProxyAPIMatches {
    private List<Integer> title;
}
