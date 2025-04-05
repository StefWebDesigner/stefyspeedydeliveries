package com.stefan.employee_applcation.utility;

import com.stefan.employee_applcation.entities.CategoryType;
import com.stefan.employee_applcation.entities.Product;
import com.stefan.employee_applcation.requests.RegisterProductRequest;
import com.stefan.employee_applcation.responses.ProductResponse;
import com.stefan.employee_applcation.responses.RegisterProductResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static RegisterProductResponse productToRegistrationProductResponse(Product product) {
        RegisterProductResponse response = RegisterProductResponse.builder()
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productPrice(product.getProductPrice())
                .productQuantity(product.getProductQuantity())
                .productCategory(CategoryType.valueOf(String.valueOf(product.getProductCategory())))
                .build();
        return response;
    }

    public static List<ProductResponse> listProductsToProductResponses(List<Product> products) {
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products) {
            ProductResponse response = ProductResponse.builder()
                    .productId(product.getProductId())
                    .productName(product.getProductName())
                    .productDescription(product.getProductDescription())
                    .productPrice(product.getProductPrice())
                    .productQuantity(product.getProductQuantity())
                    .productCategory(CategoryType.valueOf(String.valueOf(product.getProductCategory())))
                    .build();
            productResponses.add(response);
        }
        return productResponses;
    }

    public static ProductResponse productsToProductResponses(Product product) {
            ProductResponse response = ProductResponse.builder()
                    .productId(product.getProductId())
                    .productName(product.getProductName())
                    .productDescription(product.getProductDescription())
                    .productPrice(product.getProductPrice())
                    .productQuantity(product.getProductQuantity())
                    .productCategory(CategoryType.valueOf(String.valueOf(product.getProductCategory())))
                    .build();

        return response;
    }




}
