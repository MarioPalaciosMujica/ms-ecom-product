package com.ecom.product.service;

import com.ecom.product.dalc.entities.Category;
import com.ecom.product.dalc.entities.MenuItem;
import com.ecom.product.dalc.entities.MenuSection;
import com.ecom.product.dalc.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Autowired private CategoryService categoryService;
    @Autowired private ProductService productService;

    public List<MenuSection> generateMenu(@NotNull String defaultPath){
        List<MenuSection> menuSectionList = new ArrayList<>();
        List<Category> categoryList = categoryService.findAll();
        List<Product> productList = productService.findAllActives();

        for (Category category : categoryList){
            MenuSection menuSection = new MenuSection(category.getName(), "link", false, new ArrayList<>());
            List<MenuItem> menuItemList = new ArrayList<>();
            for (Product product : productList){
                for (Category prodCat : product.getCategories()){
                    if(category.getIdCategory().equals(prodCat.getIdCategory())){
                        MenuItem menuItem = new MenuItem(defaultPath, product.getTitle(), "link", null);
                        menuItemList.add(menuItem);
                    }
                }
            }
            if(menuItemList.size() > 0){
                menuSection.setChildren(menuItemList);
            }
            if(menuSection.getChildren().size() > 0){
                menuSectionList.add(menuSection);
            }
        }

        return menuSectionList;
    }


}
