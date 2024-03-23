package com.backjr.springbootjr.controller;


import com.backjr.springbootjr.entity.Client;
import com.backjr.springbootjr.exceptions.InvalidCpfException;
import com.backjr.springbootjr.request.ClientRequest;
import com.backjr.springbootjr.service.ClientService;
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
}
