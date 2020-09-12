package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.CatalogueMap;
import com.ecom.product.api.models.CatalogueModel;
import com.ecom.product.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Catalogue")
public class CatalogueController {

    @Autowired private CatalogueService catalogueService;
    @Autowired private CatalogueMap catalogueMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull CatalogueModel model){
        catalogueService.save(catalogueMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<CatalogueModel> findAll(){
        return catalogueMap.toModelList(catalogueService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public CatalogueModel findById(@PathVariable @NotNull Long id){
        return catalogueMap.toModel(catalogueService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull CatalogueModel model){
        catalogueService.update(catalogueMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        catalogueService.deleteById(id);
    }
}
