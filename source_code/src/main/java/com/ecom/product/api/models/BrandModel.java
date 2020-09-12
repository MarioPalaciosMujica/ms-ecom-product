package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BrandModel {

    @JsonProperty("idBrand")
    private Long idBrand;

    @JsonProperty("name")
    private String name;

    @JsonProperty("created")
    private String created;

    @JsonProperty("modified")
    private String modified;

    @JsonProperty("image")
    private ImageModel image;
}
