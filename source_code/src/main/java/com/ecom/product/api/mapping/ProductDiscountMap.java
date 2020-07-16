package com.ecom.product.api.mapping;

import com.ecom.product.api.models.ProductDiscountModel;
import com.ecom.product.dalc.entities.ProductDiscount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDiscountMap {

    public ProductDiscountModel toModel(ProductDiscount entity){
        if(entity != null){
            ProductDiscountModel model = new ProductDiscountModel();
            model.setIdDiscount(entity.getIdDiscount());
            model.setName(entity.getName());
            model.setDescription(entity.getDescription());
            model.setPercentage(entity.getPercentage());
            model.setFixedAmount(entity.getFixedAmount());
            model.setValidUntil(entity.getValidUntil());
            model.setActive(entity.isActive());
            model.setCreated(entity.getCreated());
            model.setModified(entity.getModified());
            return model;
        }
        else{
            return null;
        }

    }

    public ProductDiscount toEntity(ProductDiscountModel model){
        if(model != null){
            ProductDiscount entity = new ProductDiscount();
            entity.setIdDiscount(model.getIdDiscount());
            entity.setName(model.getName());
            entity.setDescription(model.getDescription());
            entity.setPercentage(model.getPercentage());
            entity.setFixedAmount(model.getFixedAmount());
            entity.setValidUntil(model.getValidUntil());
            entity.setActive(model.isActive());
            entity.setCreated(model.getCreated());
            entity.setModified(model.getModified());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<ProductDiscountModel> toModelList(List<ProductDiscount> listEntity){
        List<ProductDiscountModel> modelList = new ArrayList<>();
        for (ProductDiscount entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<ProductDiscount> toEntityList(List<ProductDiscountModel> listModel){
        List<ProductDiscount> entityList = new ArrayList<>();
        for (ProductDiscountModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
