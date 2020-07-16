package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.CategoryMap;
import com.ecom.product.api.models.CategoryModel;
import com.ecom.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {

    @Autowired private CategoryService categoryService;
    @Autowired private CategoryMap categoryMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull CategoryModel model){
        categoryService.save(categoryMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<CategoryModel> findAll(){
        return categoryMap.toModelList(categoryService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public CategoryModel findById(@PathVariable @NotNull Long id){
        return categoryMap.toModel(categoryService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull CategoryModel model){
        categoryService.update(categoryMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        categoryService.deleteById(id);
    }
}
