package com.ecom.product.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CategoryModel {

    private Long idCategory;
    private String name;
    private Date created;
    private Date modified;
}
