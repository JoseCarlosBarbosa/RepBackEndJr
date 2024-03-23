package com.backjr.springbootjr.service;


import com.backjr.springbootjr.entity.Client;
import com.backjr.springbootjr.exceptions.InvalidCnpjException;
import com.backjr.springbootjr.exceptions.InvalidCpfException;
import com.backjr.springbootjr.repository.ClientRepository;
import com.backjr.springbootjr.request.ClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClientService {
    @Autowired
    public ClientRepository clientRepository;

    public Client create(ClientRequest clientRequest) throws InvalidCpfException {
        Client client = new Client(clientRequest);

        if(!validarCPF(clientRequest.getCpf())){
            throw new InvalidCpfException();
        }

        Client clientCreated = clientRepository.save(client);
        return clientCreated;
    }

    public static boolean validarCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }

        // Verifica se os dígitos verificadores estão corretos
        return Character.getNumericValue(cpf.charAt(9)) == digito1 &&
                Character.getNumericValue(cpf.charAt(10)) == digito2;
    }


}
