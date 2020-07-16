package com.ecom.product.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class FeaturedProductModel {

    private Long idFeaturedProduct;
    private Date created;
    private Date modified;
    private FeatureTypeModel featureType;
    private ProductModel product;
}
