package com.ecom.product.dalc.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_feature_types")
@NoArgsConstructor
public class FeatureType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feature_type", updatable = false, nullable = false, unique = true)
    private Long idFeatureType;

    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 2, max = 50, message = "name size not valid")
    private String name;

    @Column(name = "description")
    @Size(max = 100, message = "description size not valid")
    private String description;

    @Column(name = "level")
    private int level;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "featureType")
    private Set<FeaturedProduct> featuredProducts;


    // GETTERS AND SETTERS

    public Long getIdFeatureType() {
        return idFeatureType;
    }

    public void setIdFeatureType(Long idFeatureType) {
        this.idFeatureType = idFeatureType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public Set<FeaturedProduct> getFeaturedProducts() {
        return featuredProducts;
    }

    public void setFeaturedProducts(Set<FeaturedProduct> featuredProducts) {
        this.featuredProducts = featuredProducts;
    }
}
