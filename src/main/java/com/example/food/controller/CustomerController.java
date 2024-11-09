package com.example.food.controller;

import com.example.food.dto.CustomerRequest;
import com.example.food.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
//        return ResponseEntity.status.toString();
        return ResponseEntity.ok(customerService.createCustomer(request));
    };
    @GetMapping
    public ResponseEntity<String>  check() {
        return ResponseEntity.ok("Working");
    }

}
