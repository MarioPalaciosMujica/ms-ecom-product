package com.ecom.product.api.mapping;

import com.ecom.product.api.models.VariantModel;
import com.ecom.product.dalc.entities.Variant;
import com.ecom.product.tools.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class VariantMap {

    @Autowired private UnitNumberMap unitNumberMap;
    @Autowired private OptionMap optionMap;
    @Autowired private DateFormat dateFormat;

    public VariantModel toModel(Variant entity){
        if(entity != null){
            VariantModel model = new VariantModel();
            model.setIdVariant(entity.getIdVariant());
            model.setSku(entity.getSku());
            model.setBasePriceAmount(entity.getBasePriceAmount());
            model.setTotalPriceAmount(entity.getTotalPriceAmount());
            model.setSelected(entity.isSelected());
            model.setCreated(dateFormat.dateToString(entity.getCreated()));
            model.setModified(dateFormat.dateToString(entity.getModified()));
            model.setUnitNumbers(unitNumberMap.toModelList(new ArrayList<>(entity.getUnitNumbers())));
            model.setOptions(optionMap.toModelList(new ArrayList<>(entity.getOptions())));
            return model;
        }
        else{
            return null;
        }
    }

    public Variant toEntity(VariantModel model){
        if(model != null){
            Variant entity = new Variant();
            entity.setIdVariant(model.getIdVariant());
            entity.setSku(model.getSku());
            entity.setBasePriceAmount(model.getBasePriceAmount());
            entity.setTotalPriceAmount(model.getTotalPriceAmount());
            entity.setSelected(model.isSelected());
            entity.setCreated(dateFormat.stringToDate(model.getCreated()));
            entity.setModified(dateFormat.stringToDate(model.getModified()));
            entity.setUnitNumbers(new HashSet<>(unitNumberMap.toEntityList(model.getUnitNumbers())));
            entity.setOptions(new HashSet<>(optionMap.toEntityList(model.getOptions())));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<VariantModel> toModelList(List<Variant> listEntity){
        List<VariantModel> modelList = new ArrayList<>();
        for (Variant entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Variant> toEntityList(List<VariantModel> listModel){
        List<Variant> entityList = new ArrayList<>();
        for (VariantModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
