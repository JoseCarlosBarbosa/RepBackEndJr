package com.backjr.springbootjr.controller;


import com.backjr.springbootjr.entity.Client;
import com.backjr.springbootjr.entity.Operation;
import com.backjr.springbootjr.exceptions.InvalidCpfException;
import com.backjr.springbootjr.request.ClientRequest;
import com.backjr.springbootjr.request.CreateClienteOperationRequest;
import com.backjr.springbootjr.service.ClientService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(path = "/client")
    public ResponseEntity<Client> create(@RequestBody ClientRequest clientRequest) throws InvalidCpfException {
        Client client = clientService.create(clientRequest);
        return ResponseEntity.ok(client);
    }
// criar end poit, /client/id/operation -> post  --- tipo = saque // deposito ->

    @PostMapping(path ="/client/{id}/operation")
    public ResponseEntity<Operation> createOperation(@RequestBody CreateClienteOperationRequest createClienteOperationRequest , @PathParam("id") Long id){
        Operation operation = clientService.createOperation(createClienteOperationRequest, id);
        return ResponseEntity.ok(operation);
    }

}



/*
Apos criar uma operação, findbyid no comp repository para pegar a emrpeasa pelo id que ela ta passando pra ele (clientService)
criar uma double qualquer para recuperar o balance atual (get no ) somar ou subtrair (deposito/saque) setar na companhia esse valor novo.
Lembrando da taxa.
*/
