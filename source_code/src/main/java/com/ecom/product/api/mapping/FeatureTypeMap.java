package com.ecom.product.api.mapping;

import com.ecom.product.api.models.FeatureTypeModel;
import com.ecom.product.dalc.entities.FeatureType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeatureTypeMap {

    public FeatureTypeModel toModel(FeatureType entity){
        if(entity != null){
            FeatureTypeModel model = new FeatureTypeModel();
            model.setIdFeatureType(entity.getIdFeatureType());
            model.setName(entity.getName());
            model.setDescription(entity.getDescription());
            model.setLevel(entity.getLevel());
            model.setCreated(entity.getCreated());
            model.setModified(entity.getModified());
            return model;
        }
        else{
            return null;
        }
    }

    public FeatureType toEntity(FeatureTypeModel model){
        if(model != null){
            FeatureType entity = new FeatureType();
            entity.setIdFeatureType(model.getIdFeatureType());
            entity.setName(model.getName());
            entity.setDescription(model.getDescription());
            entity.setLevel(model.getLevel());
            entity.setCreated(model.getCreated());
            entity.setModified(model.getModified());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<FeatureTypeModel> toModelList(List<FeatureType> listEntity){
        List<FeatureTypeModel> modelList = new ArrayList<>();
        for (FeatureType entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<FeatureType> toEntityList(List<FeatureTypeModel> listModel){
        List<FeatureType> entityList = new ArrayList<>();
        for (FeatureTypeModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
