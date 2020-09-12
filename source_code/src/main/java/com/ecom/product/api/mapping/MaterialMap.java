package com.ecom.product.api.mapping;

import com.ecom.product.api.models.MaterialModel;
import com.ecom.product.dalc.entities.Material;
import com.ecom.product.tools.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MaterialMap {

    @Autowired private DateFormat dateFormat;

    public MaterialModel toModel(Material entity){
        if(entity != null){
            MaterialModel model = new MaterialModel();
            model.setIdMaterial(entity.getIdMaterial());
            model.setBarcode(entity.getBarcode());
            model.setTitle(entity.getTitle());
            model.setDescription(entity.getDescription());
            model.setCreated(dateFormat.dateToString(entity.getCreated()));
            model.setModified(dateFormat.dateToString(entity.getModified()));
            return model;
        }
        else{
            return null;
        }
    }

    public Material toEntity(MaterialModel model){
        if(model != null){
            Material entity = new Material();
            entity.setIdMaterial(model.getIdMaterial());
            entity.setBarcode(model.getBarcode());
            entity.setTitle(model.getTitle());
            entity.setDescription(model.getDescription());
            entity.setCreated(dateFormat.stringToDate(model.getCreated()));
            entity.setModified(dateFormat.stringToDate(model.getModified()));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<MaterialModel> toModelList(List<Material> listEntity){
        List<MaterialModel> modelList = new ArrayList<>();
        for (Material entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Material> toEntityList(List<MaterialModel> listModel){
        List<Material> entityList = new ArrayList<>();
        for (MaterialModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
