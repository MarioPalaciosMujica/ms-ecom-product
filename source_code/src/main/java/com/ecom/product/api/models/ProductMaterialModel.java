package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductMaterialModel {

    @JsonProperty("idProductMaterial")
    private Long idProductMaterial;

    @JsonProperty("metricUnits")
    private BigDecimal metricUnits;

    @JsonProperty("idMaterial")
    private Long idMaterial;

}
