package com.stefan.employee_applcation.controller;

import com.stefan.employee_applcation.exceptions.ProductException;
import com.stefan.employee_applcation.requests.RegisterProductRequest;
import com.stefan.employee_applcation.responses.RegisterProductResponse;
import com.stefan.employee_applcation.service.PurchasingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/purchase")
@RequiredArgsConstructor
public class PurchasingController {

    private final PurchasingService purchasingService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<RegisterProductResponse> createCard(@RequestBody @Valid RegisterProductRequest registerProductRequest) {
//        RegisterProductResponse result = productService.createProduct(registerProductRequest);
//        if (result != null) {
//            return new ResponseEntity<>(result, HttpStatus.CREATED);
//        } else {
//            throw new ProductException("Product failed to be created. Check all fields please");
//        }
        return null;
    }


    // Add order functionalilty


    // alert functinality for when quantity is low



}
