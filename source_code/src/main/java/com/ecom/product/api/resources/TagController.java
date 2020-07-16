package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.TagMap;
import com.ecom.product.api.models.TagModel;
import com.ecom.product.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Tag")
public class TagController {

    @Autowired private TagService tagService;
    @Autowired private TagMap tagMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull TagModel model){
        tagService.save(tagMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<TagModel> findAll(){
        return tagMap.toModelList(tagService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public TagModel findById(@PathVariable @NotNull Long id){
        return tagMap.toModel(tagService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull TagModel model){
        tagService.update(tagMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        tagService.deleteById(id);
    }
}
