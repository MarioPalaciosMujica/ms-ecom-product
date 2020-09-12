package com.ecom.product.api.mapping;

import com.ecom.product.api.models.OptionModel;
import com.ecom.product.dalc.entities.Option;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OptionMap {

    public OptionModel toModel(Option entity){
        if(entity != null){
            OptionModel model = new OptionModel();
            model.setIdOption(entity.getIdOption());
            model.setOptionName(entity.getOptionName());
            return model;
        }
        else{
            return null;
        }
    }

    public Option toEntity(OptionModel model){
        if(model != null){
            Option entity = new Option();
            entity.setIdOption(model.getIdOption());
            entity.setOptionName(model.getOptionName());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<OptionModel> toModelList(List<Option> listEntity){
        List<OptionModel> modelList = new ArrayList<>();
        for (Option entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Option> toEntityList(List<OptionModel> listModel){
        List<Option> entityList = new ArrayList<>();
        for (OptionModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
