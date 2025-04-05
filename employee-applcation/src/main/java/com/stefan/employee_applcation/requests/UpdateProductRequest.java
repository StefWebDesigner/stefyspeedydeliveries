package com.stefan.employee_applcation.requests;

import com.stefan.employee_applcation.entities.CategoryType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductRequest{
    @NotNull
    private Integer productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productQuantity;
    private CategoryType productCategory;
}
