package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.CollectionMap;
import com.ecom.product.api.models.CollectionModel;
import com.ecom.product.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Collection")
public class CollectionController {

    @Autowired private CollectionService collectionService;
    @Autowired private CollectionMap collectionMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull CollectionModel model){
        collectionService.save(collectionMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<CollectionModel> findAll(){
        return collectionMap.toModelList(collectionService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public CollectionModel findById(@PathVariable @NotNull Long id){
        return collectionMap.toModel(collectionService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull CollectionModel model){
        collectionService.update(collectionMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        collectionService.deleteById(id);
    }

}
