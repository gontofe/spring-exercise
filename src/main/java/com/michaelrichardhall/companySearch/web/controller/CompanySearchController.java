package com.michaelrichardhall.companySearch.web.controller;

import com.michaelrichardhall.companySearch.web.dto.Company;
import com.michaelrichardhall.companySearch.web.dto.CompanySearchRequest;
import com.michaelrichardhall.companySearch.web.dto.CompanySearchResponse;
import com.michaelrichardhall.companySearch.web.service.CompanySearchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanySearchController {

    @Autowired
    CompanySearchService companySearchService;

    @GetMapping()
    public CompanySearchResponse getCompaniesByCompanyNameAndNumber(@Valid @RequestBody CompanySearchRequest request) {
        List<Company> companies = new ArrayList<>();
        if (request.getCompanyNumber() != null) {
            companies = companySearchService.getCompanyByCompanyNumber(request.getCompanyNumber());
        } else {
            companies = companySearchService.getCompanyByCompanyName(request.getCompanyName());
        }
        return CompanySearchResponse.builder().items(companies).total_results(companies.size()).build();
    }
}
