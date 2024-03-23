package com.backjr.springbootjr.entity;

import com.backjr.springbootjr.enums.TaxType;
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
@Table(name="operation_tb")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idOperation;

    private Double value;

    @Enumerated(EnumType.STRING)
    private TaxType type;



}
