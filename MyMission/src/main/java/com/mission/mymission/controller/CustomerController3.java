package com.mission.mymission.controller;

import com.mission.mymission.dto.CustomerReqDTO;
import com.mission.mymission.dto.CustomerReqForm;
import com.mission.mymission.dto.CustomerResDTO;
import com.mission.mymission.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cpage")
@RequiredArgsConstructor
public class CustomerController3 {
    private final CustomerService customerService;

    // 목록 출력
    @GetMapping("/index")
    public ModelAndView index() {
        List<CustomerResDTO> customerResDTOList = customerService.getCustomers();
        return new ModelAndView("index", "customer", customerResDTOList);
    }

    // 등록 폼 호출
    @GetMapping("/signup")
    public String showSignUpForm(CustomerReqDTO customer) {
        return "add-customer";
    }

    // 등록
    @PostMapping("/addcustomer")
    public String addCustomer(@Valid CustomerReqDTO customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-customer"; // 이전 페이지 그대로 유지
        }
        customerService.saveCustomer(customer);
        return "redirect:/cpage/index"; // 등록 후 첫화면으로 돌아감
    }

    // 수정 폼 호출
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        CustomerResDTO customerResDTO = customerService.getCustomerById(id);
        model.addAttribute("customer", customerResDTO);
        return "update-customer";
    }

    // 수정
    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") Long id, @Valid CustomerReqForm customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("customer", customer);
            return "update-customer";
        }
        customerService.updateCustomerForm(customer);
        return "redirect:/cpage/index";
    }

    // 삭제
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/cpage/index";
    }
}
