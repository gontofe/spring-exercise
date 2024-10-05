package com.michaelrichardhall.companySearch.TruProxyAPI.responses;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TruProxyAPICompanySearchResponse {
    private int page_number;
    private String kind;
    private int total_results;
    private List<TruProxyAPICompany> items;
}
