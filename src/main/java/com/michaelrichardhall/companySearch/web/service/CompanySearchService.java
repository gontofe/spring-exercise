package com.michaelrichardhall.companySearch.web.service;

import com.michaelrichardhall.companySearch.TruProxyAPI.gateway.Gateway;
import com.michaelrichardhall.companySearch.TruProxyAPI.responses.TruProxyAPICompany;
import com.michaelrichardhall.companySearch.TruProxyAPI.responses.TruProxyAPIOfficer;
import com.michaelrichardhall.companySearch.web.dto.Company;
import com.michaelrichardhall.companySearch.web.dto.Officer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanySearchService {

    @Autowired
    private Gateway truAPIGateway;

    public List<Company> getCompanyByCompanyName(String companyName) {
        List<TruProxyAPICompany> truProxyAPICompanies = truAPIGateway.searchCompanies(companyName);
        List<Company> companies = new ArrayList<>();
        for (TruProxyAPICompany truProxyAPICompany: truProxyAPICompanies) {
            List<TruProxyAPIOfficer> truProxyAPIOfficers = truAPIGateway.getCompanyOfficersByCompanyNumber(truProxyAPICompany.getCompany_number());
            Company company = Company.getCompanyFromTruProxyAPICompany(truProxyAPICompany);
            company.setOfficers(truProxyAPIOfficers.stream().map(Officer::getOfficerFromTruProxyAPIOfficer).toList());
        }
        return truProxyAPICompanies.stream()
                .map(Company::getCompanyFromTruProxyAPICompany)
                .toList();
    }

    public List<Company> getCompanyByCompanyNumber(String companyNumber) {
        List<TruProxyAPICompany> truProxyAPICompanies = truAPIGateway.searchCompanies(companyNumber);
        return truProxyAPICompanies.stream()
                .map(Company::getCompanyFromTruProxyAPICompany)
                .toList();
    }
}
