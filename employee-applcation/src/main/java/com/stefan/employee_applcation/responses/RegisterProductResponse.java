package com.stefan.employee_applcation.responses;

import com.stefan.employee_applcation.entities.CategoryType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterProductResponse {
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productQuantity;
    private CategoryType productCategory;
}
