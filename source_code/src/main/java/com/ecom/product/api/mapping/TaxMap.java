package com.ecom.product.api.mapping;

import com.ecom.product.api.models.TaxModel;
import com.ecom.product.dalc.entities.Tax;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaxMap {

    public TaxModel toModel(Tax entity){
        if(entity != null){
            TaxModel model = new TaxModel();
            model.setIdTax(entity.getIdTax());
            model.setName(entity.getName());
            model.setDescription(entity.getDescription());
            model.setPercentage(entity.getPercentage());
            model.setFixedPrice(entity.getFixedPrice());
            model.setActive(entity.isActive());
            model.setCreated(entity.getCreated());
            model.setModified(entity.getModified());
            return model;
        }
        else{
            return null;
        }
    }

    public Tax toEntity(TaxModel model){
        if(model != null){
            Tax entity = new Tax();
            entity.setIdTax(model.getIdTax());
            entity.setName(model.getName());
            entity.setDescription(model.getDescription());
            entity.setPercentage(model.getPercentage());
            entity.setFixedPrice(model.getFixedPrice());
            entity.setActive(model.isActive());
            entity.setCreated(model.getCreated());
            entity.setModified(model.getModified());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<TaxModel> toModelList(List<Tax> listEntity){
        List<TaxModel> modelList = new ArrayList<>();
        for (Tax entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Tax> toEntityList(List<TaxModel> listModel){
        List<Tax> entityList = new ArrayList<>();
        for (TaxModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
