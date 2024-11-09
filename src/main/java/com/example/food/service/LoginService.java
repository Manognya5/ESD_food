package com.example.food.service;

import com.example.food.Entity.Customer;
import com.example.food.dto.CustomerRequest;
import com.example.food.dto.LoginRequest;
import com.example.food.mapper.CustomerMapper;
import com.example.food.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class LoginService {
    private final CustomerRepo repo;
    private final CustomerMapper mapper;

    public String findByEmail(String email, String password) {
        Optional<Customer> customer = Optional.ofNullable(repo.findByEmail(email));
        if  (customer.isPresent()) {
            if (customer.get().getPassword().equals(password)) {
                return "Valid";
            }
            else {
                return "invalid";
            }
        }
        return "nouser";
    }

    public String login(LoginRequest request) {
        String result = findByEmail(request.email(), request.password());

        if (result.equals("Valid")) {
            return "customer logged in";
        }
        if (result.equals("invalid")) {
            return "incorrect password";
        }
        else {
            return "customer doesn't exist";
        }
    }
}
