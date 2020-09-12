package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryModel {

    @JsonProperty("idCategory")
    private Long idCategory;

    @JsonProperty("name")
    private String name;

    @JsonProperty("created")
    private String created;

    @JsonProperty("modified")
    private String modified;

    @JsonProperty("catalogue")
    private CatalogueModel catalogue;

}
