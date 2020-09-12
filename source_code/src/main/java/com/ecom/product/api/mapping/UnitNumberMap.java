package com.ecom.product.api.mapping;

import com.ecom.product.api.models.UnitNumberModel;
import com.ecom.product.dalc.entities.UnitNumber;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UnitNumberMap {

    public UnitNumberModel toModel(UnitNumber entity){
        if(entity != null){
            UnitNumberModel model = new UnitNumberModel();
            model.setIdUnitNumber(entity.getIdUnitNumber());
            model.setUnitQuantity(entity.getUnitQuantity());
            return model;
        }
        else{
            return null;
        }
    }

    public UnitNumber toEntity(UnitNumberModel model){
        if(model != null){
            UnitNumber entity = new UnitNumber();
            entity.setIdUnitNumber(model.getIdUnitNumber());
            entity.setUnitQuantity(model.getUnitQuantity());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<UnitNumberModel> toModelList(List<UnitNumber> listEntity){
        List<UnitNumberModel> modelList = new ArrayList<>();
        for (UnitNumber entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<UnitNumber> toEntityList(List<UnitNumberModel> listModel){
        List<UnitNumber> entityList = new ArrayList<>();
        for (UnitNumberModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
