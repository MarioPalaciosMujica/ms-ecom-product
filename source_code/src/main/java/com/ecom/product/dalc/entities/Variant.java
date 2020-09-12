package com.ecom.product.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_variants")
@NoArgsConstructor
@AllArgsConstructor
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variant", updatable = false, nullable = false, unique = true)
    private Long idVariant;

    @Column(name = "sku", nullable = false)
    private Long sku;

    @Column(name = "base_price_amount", nullable = false)
    private BigDecimal basePriceAmount;

    @Column(name = "total_price_amount", nullable = false)
    private BigDecimal totalPriceAmount;

    @Column(name = "is_selected", nullable = false)
    private boolean isSelected;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbr_variants_units",
            joinColumns = @JoinColumn(name = "id_variant"),
            inverseJoinColumns = @JoinColumn(name = "id_units_number")
    )
    private Set<UnitNumber> unitNumbers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbr_variants_options",
            joinColumns = @JoinColumn(name = "id_variant"),
            inverseJoinColumns = @JoinColumn(name = "id_option")
    )
    private Set<Option> options;



    public Long getIdVariant() {
        return idVariant;
    }

    public void setIdVariant(Long idVariant) {
        this.idVariant = idVariant;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public BigDecimal getBasePriceAmount() {
        return basePriceAmount;
    }

    public void setBasePriceAmount(BigDecimal basePriceAmount) {
        this.basePriceAmount = basePriceAmount;
    }

    public BigDecimal getTotalPriceAmount() {
        return totalPriceAmount;
    }

    public void setTotalPriceAmount(BigDecimal totalPriceAmount) {
        this.totalPriceAmount = totalPriceAmount;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Set<UnitNumber> getUnitNumbers() {
        return unitNumbers;
    }

    public void setUnitNumbers(Set<UnitNumber> unitNumbers) {
        this.unitNumbers = unitNumbers;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }
}
