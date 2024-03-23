package com.backjr.springbootjr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "CNPJ Invalido.")
public class InvalidCnpjException extends Exception{

}




