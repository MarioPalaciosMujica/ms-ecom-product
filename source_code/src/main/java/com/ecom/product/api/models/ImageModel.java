package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageModel {

    @JsonProperty("idImage")
    private Long idImage;

    @JsonProperty("alt")
    private String alt;

    @JsonProperty("src")
    private String src;

    @JsonProperty("created")
    private String created;

    @JsonProperty("modified")
    private String modified;
}
