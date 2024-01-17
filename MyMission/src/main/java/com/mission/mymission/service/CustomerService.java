package com.mission.mymission.service;

import com.mission.mymission.dto.CustomerReqDTO;
import com.mission.mymission.dto.CustomerReqForm;
import com.mission.mymission.dto.CustomerResDTO;
import com.mission.mymission.entity.Customer;
import com.mission.mymission.exception.BusinessException;
import com.mission.mymission.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    // 등록
    public CustomerResDTO saveCustomer(CustomerReqDTO customerReqDTO) {
        Customer customer = modelMapper.map(customerReqDTO, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerResDTO.class);
    }

    // 조회
    @Transactional(readOnly = true)
    public CustomerResDTO getCustomerById(Long id) {
        Customer customerEntity = customerRepository.findById(id) // return type : Optional<Customer>
                .orElseThrow(() -> new BusinessException(id + "User Not Found", HttpStatus.NOT_FOUND));
        // Entity -> ResDTO로 변환
        CustomerResDTO customerResDTO = modelMapper.map(customerEntity, CustomerResDTO.class);
        return customerResDTO;
    }

    // 전체 목록 조회
    @Transactional(readOnly = true)
    public List<CustomerResDTO> getCustomers() {
        List<Customer> customerList = customerRepository.findAll(); // List<Customer>

        // List<Customer> -> List<CustomerResDTO>
        List<CustomerResDTO> customerResDTOList = customerList.stream() // List<Customer> -> Stream<Customer>
                .map(customer -> modelMapper.map(customer, CustomerResDTO.class)) // Stream<Customer> -> Stream<CustomerResDTO>
                .collect(toList());// Stream<CustomerResDTO> -> List<CustomerResDTO>

        return customerResDTOList;
    }

    // 수정
    public CustomerResDTO updateCustomer(String email, CustomerReqDTO customerReqDto) {
        Customer existCustomer = customerRepository.findByEmail(email)
                .orElseThrow(() ->
                        new BusinessException(email + " User Not Found", HttpStatus.NOT_FOUND));

        if (customerReqDto.getName() != null)
            existCustomer.setName(customerReqDto.getName());
        if (customerReqDto.getAge() != 0)
            existCustomer.setAge(customerReqDto.getAge());
        return modelMapper.map(existCustomer, CustomerResDTO.class); // Customer -> CustomerResDTO
    }

    public void updateCustomerForm(CustomerReqForm customerReqForm) {
        Customer exist = customerRepository.findById(customerReqForm.getId())
                                            .orElseThrow(() ->
                                                    new BusinessException(customerReqForm.getId() + " User Not Found", HttpStatus.NOT_FOUND));
        exist.setName(customerReqForm.getName());
        exist.setAge(customerReqForm.getAge());
    }

    // 삭제
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id) //Optional<Customer>
                .orElseThrow(() ->
                        new BusinessException(id + " User Not Found", HttpStatus.NOT_FOUND));
        customerRepository.delete(customer);
    }
}
