package com.stefan.employee_applcation.controller;

import com.stefan.employee_applcation.exceptions.NoProductFoundException;
import com.stefan.employee_applcation.exceptions.ProductException;
import com.stefan.employee_applcation.requests.RegisterProductRequest;
import com.stefan.employee_applcation.requests.UpdateProductRequest;
import com.stefan.employee_applcation.responses.ProductResponse;
import com.stefan.employee_applcation.responses.RegisterProductResponse;
import com.stefan.employee_applcation.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RegisterProductResponse> createProduct(@RequestBody @Valid RegisterProductRequest  registerProductRequest) {
        RegisterProductResponse result = productService.createProduct(registerProductRequest);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            throw new ProductException("Product failed to be created. Check all fields please");
        }
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> result = productService.fetchAllProducts();
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            throw new NoProductFoundException("No products available at this moment");
        }
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody @Valid UpdateProductRequest request) {
        ProductResponse result = productService.updateProduct(request);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
        } else {
            throw new ProductException("Check all fields. Bad Request when updating product");
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable Integer id) {
        ProductResponse result = productService.deleteProduct(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
        } else {
            throw new NoProductFoundException("Product Id not found.");
        }
    }

}
