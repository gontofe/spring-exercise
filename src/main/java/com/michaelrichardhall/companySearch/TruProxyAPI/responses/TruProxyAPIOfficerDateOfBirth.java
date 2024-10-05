package com.michaelrichardhall.companySearch.TruProxyAPI.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TruProxyAPIOfficerDateOfBirth {
    private String month;
    private String year;
}
