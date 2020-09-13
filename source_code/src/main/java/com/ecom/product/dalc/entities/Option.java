package com.ecom.product.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "tbl_options")
@NoArgsConstructor
@AllArgsConstructor
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_option", updatable = false, nullable = false, unique = true)
    private Long idOption;

    @Column(name = "option_name", nullable = false, unique = true)
    @Size(min = 2, max = 50, message = "optionName size not valid")
    private String optionName;

    @Column(name = "amount_percentage")
    private BigDecimal amountPercentage;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbr_variants_options",
            joinColumns = @JoinColumn(name = "id_option"),
            inverseJoinColumns = @JoinColumn(name = "id_variant")
    )
    private Set<Variant> variants;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbr_products_options",
            joinColumns = @JoinColumn(name = "id_option"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private Set<Product> products;



    public Long getIdOption() {
        return idOption;
    }

    public void setIdOption(Long idOption) {
        this.idOption = idOption;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public BigDecimal getAmountPercentage() {
        return amountPercentage;
    }

    public void setAmountPercentage(BigDecimal amountPercentage) {
        this.amountPercentage = amountPercentage;
    }

    public Set<Variant> getVariants() {
        return variants;
    }

    public void setVariants(Set<Variant> variants) {
        this.variants = variants;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
