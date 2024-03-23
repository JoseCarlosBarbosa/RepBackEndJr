package com.backjr.springbootjr.entity;


import com.backjr.springbootjr.request.ClientRequest;
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
@Table(name="client_tb")
public class Client extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idClient;
    private String cpf;

    public Client (ClientRequest clientRequest){
        super.setName(clientRequest.getName());
        this.cpf = clientRequest.getCpf();

    }
    @OneToMany
    private List<Operation> operationList;
}
