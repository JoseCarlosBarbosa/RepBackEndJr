package com.backjr.springbootjr.repository;


import com.backjr.springbootjr.entity.Operation;
import org.springframework.data.repository.CrudRepository;

public interface OperationRepository extends CrudRepository<Operation, Long> {
}
