package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnitNumberModel {

    @JsonProperty("idUnitNumber")
    private Long idUnitNumber;

    @JsonProperty("unitQuantity")
    private int unitQuantity;

}
