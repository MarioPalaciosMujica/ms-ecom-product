package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ImageModel {

    @JsonProperty("idImage")
    private Long idImage;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("urlImage")
    private String urlImage;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("modified")
    private Date modified;
}
