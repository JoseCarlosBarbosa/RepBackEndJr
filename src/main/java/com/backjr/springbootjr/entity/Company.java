package com.backjr.springbootjr.entity;


import com.backjr.springbootjr.request.CompanyRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="company_tb")
public class Company extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCompany;
    private String cnpj;
    private Long balance;
    private String email;

    @OneToMany
    private List<Operation> operationList;
    @OneToMany
    private List<Tax> taxList;

    public Company (CompanyRequest companyRequest){
        super.setName(companyRequest.getName());
        this.cnpj = companyRequest.getCnpj();
        this.email = companyRequest.getEmail();
    }
}
