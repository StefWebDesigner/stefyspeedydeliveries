package com.stefan.employee_applcation.requests;

import com.stefan.employee_applcation.entities.CategoryType;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterProductRequest {
    private Integer productId;
    @NotNull
    private String productName;
    @NotNull
    private String productDescription;
    @NotNull
    private Double productPrice;
    @NotNull
    private Integer productQuantity;
    @NotNull
    private CategoryType productCategory;
}
