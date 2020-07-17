package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductModel {

    @JsonProperty("idProduct")
    private Long idProduct;

    @JsonProperty("barcode")
    private String barcode;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("sku")
    private Long sku;

    @JsonProperty("isActive")
    private boolean isActive;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("modified")
    private Date modified;

    @JsonProperty("image")
    private ImageModel image;

    @JsonProperty("brand")
    private BrandModel brand;

    @JsonProperty("productDiscount")
    private ProductDiscountModel productDiscount;

    @JsonProperty("images")
    private List<ImageModel> images;

    @JsonProperty("categories")
    private List<CategoryModel> categories;

    @JsonProperty("tags")
    private List<TagModel> tags;

    @JsonProperty("productTaxes")
    private List<ProductTaxModel> productTaxes;
}
