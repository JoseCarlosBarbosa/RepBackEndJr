package com.backjr.springbootjr.exceptions;


import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "CPF Invalido.")
public class InvalidCpfException extends Exception{

}
