package com.ecom.product.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private int optionName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbr_variants_options",
            joinColumns = @JoinColumn(name = "id_option"),
            inverseJoinColumns = @JoinColumn(name = "id_variant")
    )
    private Set<Variant> variants;


    public Long getIdOption() {
        return idOption;
    }

    public void setIdOption(Long idOption) {
        this.idOption = idOption;
    }

    public int getOptionName() {
        return optionName;
    }

    public void setOptionName(int optionName) {
        this.optionName = optionName;
    }

    public Set<Variant> getVariants() {
        return variants;
    }

    public void setVariants(Set<Variant> variants) {
        this.variants = variants;
    }
}
