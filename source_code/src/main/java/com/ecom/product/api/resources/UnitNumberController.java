package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.UnitNumberMap;
import com.ecom.product.api.models.UnitNumberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/UnitNumber")
public class UnitNumberController {

    @Autowired private UnitNumberService unitNumberService;
    @Autowired private UnitNumberMap unitNumberMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull UnitNumberModel model){
        unitNumberService.save(unitNumberMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<UnitNumberModel> findAll(){
        return unitNumberMap.toModelList(unitNumberService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public UnitNumberModel findById(@PathVariable @NotNull Long id){
        return unitNumberMap.toModel(unitNumberService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull UnitNumberModel model){
        unitNumberService.update(unitNumberMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        unitNumberService.deleteById(id);
    }
}
