package com.ecom.product.api.mapping;

import com.ecom.product.api.models.ProductMaterialModel;
import com.ecom.product.dalc.entities.ProductMaterial;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMaterialMap {

    public ProductMaterialModel toModel(ProductMaterial entity){
        if(entity != null){
            ProductMaterialModel model = new ProductMaterialModel();
            model.setIdProductMaterial(entity.getIdProductMaterial());
            model.setIdMaterial(entity.getIdMaterial());
            model.setMetricUnits(entity.getMetricUnits());
            return model;
        }
        else{
            return null;
        }

    }

    public ProductMaterial toEntity(ProductMaterialModel model){
        if(model != null){
            ProductMaterial entity = new ProductMaterial();
            entity.setIdProductMaterial(model.getIdProductMaterial());
            entity.setIdMaterial(model.getIdMaterial());
            entity.setMetricUnits(model.getMetricUnits());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<ProductMaterialModel> toModelList(List<ProductMaterial> listEntity){
        List<ProductMaterialModel> modelList = new ArrayList<>();
        for (ProductMaterial entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<ProductMaterial> toEntityList(List<ProductMaterialModel> listModel){
        List<ProductMaterial> entityList = new ArrayList<>();
        for (ProductMaterialModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
