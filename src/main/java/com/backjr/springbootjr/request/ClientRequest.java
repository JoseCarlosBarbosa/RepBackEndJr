package com.backjr.springbootjr.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.CrudRepository;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClientRequest  {

    private String name;
    private String cpf;
}
