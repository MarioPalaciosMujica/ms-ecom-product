package com.ecom.product.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tbr_products_materials")
@NoArgsConstructor
@AllArgsConstructor
public class ProductMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_material", updatable = false, nullable = false, unique = true)
    private Long idProductMaterial;

    @Column(name = "metric_units", nullable = false)
    private BigDecimal metricUnits;

    @Column(name = "EFK_id_material", updatable = false, nullable = false)
    private Long idMaterial;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;



    public Long getIdProductMaterial() {
        return idProductMaterial;
    }

    public void setIdProductMaterial(Long idProductMaterial) {
        this.idProductMaterial = idProductMaterial;
    }

    public BigDecimal getMetricUnits() {
        return metricUnits;
    }

    public void setMetricUnits(BigDecimal metricUnits) {
        this.metricUnits = metricUnits;
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
