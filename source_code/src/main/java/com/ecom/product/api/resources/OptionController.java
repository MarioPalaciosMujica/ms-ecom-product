package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.OptionMap;
import com.ecom.product.api.models.OptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Option")
public class OptionController {

    @Autowired private OptionService optionService;
    @Autowired private OptionMap optionMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull OptionModel model){
        optionService.save(optionMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<OptionModel> findAll(){
        return optionMap.toModelList(optionService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public OptionModel findById(@PathVariable @NotNull Long id){
        return optionMap.toModel(optionService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull OptionModel model){
        optionService.update(optionMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        optionService.deleteById(id);
    }

}
