package com.example.food.controller;

import com.example.food.Entity.Customer;
import com.example.food.dto.CustomerRequest;
import com.example.food.dto.LoginRequest;
import com.example.food.repo.CustomerRepo;
import com.example.food.service.CustomerService;
import com.example.food.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/login")
public class LoginController {
    private final LoginService LoginService;

    @PostMapping
    public ResponseEntity<String> authenticateUser(@RequestBody @Valid LoginRequest request){
//        (CustomerRepo.existsByEmail(request.getEmail()) != null)
        return ResponseEntity.ok(LoginService.login(request));

    }


}
