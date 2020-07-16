package com.ecom.product.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class FeatureTypeModel {

    private Long idFeatureType;
    private String name;
    private String description;
    private int level;
    private Date created;
    private Date modified;
}
