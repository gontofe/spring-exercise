package com.michaelrichardhall.companySearch.TruProxyAPI.gateway;

import com.michaelrichardhall.companySearch.TruProxyAPI.responses.TruProxyAPICompany;
import com.michaelrichardhall.companySearch.TruProxyAPI.responses.TruProxyAPICompanyOfficersSearchResponse;
import com.michaelrichardhall.companySearch.TruProxyAPI.responses.TruProxyAPICompanySearchResponse;
import com.michaelrichardhall.companySearch.TruProxyAPI.responses.TruProxyAPIOfficer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Gateway {
    public List<TruProxyAPICompany> searchCompanies(String query) {
        TruProxyAPICompanySearchResponse response = TruProxyAPICompanySearchResponse.builder().build();
        return response.getItems();
    }

    public List<TruProxyAPIOfficer> getCompanyOfficersByCompanyNumber(String companyNumber) {
        TruProxyAPICompanyOfficersSearchResponse response = TruProxyAPICompanyOfficersSearchResponse.builder().build();
        return response.getItems();
    }
}
