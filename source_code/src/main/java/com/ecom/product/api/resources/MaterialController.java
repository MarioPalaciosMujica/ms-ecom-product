package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.MaterialMap;
import com.ecom.product.api.models.MaterialModel;
import com.ecom.product.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Material")
public class MaterialController {

    @Autowired private MaterialService materialService;
    @Autowired private MaterialMap materialMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull MaterialModel model){
        materialService.save(materialMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<MaterialModel> findAll(){
        return materialMap.toModelList(materialService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public MaterialModel findById(@PathVariable @NotNull Long id){
        return materialMap.toModel(materialService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull MaterialModel model){
        materialService.update(materialMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        materialService.deleteById(id);
    }
}
