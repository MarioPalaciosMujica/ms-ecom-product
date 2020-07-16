package com.ecom.product.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class TaxModel {

    private Long idTax;
    private String name;
    private String description;
    private BigDecimal percentage;
    private BigDecimal fixedPrice;
    private boolean isActive;
    private Date created;
    private Date modified;
}
