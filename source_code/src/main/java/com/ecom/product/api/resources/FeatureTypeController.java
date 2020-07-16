package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.FeatureTypeMap;
import com.ecom.product.api.models.FeatureTypeModel;
import com.ecom.product.service.FeatureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/FeatureType")
public class FeatureTypeController {

    @Autowired private FeatureTypeService featureTypeService;
    @Autowired private FeatureTypeMap featureTypeMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull FeatureTypeModel model){
        featureTypeService.save(featureTypeMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<FeatureTypeModel> findAll(){
        return featureTypeMap.toModelList(featureTypeService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public FeatureTypeModel findById(@PathVariable @NotNull Long id){
        return featureTypeMap.toModel(featureTypeService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull FeatureTypeModel model){
        featureTypeService.update(featureTypeMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        featureTypeService.deleteById(id);
    }
}
