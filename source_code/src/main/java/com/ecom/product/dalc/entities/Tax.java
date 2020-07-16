package com.ecom.product.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_taxes")
@NoArgsConstructor
@AllArgsConstructor
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tax", updatable = false, nullable = false, unique = true)
    private Long idTax;

    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 2, max = 50, message = "name size not valid")
    private String name;

    @Column(name = "description")
    @Size(max = 255, message = "description size not valid")
    private String description;

    @Column(name = "percentage")
    private BigDecimal percentage;

    @Column(name = "fixed_price")
    private BigDecimal fixedPrice;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbr_products_taxes",
            joinColumns = @JoinColumn(name = "id_tax"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private Set<Product> producs;


    // GETTERS AND SETTERS

    public Long getIdTax() {
        return idTax;
    }

    public void setIdTax(Long idTax) {
        this.idTax = idTax;
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

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(BigDecimal fixedPrice) {
        this.fixedPrice = fixedPrice;
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

    public Set<Product> getProducs() {
        return producs;
    }

    public void setProducs(Set<Product> producs) {
        this.producs = producs;
    }
}
