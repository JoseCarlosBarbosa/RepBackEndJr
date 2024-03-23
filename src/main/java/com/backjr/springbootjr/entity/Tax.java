package com.backjr.springbootjr.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tax_tb")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCompany;
    private Double value;

}
