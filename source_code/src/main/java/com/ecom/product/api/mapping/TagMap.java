package com.ecom.product.api.mapping;

import com.ecom.product.api.models.TagModel;
import com.ecom.product.dalc.entities.Tag;
import com.ecom.product.tools.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TagMap {

    @Autowired private DateFormat dateFormat;

    public TagModel toModel(Tag entity){
        if(entity != null){
            TagModel model = new TagModel();
            model.setIdTag(entity.getIdTag());
            model.setName(entity.getName());
            model.setCreated(dateFormat.dateToString(entity.getCreated()));
            model.setModified(dateFormat.dateToString(entity.getModified()));
            return model;
        }
        else{
            return null;
        }
    }

    public Tag toEntity(TagModel model){
        if(model != null){
            Tag entity = new Tag();
            entity.setIdTag(model.getIdTag());
            entity.setName(model.getName());
            entity.setCreated(dateFormat.stringToDate(model.getCreated()));
            entity.setModified(dateFormat.stringToDate(model.getModified()));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<TagModel> toModelList(List<Tag> listEntity){
        List<TagModel> modelList = new ArrayList<>();
        for (Tag entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Tag> toEntityList(List<TagModel> listModel){
        List<Tag> entityList = new ArrayList<>();
        for (TagModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
