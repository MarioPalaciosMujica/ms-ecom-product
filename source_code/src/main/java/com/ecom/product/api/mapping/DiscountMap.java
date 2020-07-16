package com.ecom.product.api.mapping;

import com.ecom.product.api.models.DiscountModel;
import com.ecom.product.dalc.entities.Discount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DiscountMap {

    public DiscountModel toModel(Discount entity){
        if(entity != null){
            DiscountModel model = new DiscountModel();
            model.setIdDiscount(entity.getIdDiscount());
            model.setName(entity.getName());
            model.setDescription(entity.getDescription());
            model.setPercentage(entity.getPercentage());
            model.setFixedPrice(entity.getFixedPrice());
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

    public Discount toEntity(DiscountModel model){
        if(model != null){
            Discount entity = new Discount();
            entity.setIdDiscount(model.getIdDiscount());
            entity.setName(model.getName());
            entity.setDescription(model.getDescription());
            entity.setPercentage(model.getPercentage());
            entity.setFixedPrice(model.getFixedPrice());
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

    public List<DiscountModel> toModelList(List<Discount> listEntity){
        List<DiscountModel> modelList = new ArrayList<>();
        for (Discount entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Discount> toEntityList(List<DiscountModel> listModel){
        List<Discount> entityList = new ArrayList<>();
        for (DiscountModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
