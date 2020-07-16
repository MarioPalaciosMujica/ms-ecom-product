package com.ecom.product.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ImageModel {

    private Long idImage;
    private String name;
    private String description;
    private String urlImage;
    private Date created;
    private Date modified;
}
