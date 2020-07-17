package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class FeaturedProductModel {

    @JsonProperty("id_featured_product")
    private Long idFeaturedProduct;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("modified")
    private Date modified;

    @JsonProperty("feature_type")
    private FeatureTypeModel featureType;

    @JsonProperty("product")
    private ProductModel product;
}
