package com.backjr.springbootjr.service;


import com.backjr.springbootjr.entity.Company;
import com.backjr.springbootjr.entity.Tax;
import com.backjr.springbootjr.exceptions.InvalidCnpjException;
import com.backjr.springbootjr.exceptions.InvalidCpfException;
import com.backjr.springbootjr.repository.CompanyRepository;
import com.backjr.springbootjr.request.CompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

  @Autowired
    public CompanyRepository companyRepository;

    public Company create(CompanyRequest companyRequest) throws InvalidCnpjException {
        Company company = new Company(companyRequest);

        if(!validarCNPJ(companyRequest.getCnpj())){
            throw new InvalidCnpjException();
        }

        Company companyCreated = companyRepository.save(company);
        Tax tax = new Tax();
        tax.setValue(companyRequest.getTax());
        tax.setIdCompany(companyCreated.getIdCompany());
        return companyCreated;
    }

    // Função para validar CNPJ
    public boolean validarCNPJ(String cnpj) {
        // Remove caracteres não numéricos
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // Verifica se o CNPJ possui 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        int peso = 5;
        for (int i = 0; i < 12; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * peso;
            peso = (peso == 2) ? 9 : peso - 1;
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        peso = 6;
        for (int i = 0; i < 13; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * peso;
            peso = (peso == 2) ? 9 : peso - 1;
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }

        // Verifica se os dígitos verificadores estão corretos
        return Character.getNumericValue(cnpj.charAt(12)) == digito1 &&
                Character.getNumericValue(cnpj.charAt(13)) == digito2;
    }


    }
