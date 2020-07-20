package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CollectionModel {

    @JsonProperty("idCollection")
    private Long idCollection;

    @JsonProperty("name")
    private String name;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("modified")
    private Date modified;
}
