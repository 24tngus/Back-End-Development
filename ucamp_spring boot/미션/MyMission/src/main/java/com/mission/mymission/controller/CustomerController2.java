package com.mission.mymission.controller;

import com.mission.mymission.dto.CustomerReqDTO;
import com.mission.mymission.dto.CustomerResDTO;
import com.mission.mymission.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController2 {
    private final CustomerService customerService;

    // 등록
    @PostMapping
    public CustomerResDTO saveCustomer(@RequestBody CustomerReqDTO customerReqDTO) {
        return customerService.saveCustomer(customerReqDTO);
    }

    // 조회
    @GetMapping("/{id}")
    public CustomerResDTO getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    // 전체 목록 조회
    @GetMapping
    public List<CustomerResDTO> getCustomers() {
        return customerService.getCustomers();
    }

    // 수정
    @PatchMapping("/{email}")
    public CustomerResDTO updateCustomer(@PathVariable String email, @RequestBody CustomerReqDTO customerReqDTO) {
        return customerService.updateCustomer(email, customerReqDTO);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(id + " Customer가 삭제처리 되었습니다.");
    }
}
