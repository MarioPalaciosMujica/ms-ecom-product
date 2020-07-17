package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class BrandModel {

    @JsonProperty("idBrand")
    private Long idBrand;

    @JsonProperty("name")
    private String name;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("modified")
    private Date modified;

    @JsonProperty("image")
    private ImageModel image;
}
