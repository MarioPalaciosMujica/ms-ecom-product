package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.FeaturedProductMap;
import com.ecom.product.api.models.FeaturedProductModel;
import com.ecom.product.service.FeaturedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/FeaturedProduct")
public class FeaturedProductController {

    @Autowired private FeaturedProductService featuredProductService;
    @Autowired private FeaturedProductMap featuredProductMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull FeaturedProductModel model){
        featuredProductService.save(featuredProductMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<FeaturedProductModel> findAll(){
        return featuredProductMap.toModelList(featuredProductService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public FeaturedProductModel findById(@PathVariable @NotNull Long id){
        return featuredProductMap.toModel(featuredProductService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull FeaturedProductModel model){
        featuredProductService.update(featuredProductMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        featuredProductService.deleteById(id);
    }

}
