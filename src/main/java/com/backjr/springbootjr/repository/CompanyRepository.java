package com.backjr.springbootjr.repository;

import com.backjr.springbootjr.entity.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
