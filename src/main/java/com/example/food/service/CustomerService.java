package com.example.food.service;

import com.example.food.Entity.Customer;
import com.example.food.dto.CustomerRequest;
import com.example.food.dto.CustomerResponse;
import com.example.food.exception.CustomerNotFoundException;
import com.example.food.helper.EncryptionService;
import com.example.food.helper.JWTHelper;
import com.example.food.mapper.CustomerMapper;
import com.example.food.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toEntity(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Customer Created Successfully";
    }

//    public Customer getCustomer(String email) {
//        return customerRepo.findByEmail(email)
//                .orElseThrow(() -> new CustomerNotFoundException(
//                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
//                ));
//    }

//    public CustomerResponse retrieveCustomer(String email) {
//        Customer customer = getCustomer(email);
//        return customerMapper.toCustomerResponse(customer);
//    }

}
