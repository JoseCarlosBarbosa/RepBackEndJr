package com.backjr.springbootjr.request;

import com.backjr.springbootjr.enums.TaxType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateClienteOperationRequest {

    private Long idCompany;
    private Double value;
    private TaxType Type;
}
