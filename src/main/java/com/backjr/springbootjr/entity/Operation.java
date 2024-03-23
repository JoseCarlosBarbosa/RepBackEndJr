package com.backjr.springbootjr.entity;

import com.backjr.springbootjr.enums.TaxType;
import com.backjr.springbootjr.request.CreateClienteOperationRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.font.OpenType;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="operation_tb")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idOperation;
    private Double value;
    @ManyToOne
    private Company company;
    @ManyToOne
    private Client client;

    @Enumerated(EnumType.STRING)
    private TaxType type;


    /*
      public Company (CompanyRequest companyRequest){
        super.setName(companyRequest.getName());
        this.cnpj = companyRequest.getCnpj();
        this.email = companyRequest.getEmail();
    }
     */
    public Operation (CreateClienteOperationRequest createClienteOperationRequest, Long client){
        Company company = new Company();
        company.setIdCompany(createClienteOperationRequest.getIdCompany());

        Client newClient = new Client();
        newClient.setIdClient(client);

        this.company = company;
       this.type = createClienteOperationRequest.getType();
       this.value = createClienteOperationRequest.getValue();
       this.client = newClient;
    }

}
