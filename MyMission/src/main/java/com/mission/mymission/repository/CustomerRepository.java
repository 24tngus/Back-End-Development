package com.mission.mymission.repository;

import com.mission.mymission.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // < Entity 클래스, PK값 >
    // Insert, Delete, Select만 존재

    // select * from account where username = 'spring'
    Optional<Customer> findByEmail(String email);
    List<Customer> findByName(String name);
}
