package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class ProductTaxModel {

    @JsonProperty("idTax")
    private Long idTax;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("percentage")
    private BigDecimal percentage;

    @JsonProperty("fixedAmount")
    private BigDecimal fixedAmount;

    @JsonProperty("isActive")
    private boolean isActive;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("modified")
    private Date modified;
}
