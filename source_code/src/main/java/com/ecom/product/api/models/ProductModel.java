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

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("isNew")
    private boolean isNew;

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("isSale")
    private boolean isSale;

    @JsonProperty("discountPercentage")
    private BigDecimal discountPercentage;

    @JsonProperty("priceDiscount")
    private BigDecimal priceDiscount;

    @JsonProperty("stock")
    private int stock;

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

    @JsonProperty("collection")
    private CollectionModel collection;

    @JsonProperty("images")
    private List<ImageModel> images;

    @JsonProperty("categories")
    private List<CategoryModel> categories;

    @JsonProperty("tags")
    private List<TagModel> tags;

}
