package com.stefan.employee_applcation.service;

import com.stefan.employee_applcation.entities.CategoryType;
import com.stefan.employee_applcation.entities.Product;
import com.stefan.employee_applcation.repository.ProductRepository;
import com.stefan.employee_applcation.requests.RegisterProductRequest;
import com.stefan.employee_applcation.requests.UpdateProductRequest;
import com.stefan.employee_applcation.responses.ProductResponse;
import com.stefan.employee_applcation.responses.RegisterProductResponse;
import com.stefan.employee_applcation.utility.ProductMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public RegisterProductResponse createProduct(RegisterProductRequest registerProductRequest) {
        Product savedProduct = Product.builder()
                .productId(null)
                .productName(registerProductRequest.getProductName())
                .productDescription(registerProductRequest.getProductDescription())
                .productPrice(registerProductRequest.getProductPrice())
                .productCategory(registerProductRequest.getProductCategory())
                .productQuantity(registerProductRequest.getProductQuantity())
                .build();
        productRepository.save(savedProduct);
        RegisterProductResponse response = ProductMapper.productToRegistrationProductResponse(savedProduct);
        return response;
    }


    public List<ProductResponse> fetchAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> allCurrentProducts = ProductMapper.listProductsToProductResponses(products);
        return allCurrentProducts;
    }

    public ProductResponse updateProduct(@Valid UpdateProductRequest productRequest) {
        Optional<Product> fetchedProduct = productRepository.findById(productRequest.getProductId());
        if (fetchedProduct.isPresent()) {
            Product modfiedProduct = Product.builder()
                    .productId(productRequest.getProductId())
                    .productName(productRequest.getProductName())
                    .productDescription(productRequest.getProductDescription())
                    .productPrice(productRequest.getProductPrice())
                    .productCategory(productRequest.getProductCategory())
                    .productQuantity(productRequest.getProductQuantity())
                    .build();

                    productRepository.save(modfiedProduct);

                    ProductResponse convertedProduct = ProductMapper.productsToProductResponses(modfiedProduct);
                    return convertedProduct;
            } else {
            return null;
        }
    }

    public ProductResponse deleteProduct(Integer id) {
        Optional<Product> fetchedProduct = productRepository.findById(id);
        if(fetchedProduct.isPresent()) {
            productRepository.deleteById(id);
            ProductResponse deletedProduct = ProductMapper.productsToProductResponses(fetchedProduct.get());
            return deletedProduct;
        } else {
            return null;
        }
    }
}
