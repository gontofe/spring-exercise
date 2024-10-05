package com.michaelrichardhall.companySearch.TruProxyAPI.responses;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TruProxyAPICompanyOfficersSearchResponse {
    private String etag;
    private TruProxyAPISelfLink links;
    private String kind;
    private int items_per_page;
    private List<TruProxyAPIOfficer> items;
}
