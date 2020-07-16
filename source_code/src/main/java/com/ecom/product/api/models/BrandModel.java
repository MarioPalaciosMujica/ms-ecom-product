package com.ecom.product.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class BrandModel {

    private Long idBrand;
    private String name;
    private Date created;
    private Date modified;
    private ImageModel image;
}
