package com.michaelrichardhall.companySearch.TruProxyAPI.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TruProxyAPIAddress {
    private String premises;
    private String postal_code;
    private String country;
    private String locality;
    private String address_line_1;
}
