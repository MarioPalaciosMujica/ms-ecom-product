package com.ecom.product.dalc.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_featured_products")
@NoArgsConstructor
public class FeaturedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_featured_product", updatable = false, nullable = false, unique = true)
    private Long idFeaturedProduct;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_feature_type")
    private FeatureType featureType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;


    // GETTERS AND SETTERS

    public Long getIdFeaturedProduct() {
        return idFeaturedProduct;
    }

    public void setIdFeaturedProduct(Long idFeaturedProduct) {
        this.idFeaturedProduct = idFeaturedProduct;
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

    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
