package com.ecom.product.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class ProductDiscountModel {

    private Long idDiscount;
    private String name;
    private String description;
    private BigDecimal percentage;
    private BigDecimal fixedAmount;
    private Date validUntil;
    private boolean isActive;
    private Date created;
    private Date modified;
}
