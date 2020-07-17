package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class FeatureTypeModel {

    @JsonProperty("idFeatureType")
    private Long idFeatureType;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("level")
    private int level;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("modified")
    private Date modified;
}
