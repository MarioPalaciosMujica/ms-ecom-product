package com.ecom.product.api.mapping;

import com.ecom.product.api.models.CollectionModel;
import com.ecom.product.dalc.entities.Collection;
import com.ecom.product.tools.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CollectionMap {

    @Autowired private DateFormat dateFormat;

    public CollectionModel toModel(Collection entity){
        if(entity != null){
            CollectionModel model = new CollectionModel();
            model.setIdCollection(entity.getIdCollection());
            model.setName(entity.getName());
            model.setCreated(dateFormat.dateToString(entity.getCreated()));
            model.setModified(dateFormat.dateToString(entity.getModified()));
            return model;
        }
        else{
            return null;
        }
    }

    public Collection toEntity(CollectionModel model){
        if(model != null){
            Collection entity = new Collection();
            entity.setIdCollection(model.getIdCollection());
            entity.setName(model.getName());
            entity.setCreated(dateFormat.stringToDate(model.getCreated()));
            entity.setModified(dateFormat.stringToDate(model.getModified()));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<CollectionModel> toModelList(List<Collection> listEntity){
        List<CollectionModel> modelList = new ArrayList<>();
        for (Collection entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Collection> toEntityList(List<CollectionModel> listModel){
        List<Collection> entityList = new ArrayList<>();
        for (CollectionModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
