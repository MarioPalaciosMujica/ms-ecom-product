package com.ecom.product.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MaterialModel {

    private Long idMaterial;
    private String barcode;
    private String name;
    private String description;
    private Date created;
    private Date modified;
}
