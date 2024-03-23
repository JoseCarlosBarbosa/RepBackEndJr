package com.backjr.springbootjr.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CompanyRequest {
    private String name;
    private String cnpj;
    private String email;
    private Double tax;
}
