package com.mission.mymission.controller;

import com.mission.mymission.entity.Customer;
import com.mission.mymission.exception.BusinessException;
import com.mission.mymission.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        Customer customer = optionalCustomer.orElseThrow(() -> new BusinessException("Customer Not Found", HttpStatus.NOT_FOUND));
        return customer;
    }

    @GetMapping("/email/{email}")
    public Customer getCustomerByEmail(@PathVariable String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("Email이 존재하지 않습니다", HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public List<Customer> getCustomerByName(@PathVariable String name) {
        return customerRepository.findByName(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
       Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Customer Not Found", HttpStatus.NOT_FOUND));
        customerRepository.delete(customer);
        return ResponseEntity.ok(id + " User가 삭제 되었습니다");
    }
}
