package com.example.food.service;

import com.example.food.Entity.Customer;
import com.example.food.dto.CustomerRequest;
import com.example.food.mapper.CustomerMapper;
import com.example.food.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        repo.save(customer);
        return "Created customer";
    }

}
