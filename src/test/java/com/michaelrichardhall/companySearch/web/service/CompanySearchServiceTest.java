package com.michaelrichardhall.companySearch.web.service;

import com.michaelrichardhall.companySearch.TruProxyAPI.gateway.Gateway;
import com.michaelrichardhall.companySearch.TruProxyAPI.responses.TruProxyAPIAddress;
import com.michaelrichardhall.companySearch.TruProxyAPI.responses.TruProxyAPICompany;
import com.michaelrichardhall.companySearch.web.dto.Address;
import com.michaelrichardhall.companySearch.web.dto.Company;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CompanySearchService.class})
class CompanySearchServiceTest {

    public static final String COMPANY_NAME = "Company Name";
    public static final String COMPANY_NUMBER = "0123456";

    @Autowired
    private CompanySearchService companySearchService;

    @MockBean
    private Gateway truProxyAPIGateway;

    @Test
    public void givenCompanyNameAndNumber_whenSearchByCompanyName_thenListOfCompaniesReturned() {
        // Arrange
        when(truProxyAPIGateway.searchCompanies(anyString())).thenReturn(List.of(aTruProxyAPICompany()));

        // Act
        List<Company> companies = companySearchService.getCompanyByCompanyName(COMPANY_NAME);

        // Assert
        assertEquals(1, companies.size());
        assertEquals(aCompany(), companies.getFirst());
    }

    @Test
    void getCompanyByCompanyNumber() {
        // Arrange
        when(truProxyAPIGateway.searchCompanies(anyString())).thenReturn(List.of(aTruProxyAPICompany()));

        // Act
        List<Company> companies = companySearchService.getCompanyByCompanyNumber(COMPANY_NUMBER);

        // Assert
        assertEquals(1, companies.size());
        assertEquals(aCompany(), companies.getFirst());
    }

    private Company aCompany() {
        return Company.builder()
                .address(anAddress())
                .build();
    }

    private Address anAddress() {
        return Address.builder().build();
    }

    private TruProxyAPICompany aTruProxyAPICompany() {
        return TruProxyAPICompany.builder()
                .address(aTruProxyAPIAddress())
                .build();
    }

    private TruProxyAPIAddress aTruProxyAPIAddress() {
        return TruProxyAPIAddress.builder().build();
    }
}