package com.ecom.product.service;

import com.ecom.product.dalc.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@Service
public class InitService {

    @Autowired private CategoryService categoryService;
    @Autowired private TagService tagService;
    @Autowired private ImageService imageService;
    @Autowired private MaterialService materialService;
    @Autowired private ProductService productService;

    public void start(){

        Category cat1 = new Category(null, "Tortas", new Date(), null, null);
        Category cat2 = new Category(null, "Galletas", new Date(), null, null);
        Category cat3 = new Category(null, "Alfajores", new Date(), null, null);
        cat1 = categoryService.save(cat1);
        cat2 = categoryService.save(cat2);
        cat3 = categoryService.save(cat3);

        Tag tag1 = new Tag(null, "Masas", null, null, null);
        Tag tag2 = new Tag(null, "Dulce", null, null, null);
        Tag tag3 = new Tag(null, "Especial", null, null, null);
        tag1 = tagService.save(tag1);
        tag2 = tagService.save(tag2);
        tag3 = tagService.save(tag3);

        Material mat1 = new Material(null, null, "Chocolate", null, null, null, null);
        Material mat2 = new Material(null, null, "Manjar", null, null, null, null);
        Material mat3 = new Material(null, null, "Nueces", null, null, null, null);
        Material mat4 = new Material(null, null, "Creeps", null, null, null, null);
        mat1 = materialService.save(mat1);
        mat2 = materialService.save(mat2);
        mat3 = materialService.save(mat3);
        mat4 = materialService.save(mat4);

        Image image1 = new Image(null, "alt", "https://angular.pixelstrap.com/multikart/assets/images/product/flower/1.jpg", null, null, null);
        Image image2 = new Image(null, "alt", "https://angular.pixelstrap.com/multikart/assets/images/product/flower/2.jpg", null, null, null);
        Image image3 = new Image(null, "alt", "https://angular.pixelstrap.com/multikart/assets/images/product/flower/4.jpg", null, null, null);
        Image image4 = new Image(null, "alt", "https://angular.pixelstrap.com/multikart/assets/images/product/flower/5.jpg", null, null, null);
        Image image5 = new Image(null, "alt", "https://angular.pixelstrap.com/multikart/assets/images/product/flower/6.jpg", null, null, null);
        image1 = imageService.save(image1);
        image2 = imageService.save(image2);
        image3 = imageService.save(image3);
        image4 = imageService.save(image4);
        image5 = imageService.save(image5);

        Product prod1 = new Product(null, null, "Torta tres leches", "desc", true, 0, new BigDecimal(25000),
                false, null, null, null, true, null, null,
                image1, null, new HashSet<Image>(Arrays.asList(image2, image3, image4, image5)), new HashSet<Category>(Arrays.asList(cat1, cat2)),
                null, new HashSet<Tag>(Arrays.asList(tag1, tag2, tag3)), new HashSet<Material>(Arrays.asList(mat1, mat2, mat3, mat4)));

        Product prod2 = new Product(null, null, "Alfajor de chocolate", "desc", true, 0, new BigDecimal(30500),
                false, null, null, null, true, null, null,
                image1, null, new HashSet<Image>(Arrays.asList(image2, image3, image4, image5)), new HashSet<Category>(Arrays.asList(cat1, cat2)),
                null, new HashSet<Tag>(Arrays.asList(tag1, tag2, tag3)), new HashSet<Material>(Arrays.asList(mat1, mat2, mat3, mat4)));

        Product prod3 = new Product(null, null, "Pie de limon", "desc", true, 0, new BigDecimal(9990),
                false, null, null, null, true, null, null,
                image1, null, new HashSet<Image>(Arrays.asList(image2, image3, image4, image5)), new HashSet<Category>(Arrays.asList(cat1, cat2)),
                null, new HashSet<Tag>(Arrays.asList(tag1, tag2, tag3)), new HashSet<Material>(Arrays.asList(mat1, mat2, mat3, mat4)));

        Product prod4 = new Product(null, null, "Empanada de pino", "desc", true, 0, new BigDecimal(4490),
                true, new BigDecimal(20), null, null, true, null, null,
                image1, null, new HashSet<Image>(Arrays.asList(image2, image3, image4, image5)), new HashSet<Category>(Arrays.asList(cat1, cat2)),
                null, new HashSet<Tag>(Arrays.asList(tag1, tag2, tag3)), new HashSet<Material>(Arrays.asList(mat1, mat2, mat3, mat4)));

        Product prod5 = new Product(null, null, "Torta especial", "desc", true, 0, new BigDecimal(30000),
                true, new BigDecimal(40), null, null, true, null, null,
                image1, null, new HashSet<Image>(Arrays.asList(image2, image3, image4, image5)), new HashSet<Category>(Arrays.asList(cat1, cat2)),
                null, new HashSet<Tag>(Arrays.asList(tag1, tag2, tag3)), new HashSet<Material>(Arrays.asList(mat1, mat2, mat3, mat4)));

        Product prod6 = new Product(null, null, "Huevos de pascuas", "desc", true, 0, new BigDecimal(2990),
                false, null, null, null, true, null, null,
                image1, null, new HashSet<Image>(Arrays.asList(image2, image3, image4, image5)), new HashSet<Category>(Arrays.asList(cat1, cat2)),
                null, new HashSet<Tag>(Arrays.asList(tag1, tag2, tag3)), new HashSet<Material>(Arrays.asList(mat1, mat2, mat3, mat4)));

        productService.save(prod1);
        productService.save(prod2);
        productService.save(prod3);
        productService.save(prod4);
        productService.save(prod5);
        productService.save(prod6);

    }
}
