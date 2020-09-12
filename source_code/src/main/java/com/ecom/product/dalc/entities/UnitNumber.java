package com.ecom.product.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_units_numbers")
@NoArgsConstructor
@AllArgsConstructor
public class UnitNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_units_number", updatable = false, nullable = false, unique = true)
    private Long idUnitNumber;

    @Column(name = "units_quantity", nullable = false, unique = true)
    private int unitQuantity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbr_variants_units",
            joinColumns = @JoinColumn(name = "id_units_number"),
            inverseJoinColumns = @JoinColumn(name = "id_variant")
    )
    private Set<Variant> variants;



    public Long getIdUnitNumber() {
        return idUnitNumber;
    }

    public void setIdUnitNumber(Long idUnitNumber) {
        this.idUnitNumber = idUnitNumber;
    }

    public int getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(int unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public Set<Variant> getVariants() {
        return variants;
    }

    public void setVariants(Set<Variant> variants) {
        this.variants = variants;
    }
}
