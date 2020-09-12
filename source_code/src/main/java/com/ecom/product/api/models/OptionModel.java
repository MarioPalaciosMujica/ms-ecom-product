package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OptionModel {

    @JsonProperty("idOption")
    private Long idOption;

    @JsonProperty("optionName")
    private int optionName;

}
