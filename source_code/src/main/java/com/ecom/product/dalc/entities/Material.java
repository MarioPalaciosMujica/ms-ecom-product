package com.ecom.product.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_materials")
@NoArgsConstructor
@AllArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material", updatable = false, nullable = false, unique = true)
    private Long idMaterial;

    @Column(name = "barcode")
    @Size(max = 13, message = "barcode size not valid")
    private String barcode;

    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 2, max = 50, message = "name size not valid")
    private String name;

    @Column(name = "description")
    @Size(max = 255, message = "name size not valid")
    private String description;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbr_products_materials",
            joinColumns = @JoinColumn(name = "id_material"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private Set<Product> products;


    // GETTERS AND SETTERS

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
