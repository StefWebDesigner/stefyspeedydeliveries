package com.stefan.employee_applcation.responses;

import com.stefan.employee_applcation.entities.CategoryType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    public Integer productId;
    public String productName;
    public String productDescription;
    public Double productPrice;
    public Integer productQuantity;
    public CategoryType productCategory;
}
