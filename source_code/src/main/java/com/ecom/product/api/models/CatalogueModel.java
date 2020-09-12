package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CatalogueModel {

    @JsonProperty("idCatalogue")
    private Long idCatalogue;

    @JsonProperty("catalogueName")
    private String catalogueName;

    @JsonProperty("created")
    private String created;

    @JsonProperty("modified")
    private String modified;
}
