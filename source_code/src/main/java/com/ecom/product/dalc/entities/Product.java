package com.ecom.product.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", updatable = false, nullable = false, unique = true)
    private Long idProduct;

    @Column(name = "barcode", unique = true)
    @Size(max = 13, message = "barcode size invalid")
    private String barcode;

    @Column(name = "title", nullable = false, unique = true)
    @Size(min = 2, max = 50, message = "title size invalid")
    private String title;

    @Column(name = "description")
    @Size(max = 1000, message = "description size not valid")
    private String description;

    @Column(name = "isNew", nullable = false)
    private boolean isNew;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "isSale", nullable = false)
    private boolean isSale;

    @Column(name = "discount_percentage")
    private BigDecimal discountPercentage;

    @Column(name = "current_base_price", nullable = false)
    private BigDecimal currentBasePrice;

    @Column(name = "current_total_price", nullable = false)
    private BigDecimal currentTotalPrice;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "is_capacity_qty")
    private boolean isCapacityQty;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbr_products_images",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_image")
    )
    private Set<Image> images;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbr_products_categories",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_category")
    )
    private Set<Category> categories;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_collection")
    private Collection collection;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbr_products_tags",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_tag")
    )
    private Set<Tag> tags;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<ProductMaterial> productMaterials;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Set<Variant> variants;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbr_products_options",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_option")
    )
    private Set<Option> options;



    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getCurrentBasePrice() {
        return currentBasePrice;
    }

    public void setCurrentBasePrice(BigDecimal currentBasePrice) {
        this.currentBasePrice = currentBasePrice;
    }

    public BigDecimal getCurrentTotalPrice() {
        return currentTotalPrice;
    }

    public void setCurrentTotalPrice(BigDecimal currentTotalPrice) {
        this.currentTotalPrice = currentTotalPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public boolean isCapacityQty() {
        return isCapacityQty;
    }

    public void setCapacityQty(boolean capacityQty) {
        isCapacityQty = capacityQty;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<ProductMaterial> getProductMaterials() {
        return productMaterials;
    }

    public void setProductMaterials(Set<ProductMaterial> productMaterials) {
        this.productMaterials = productMaterials;
    }

    public Set<Variant> getVariants() {
        return variants;
    }

    public void setVariants(Set<Variant> variants) {
        this.variants = variants;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }
}
