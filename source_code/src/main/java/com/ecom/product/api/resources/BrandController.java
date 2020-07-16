package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.BrandMap;
import com.ecom.product.api.models.BrandModel;
import com.ecom.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Brand")
public class BrandController {

    @Autowired private BrandService brandService;
    @Autowired private BrandMap brandMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull BrandModel model){
        brandService.save(brandMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<BrandModel> findAll(){
        return brandMap.toModelList(brandService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public BrandModel findById(@PathVariable @NotNull Long id){
        return brandMap.toModel(brandService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull BrandModel model){
        brandService.update(brandMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        brandService.deleteById(id);
    }
}
