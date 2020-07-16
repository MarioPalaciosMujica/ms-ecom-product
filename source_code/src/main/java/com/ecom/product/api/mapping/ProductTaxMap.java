package com.ecom.product.api.mapping;

import com.ecom.product.api.models.ProductTaxModel;
import com.ecom.product.dalc.entities.ProductTax;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductTaxMap {

    public ProductTaxModel toModel(ProductTax entity){
        if(entity != null){
            ProductTaxModel model = new ProductTaxModel();
            model.setIdTax(entity.getIdTax());
            model.setName(entity.getName());
            model.setDescription(entity.getDescription());
            model.setPercentage(entity.getPercentage());
            model.setFixedAmount(entity.getFixedAmount());
            model.setActive(entity.isActive());
            model.setCreated(entity.getCreated());
            model.setModified(entity.getModified());
            return model;
        }
        else{
            return null;
        }
    }

    public ProductTax toEntity(ProductTaxModel model){
        if(model != null){
            ProductTax entity = new ProductTax();
            entity.setIdTax(model.getIdTax());
            entity.setName(model.getName());
            entity.setDescription(model.getDescription());
            entity.setPercentage(model.getPercentage());
            entity.setFixedAmount(model.getFixedAmount());
            entity.setActive(model.isActive());
            entity.setCreated(model.getCreated());
            entity.setModified(model.getModified());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<ProductTaxModel> toModelList(List<ProductTax> listEntity){
        List<ProductTaxModel> modelList = new ArrayList<>();
        for (ProductTax entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<ProductTax> toEntityList(List<ProductTaxModel> listModel){
        List<ProductTax> entityList = new ArrayList<>();
        for (ProductTaxModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
