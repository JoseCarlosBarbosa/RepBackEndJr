package com.backjr.springbootjr.controller;


import com.backjr.springbootjr.entity.Company;
import com.backjr.springbootjr.exceptions.InvalidCnpjException;
import com.backjr.springbootjr.exceptions.InvalidCpfException;
import com.backjr.springbootjr.request.CompanyRequest;
import com.backjr.springbootjr.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping(path ="/company")
    public ResponseEntity<Company> create(@RequestBody CompanyRequest companyRequest) throws InvalidCnpjException {
        Company company = companyService.create(companyRequest);
        return ResponseEntity.ok(company);
    }

}
