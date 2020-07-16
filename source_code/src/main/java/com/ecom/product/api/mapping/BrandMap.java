package com.ecom.product.api.mapping;

import com.ecom.product.api.models.BrandModel;
import com.ecom.product.dalc.entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BrandMap {

    @Autowired private ImageMap imageMap;

    public BrandModel toModel(Brand entity){
        if(entity != null){
            BrandModel model = new BrandModel();
            model.setIdBrand (entity.getIdBrand());
            model.setName(entity.getName());
            model.setCreated(entity.getCreated());
            model.setModified(entity.getModified());
            model.setImage(this.imageMap.toModel(entity.getImage()));
            return model;
        }
        else{
            return null;
        }

    }

    public Brand toEntity(BrandModel model){
        if(model != null){
            Brand entity = new Brand();
            entity.setIdBrand (model.getIdBrand());
            entity.setName(model.getName());
            entity.setCreated(model.getCreated());
            entity.setModified(model.getModified());
            entity.setImage(this.imageMap.toEntity(model.getImage()));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<BrandModel> toModelList(List<Brand> listEntity){
        List<BrandModel> modelList = new ArrayList<>();
        for (Brand entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Brand> toEntityList(List<BrandModel> listModel){
        List<Brand> entityList = new ArrayList<>();
        for (BrandModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
