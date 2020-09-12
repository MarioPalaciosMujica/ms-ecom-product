package com.ecom.product.api.mapping;

import com.ecom.product.api.models.CatalogueModel;
import com.ecom.product.dalc.entities.Catalogue;
import com.ecom.product.tools.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatalogueMap {

    @Autowired private DateFormat dateFormat;

    public CatalogueModel toModel(Catalogue entity){
        if(entity != null){
            CatalogueModel model = new CatalogueModel();
            model.setIdCatalogue(entity.getIdCatalogue());
            model.setCatalogueName(entity.getCatalogueName());
            model.setActive(entity.isActive());
            model.setCreated(dateFormat.dateToString(entity.getCreated()));
            model.setModified(dateFormat.dateToString(entity.getModified()));
            return model;
        }
        else{
            return null;
        }
    }

    public Catalogue toEntity(CatalogueModel model){
        if(model != null){
            Catalogue entity = new Catalogue();
            entity.setIdCatalogue(model.getIdCatalogue());
            entity.setCatalogueName(model.getCatalogueName());
            model.setActive(model.isActive());
            entity.setCreated(dateFormat.stringToDate(model.getCreated()));
            entity.setModified(dateFormat.stringToDate(model.getModified()));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<CatalogueModel> toModelList(List<Catalogue> listEntity){
        List<CatalogueModel> modelList = new ArrayList<>();
        for (Catalogue entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Catalogue> toEntityList(List<CatalogueModel> listModel){
        List<Catalogue> entityList = new ArrayList<>();
        for (CatalogueModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
