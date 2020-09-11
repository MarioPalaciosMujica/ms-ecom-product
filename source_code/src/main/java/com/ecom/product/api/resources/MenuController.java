package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.MenuSectionMap;
import com.ecom.product.api.models.MenuSectionModel;
import com.ecom.product.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Menu")
public class MenuController {

    @Autowired private MenuService menuService;
    @Autowired private MenuSectionMap menuSectionMap;

    @RequestMapping(value = "/generateMenu/{path}", method = RequestMethod.GET)
    public List<MenuSectionModel> generateMenu(@PathVariable @NotNull String path){
        return menuSectionMap.toModelList(menuService.generateMenu(path));
    }

}
