package com.backjr.springbootjr.repository;


import com.backjr.springbootjr.entity.Tax;
import org.springframework.data.repository.CrudRepository;

public interface TaxRepository extends CrudRepository<Tax, Long> {
}
