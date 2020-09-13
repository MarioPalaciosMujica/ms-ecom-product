package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.VariantMap;
import com.ecom.product.api.models.VariantModel;
import com.ecom.product.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Variant")
public class VariantController {

    @Autowired private VariantService variantService;
    @Autowired private VariantMap variantMap;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull VariantModel model){
        variantService.save(variantMap.toEntity(model));
    }

    @RequestMapping(value = "/findAllByProduct/{idProduct}", method = RequestMethod.GET)
    public List<VariantModel> findAllByTag(@PathVariable @NotNull Long idProduct){
        return variantMap.toModelList(variantService.findAllByProduct(idProduct));
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public VariantModel findById(@PathVariable @NotNull Long id){
        return variantMap.toModel(variantService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull VariantModel model){
        variantService.update(variantMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        variantService.deleteById(id);
    }
}
