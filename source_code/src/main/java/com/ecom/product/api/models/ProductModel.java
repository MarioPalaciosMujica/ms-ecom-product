package com.ecom.product.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductModel {

    private Long idProduct;
    private String barcode;
    private String name;
    private String description;
    private int rating;
    private BigDecimal price;
    private Long sku;
    private boolean isActive;
    private Date created;
    private Date modified;
    private ImageModel image;
    private BrandModel brand;
    private DiscountModel discount;
    private List<ImageModel> images;
    private List<CategoryModel> categories;
    private List<TagModel> tags;
    private List<TagModel> taxes;
}
