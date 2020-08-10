package com.ecom.product.service;

import com.ecom.product.dalc.entities.*;
import com.ecom.product.dalc.entities.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class InitService {

    @Autowired private CategoryService categoryService;
    @Autowired private TagService tagService;
    @Autowired private ImageService imageService;
    @Autowired private MaterialService materialService;
    @Autowired private ProductService productService;
    @Autowired private CollectionService collectionService;

    public void start(){

        // Categories:
        Category cat1 = new Category(null, "Tortas", new Date(), null, null);
        Category cat2 = new Category(null, "Alfajores", new Date(), null, null);
        Category cat3 = new Category(null, "Vanguardia", new Date(), null, null);
        Category cat4 = new Category(null, "Coctel", new Date(), null, null);
        Category cat5 = new Category(null, "Pasteles", new Date(), null, null);
        Category cat6 = new Category(null, "Masas", new Date(), null, null);
        cat1 = categoryService.save(cat1);
        cat2 = categoryService.save(cat2);
        cat3 = categoryService.save(cat3);
        cat4 = categoryService.save(cat4);
        cat5 = categoryService.save(cat5);
        cat6 = categoryService.save(cat6);
        // -------------------------------------------------------------------------------------------------------------

        // Tags:

        Tag tag1 = new Tag(null, "Sin azúcar", null, null, null);
        Tag tag2 = new Tag(null, "Sin lactosa", null, null, null);
        Tag tag3 = new Tag(null, "Sin gluten", null, null, null);
        Tag tag4 = new Tag(null, "Sin leche", null, null, null);
        Tag tag5 = new Tag(null, "Huevos", null, null, null);
        Tag tag6 = new Tag(null, "Mermelada", null, null, null);
        Tag tag7 = new Tag(null, "Biscocho", null, null, null);
        Tag tag8 = new Tag(null, "Crema vegetal", null, null, null);
        Tag tag9 = new Tag(null, "Almendras", null, null, null);
        Tag tag10 = new Tag(null, "Con stevia", null, null, null);
        Tag tag11 = new Tag(null, "Con sucralosa", null, null, null);
        tag1 = tagService.save(tag1);
        tag2 = tagService.save(tag2);
        tag3 = tagService.save(tag3);
        tag4 = tagService.save(tag4);
        tag5 = tagService.save(tag5);
        tag6 = tagService.save(tag6);
        tag7 = tagService.save(tag7);
        tag8 = tagService.save(tag8);
        tag9 = tagService.save(tag9);
        tag10 = tagService.save(tag10);
        tag11 = tagService.save(tag11);
        // -------------------------------------------------------------------------------------------------------------

        // Materials:
        Material mat1 = new Material(null, null, "Chocolate", null, null, null, null);
        Material mat2 = new Material(null, null, "Manjar", null, null, null, null);
        Material mat3 = new Material(null, null, "Nueces", null, null, null, null);
        Material mat4 = new Material(null, null, "Creeps", null, null, null, null);
        mat1 = materialService.save(mat1);
        mat2 = materialService.save(mat2);
        mat3 = materialService.save(mat3);
        mat4 = materialService.save(mat4);
        // -------------------------------------------------------------------------------------------------------------

        // Images:

//        Image image1 = new Image(null, "alt", "https://angular.pixelstrap.com/multikart/assets/images/product/flower/1.jpg", null, null, null);
//        Image image2 = new Image(null, "alt", "https://angular.pixelstrap.com/multikart/assets/images/product/flower/2.jpg", null, null, null);
//        Image image3 = new Image(null, "alt", "https://angular.pixelstrap.com/multikart/assets/images/product/flower/3.jpg", null, null, null);
//        Image image4 = new Image(null, "alt", "https://angular.pixelstrap.com/multikart/assets/images/product/flower/4.jpg", null, null, null);
//        Image image5 = new Image(null, "alt", "https://angular.pixelstrap.com/multikart/assets/images/product/flower/5.jpg", null, null, null);
//        Image image6 = new Image(null, "alt", "https://angular.pixelstrap.com/multikart/assets/images/product/flower/6.jpg", null, null, null);
//        image1 = imageService.save(image1);
//        image2 = imageService.save(image2);
//        image3 = imageService.save(image3);
//        image4 = imageService.save(image4);
//        image5 = imageService.save(image5);
//        image6 = imageService.save(image6);

        String rootDir = "assets/dulcelia-demo/products/";
        String imgExt = ".jpg";

        Image alfajor1 = new Image(null, "", rootDir + "alfajor_1" + imgExt, null, null, null);
        Image alfajor2 = new Image(null, "", rootDir + "alfajor_2" + imgExt, null, null, null);
        Image alfajor3 = new Image(null, "", rootDir + "alfajor_3" + imgExt, null, null, null);

        Image brownie1 = new Image(null, "", rootDir + "brownie_cafe_1" + imgExt, null, null, null);
        Image brownie2 = new Image(null, "", rootDir + "brownie_chocolate_1" + imgExt, null, null, null);

        Image huevoPascua1 = new Image(null, "", rootDir + "huevos_pascuas_1" + imgExt, null, null, null);
        Image huevoPascua2 = new Image(null, "", rootDir + "huevos_pascuas_2" + imgExt, null, null, null);
        Image huevoPascua3 = new Image(null, "", rootDir + "huevos_pascuas_3" + imgExt, null, null, null);

        Image tortaAlmendra1 = new Image(null, "", rootDir + "torta_almendra_1" + imgExt, null, null, null);

        Image tortaBisBlanco1 = new Image(null, "", rootDir + "torta_biscocho_blanco_1" + imgExt, null, null, null);
        Image tortaBisBlanco2 = new Image(null, "", rootDir + "torta_biscocho_blanco_2" + imgExt, null, null, null);

        Image tortaCafe1 = new Image(null, "", rootDir + "torta_cafe_1" + imgExt, null, null, null);
        Image tortaCafe2 = new Image(null, "", rootDir + "torta_cafe_2" + imgExt, null, null, null);
        Image tortaCafe3 = new Image(null, "", rootDir + "torta_cafe_3" + imgExt, null, null, null);
        Image tortaCafe4 = new Image(null, "", rootDir + "torta_cafe_4" + imgExt, null, null, null);

        Image tortaChoco1 = new Image(null, "", rootDir + "torta_chocolate_1" + imgExt, null, null, null);
        Image tortaChoco2 = new Image(null, "", rootDir + "torta_chocolate_2" + imgExt, null, null, null);
        Image tortaChoco3 = new Image(null, "", rootDir + "torta_chocolate_3" + imgExt, null, null, null);

        Image tortaFruta1 = new Image(null, "", rootDir + "torta_fruta_1" + imgExt, null, null, null);
        Image tortaFruta2 = new Image(null, "", rootDir + "torta_fruta_2" + imgExt, null, null, null);
        Image tortaFruta3 = new Image(null, "", rootDir + "torta_fruta_3" + imgExt, null, null, null);

        Image tortaHoja1 = new Image(null, "", rootDir + "torta_hojarasca_1" + imgExt, null, null, null);
        Image tortaHoja2 = new Image(null, "", rootDir + "torta_hojarasca_2" + imgExt, null, null, null);
        Image tortaHoja3 = new Image(null, "", rootDir + "torta_hojarasca_3" + imgExt, null, null, null);

        Image tortaLeche1 = new Image(null, "", rootDir + "torta_leches_1" + imgExt, null, null, null);
        Image tortaLeche2 = new Image(null, "", rootDir + "torta_leches_2" + imgExt, null, null, null);

        Image tortaLucuma1 = new Image(null, "", rootDir + "torta_lucuma_1" + imgExt, null, null, null);
        Image tortaLucuma2 = new Image(null, "", rootDir + "torta_lucuma_2" + imgExt, null, null, null);
        Image tortaLucuma3 = new Image(null, "", rootDir + "torta_lucuma_3" + imgExt, null, null, null);
        Image tortaLucuma4 = new Image(null, "", rootDir + "torta_lucuma_4" + imgExt, null, null, null);

        Image tortaManjar1 = new Image(null, "", rootDir + "torta_manjar_1" + imgExt, null, null, null);
        Image tortaManjar2 = new Image(null, "", rootDir + "torta_manjar_2" + imgExt, null, null, null);
        Image tortaManjar3 = new Image(null, "", rootDir + "torta_manjar_3" + imgExt, null, null, null);

        Image tortaMilHojas1 = new Image(null, "", rootDir + "torta_mil_hojas_1" + imgExt, null, null, null);
        Image tortaMilHojas2 = new Image(null, "", rootDir + "torta_mil_hojas_2" + imgExt, null, null, null);

        Image tortaNaranja1 = new Image(null, "", rootDir + "torta_naranja_1" + imgExt, null, null, null);

        Image tortaOriente1 = new Image(null, "", rootDir + "torta_oriente_1" + imgExt, null, null, null);
        Image tortaOriente2 = new Image(null, "", rootDir + "torta_oriente_2" + imgExt, null, null, null);

        Image tortaPina1 = new Image(null, "", rootDir + "torta_pina_1" + imgExt, null, null, null);
        Image tortaPina2 = new Image(null, "", rootDir + "torta_pina_2" + imgExt, null, null, null);
        Image tortaPina3 = new Image(null, "", rootDir + "torta_pina_3" + imgExt, null, null, null);

        Image tortaRosa1 = new Image(null, "", rootDir + "torta_rosa_1" + imgExt, null, null, null);
        Image tortaRosa2 = new Image(null, "", rootDir + "torta_rosa_2" + imgExt, null, null, null);

        Image sachertote1 = new Image(null, "", rootDir + "torta_sachertote_1" + imgExt, null, null, null);
        Image sachertote2 = new Image(null, "", rootDir + "torta_sachertote_2" + imgExt, null, null, null);

        Image tortaSelva1 = new Image(null, "", rootDir + "torta_selva_negra_1" + imgExt, null, null, null);

        alfajor1 = imageService.save(alfajor1);
        alfajor2 = imageService.save(alfajor2);
        alfajor3 = imageService.save(alfajor3);

        brownie1 = imageService.save(brownie1);
        brownie2 = imageService.save(brownie2);

        huevoPascua1 = imageService.save(huevoPascua1);
        huevoPascua2 = imageService.save(huevoPascua2);
        huevoPascua3 = imageService.save(huevoPascua3);

        tortaAlmendra1 = imageService.save(tortaAlmendra1);

        tortaBisBlanco1 = imageService.save(tortaBisBlanco1);
        tortaBisBlanco2 = imageService.save(tortaBisBlanco2);

        tortaCafe1 = imageService.save(tortaCafe1);
        tortaCafe2 = imageService.save(tortaCafe2);
        tortaCafe3 = imageService.save(tortaCafe3);
        tortaCafe4 = imageService.save(tortaCafe4);

        tortaChoco1 = imageService.save(tortaChoco1);
        tortaChoco2 = imageService.save(tortaChoco2);
        tortaChoco3 = imageService.save(tortaChoco3);

        tortaFruta1 = imageService.save(tortaFruta1);
        tortaFruta2 = imageService.save(tortaFruta2);
        tortaFruta3 = imageService.save(tortaFruta3);

        tortaHoja1 = imageService.save(tortaHoja1);
        tortaHoja2 = imageService.save(tortaHoja2);
        tortaHoja3 = imageService.save(tortaHoja3);

        tortaLeche1 = imageService.save(tortaLeche1);
        tortaLeche2 = imageService.save(tortaLeche2);

        tortaLucuma1 = imageService.save(tortaLucuma1);
        tortaLucuma2 = imageService.save(tortaLucuma2);
        tortaLucuma3 = imageService.save(tortaLucuma3);
        tortaLucuma4 = imageService.save(tortaLucuma4);

        tortaManjar1 = imageService.save(tortaManjar1);
        tortaManjar2 = imageService.save(tortaManjar2);
        tortaManjar3 = imageService.save(tortaManjar3);

        tortaMilHojas1 = imageService.save(tortaMilHojas1);
        tortaMilHojas2 = imageService.save(tortaMilHojas2);

        tortaNaranja1 = imageService.save(tortaNaranja1);

        tortaOriente1 = imageService.save(tortaOriente1);
        tortaOriente2 = imageService.save(tortaOriente2);

        tortaPina1 = imageService.save(tortaPina1);
        tortaPina2 = imageService.save(tortaPina2);
        tortaPina3 = imageService.save(tortaPina3);

        tortaRosa1 = imageService.save(tortaRosa1);
        tortaRosa2 = imageService.save(tortaRosa2);

        sachertote1 = imageService.save(sachertote1);
        sachertote2 = imageService.save(sachertote2);

        tortaSelva1 = imageService.save(tortaSelva1);

        // -------------------------------------------------------------------------------------------------------------

        // Collections:
        Collection col1 = new Collection(null, "Destacados", null, null, null);
        Collection col2 = new Collection(null, "Cumpleaños", null, null, null);
        Collection col3 = new Collection(null, "Más Vendidos", null, null, null);
        Collection col4 = new Collection(null, "Fechas Importantes", null, null, null);
        col1 = collectionService.save(col1);
        col2 = collectionService.save(col2);
        col3 = collectionService.save(col3);
        col4 = collectionService.save(col4);
        // -------------------------------------------------------------------------------------------------------------

        // Products:
        String hojarascaDesc = "Manjar chocolates sin gluten, sin lactosa con stevia. Venta solo en local San Bernardo.";
        String alfajoresDesc = "12 Unidades. Manjar chocolates sin gluten, sin lactosa con stevia.";
        String rosaDesc = "Biscocho blanco, crema vegetal, mermelada de frambuesa, frambuesa natural, puede ser sin lactosa, con Stevia";
        String selvaNegraDesc = "Biscocho Negro, crema vegetal, mermelada de frambuesa, frambuesa natural, guindas, cacao, chocolate. puede ser sin lactosa y con Stevia";
        String lucumaDesc = "Biscocho Blanco, crema vegetal con Pulpa de lúcuma natural, puede ser con nuez o durazno, sin lactosa y con Stevia";
        String frutaDesc = "Biscocho Blanco, crema vegetal, Piña, Mango o Fruta de la temporada, sin lactosa, con o con Stevia";
        String mousseDesc = "Biscocho Blanco, crema vegetal, yogurt, Frutilla. Puede ser Sin lactosa, con o con Stevia";
        String manjarDesc = "Biscocho blanco, crema vegetal con manjar, puede ser sin lactosa o sin azucar, con nuez o Durazno";
        String pinaDesc = "Biscocho blanco, crema vegetal, Piña natural. Puede ser sin lactosa y con Stevia.";
        String chocolateDesc = "Biscocho negro, crema vegetal, cobertura de chocolate con o sin azúcar 70% cacao. Puede ser sin lactosa, con sucralosa.";
        String cafeDesc = "Biscocho Blanco, crema vegetal con café, puede ser con nuez. Puede ser Sin lactosa y con o sin Stevia";

        String vManjarAlmDesc = "Biscocho blanco, crema vegetal con manjar, almendras peladas. Puede ser sin azúcar o sin lactosa.";
        String vNaranjaDesc = "Biscocho blanco, crema pastelera de jugo de naranja, cobertura de chocolate. Puede ser sin azúcar o sin leche.";
        String vSanMarcosDesc = "Biscocho blanco, crema vegetal, crema de huevo, trufa de chocolate y almendras. Puede ser sin azúcar o sin leche.";
        String vFrutosDesc = "Biscocho negro, crema vegetal, crema de chocolate, mermelada de berries, berries naturales. Puede ser sin azúcar o sin leche.";
        String vOriente = "Biscocho blanco, crema vegetal, mousse de pistacho y almendras. Puede ser sin azúcar o sin leche.";
        String vLechesDesc = "Biscocho blanco, crema vegetal, leche condensada, leche evaporada, merengue de huevo natural.";
        String vSachertote = "Biscocho negro, crema de chocolate, mermelada de frambueza y damasco, bañado en chocolate. Puede ser sin azúcar o sin leche.";
        String vHojasManjar = "Hojarasca, manjar con crema vegetal. Puede ser sin azúcar o sin leche.";

        String pastelDesc = "Sin azúcar, sin gluten y sin lactosa.";
        String empanadaDesc = "Sin azúcar, sin gluten y sin lactosa.";
        String deliciasDesc = "Sin azúcar, sin gluten y sin lactosa.";
        String pascuasDesc = "Sin azúcar, sin gluten y sin lactosa.";

        Product tortaHojarasca = new Product(null, null, "Torta de Hojarasca", hojarascaDesc, true, 0, new BigDecimal(8900),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaHoja1, tortaHoja2, tortaHoja3)), new HashSet<Category>(Arrays.asList(cat1)),
                col3, new HashSet<Tag>(Arrays.asList(tag3, tag10)), null);

        Product alfajores = new Product(null, null, "Alfajores", alfajoresDesc, true, 0, new BigDecimal(9500),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(alfajor1, alfajor2, alfajor3)), new HashSet<Category>(Arrays.asList(cat2)),
                col4, new HashSet<Tag>(Arrays.asList(tag3, tag10)), null);

        Product tortaRosa = new Product(null, null, "Torta Rosa", rosaDesc, true, 0, new BigDecimal(19990),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaRosa1, tortaRosa2)), new HashSet<Category>(Arrays.asList(cat1)),
                col2, new HashSet<Tag>(Arrays.asList(tag3, tag10, tag6, tag7, tag8)), null);

        Product tortaSelvaNegra = new Product(null, null, "Selva Negra", selvaNegraDesc, true, 0, new BigDecimal(24500),
                true, new BigDecimal(20), null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaSelva1)), new HashSet<Category>(Arrays.asList(cat1)),
                col4, new HashSet<Tag>(Arrays.asList(tag3, tag10, tag6, tag7, tag8)), null);

        Product tortaLucuma = new Product(null, null, "Torta de Lúcuma", lucumaDesc, true, 0, new BigDecimal(34500),
                true, new BigDecimal(40), null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaLucuma1, tortaLucuma2, tortaLucuma3, tortaLucuma4)), new HashSet<Category>(Arrays.asList(cat1)),
                col4, new HashSet<Tag>(Arrays.asList(tag3, tag10, tag7, tag8)), null);

        Product tortaFruta = new Product(null, null, "Torta de Fruta", frutaDesc, true, 0, new BigDecimal(43500),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaFruta1, tortaFruta2, tortaFruta3)), new HashSet<Category>(Arrays.asList(cat1)),
                col2, new HashSet<Tag>(Arrays.asList(tag3, tag10, tag6, tag7, tag8)), null);

        Product tortaMousseFrutilla = new Product(null, null, "Torta Mousse Frutilla", mousseDesc, true, 0, new BigDecimal(54500),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaAlmendra1)), new HashSet<Category>(Arrays.asList(cat1)),
                col2, new HashSet<Tag>(Arrays.asList(tag3, tag10, tag7, tag8)), null);

        Product tortaManjar = new Product(null, null, "Torta de Manjar", manjarDesc, true, 0, new BigDecimal(19990),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaManjar1, tortaManjar2, tortaManjar3)), new HashSet<Category>(Arrays.asList(cat1)),
                col2, new HashSet<Tag>(Arrays.asList(tag1, tag3, tag7, tag8)), null);

        Product tortaPina = new Product(null, null, "Torta de Piña", pinaDesc, true, 0, new BigDecimal(24500),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaPina1, tortaPina2, tortaPina3)), new HashSet<Category>(Arrays.asList(cat1)),
                col3, new HashSet<Tag>(Arrays.asList(tag3, tag10, tag7, tag8)), null);

        Product tortaChocolate = new Product(null, null, "Torta de Chocolate", chocolateDesc, true, 0, new BigDecimal(34500),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaChoco1, tortaChoco2, tortaChoco3)), new HashSet<Category>(Arrays.asList(cat1)),
                col3, new HashSet<Tag>(Arrays.asList(tag3, tag11, tag7, tag8)), null);

        Product tortaCafe = new Product(null, null, "Torta de Café", cafeDesc, true, 0, new BigDecimal(43500),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaCafe1, tortaCafe2)), new HashSet<Category>(Arrays.asList(cat1)),
                col3, new HashSet<Tag>(Arrays.asList(tag3, tag10, tag7, tag8)), null);

        // Vanguard
        Product vangManjarAlmendras = new Product(null, null, "Torta de Manjar y Almendras", vManjarAlmDesc, true, 0, new BigDecimal(19990),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaCafe3, tortaCafe4)), new HashSet<Category>(Arrays.asList(cat1, cat3)),
                col1, new HashSet<Tag>(Arrays.asList(tag1, tag3, tag7, tag8, tag9)), null);

        Product vangNaranja = new Product(null, null, "Torta de Naranja", vNaranjaDesc, true, 0, new BigDecimal(24500),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaNaranja1)), new HashSet<Category>(Arrays.asList(cat1, cat3)),
                col4, new HashSet<Tag>(Arrays.asList(tag1, tag4, tag7, tag8)), null);

        Product vangSanMarcos = new Product(null, null, "Torta San Marcos", vSanMarcosDesc, true, 0, new BigDecimal(34500),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaBisBlanco1)), new HashSet<Category>(Arrays.asList(cat1, cat3)),
                col1, new HashSet<Tag>(Arrays.asList(tag1, tag4, tag5, tag7, tag8, tag9)), null);

        Product vangFrutosBosque = new Product(null, null, "Torta Frutos del Bosque", vFrutosDesc, true, 0, new BigDecimal(54500),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaBisBlanco2)), new HashSet<Category>(Arrays.asList(cat1, cat3)),
                col1, new HashSet<Tag>(Arrays.asList(tag1, tag4, tag7, tag8)), null);

        Product vangOriente = new Product(null, null, "Torta del Oriente", vOriente, true, 0, new BigDecimal(19990),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaOriente1, tortaOriente2)), new HashSet<Category>(Arrays.asList(cat1, cat3)),
                col1, new HashSet<Tag>(Arrays.asList(tag1, tag4, tag7, tag8, tag9)), null);

        Product vangLeches = new Product(null, null, "Torta Tres Leches", vLechesDesc, true, 0, new BigDecimal(24500),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaLeche1, tortaLeche2)), new HashSet<Category>(Arrays.asList(cat1, cat3)),
                col1, new HashSet<Tag>(Arrays.asList(tag5, tag7, tag8)), null);

        Product vangSachertote = new Product(null, null, "Torta Sachertote", vSachertote, true, 0, new BigDecimal(34500),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(sachertote1, sachertote2)), new HashSet<Category>(Arrays.asList(cat1, cat3)),
                col1, new HashSet<Tag>(Arrays.asList(tag1, tag4, tag6, tag7, tag8)), null);

        Product vangHojasManjar = new Product(null, null, "Torta Hojarasca de Manjar", vHojasManjar, true, 0, new BigDecimal(54500),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(tortaMilHojas1, tortaMilHojas2)), new HashSet<Category>(Arrays.asList(cat1, cat3)),
                col4, new HashSet<Tag>(Arrays.asList(tag1, tag4, tag8)), null);

        // coctel
        Product cPasteles = new Product(null, null, "Pasteles de Coctel", pastelDesc, true, 0, new BigDecimal(34900),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(brownie1, brownie2)), new HashSet<Category>(Arrays.asList(cat4, cat6, cat5)),
                col4, new HashSet<Tag>(Arrays.asList(tag1, tag2, tag3)), null);

//        Product cEmpanadas = new Product(null, null, "Empanadas Surtidas", empanadaDesc, true, 0, new BigDecimal(43500),
//                false, null, null, null, true, null, null,
//                null, new HashSet<Image>(Arrays.asList(image6)), new HashSet<Category>(Arrays.asList(cat4, cat6)),
//                col2, new HashSet<Tag>(Arrays.asList(tag1, tag2, tag3)), null);

        Product cdelicias = new Product(null, null, "Delicias de Coctel", deliciasDesc, true, 0, new BigDecimal(33500),
                false, null, null, null, true, null, null,
                null, new HashSet<Image>(Arrays.asList(huevoPascua1, huevoPascua2, huevoPascua3)), new HashSet<Category>(Arrays.asList(cat4, cat6)),
                col4, new HashSet<Tag>(Arrays.asList(tag1, tag2, tag3)), null);

        // Masas
//        Product mPanPascuas = new Product(null, null, "Pan de Pascuas", pascuasDesc, true, 0, new BigDecimal(4900),
//                false, null, null, null, true, null, null,
//                null, new HashSet<Image>(Arrays.asList(image6)), new HashSet<Category>(Arrays.asList(cat6)),
//                col2, new HashSet<Tag>(Arrays.asList(tag1, tag2, tag3)), null);

        productService.save(tortaHojarasca);
        productService.save(alfajores);
        productService.save(tortaRosa);
        productService.save(tortaSelvaNegra);
        productService.save(tortaLucuma);
        productService.save(tortaFruta);
        productService.save(tortaMousseFrutilla);
        productService.save(tortaManjar);
        productService.save(tortaPina);
        productService.save(tortaChocolate);
        productService.save(tortaCafe);

        productService.save(vangManjarAlmendras);
        productService.save(vangNaranja);
        productService.save(vangSanMarcos);
        productService.save(vangFrutosBosque);
        productService.save(vangOriente);
        productService.save(vangLeches);
        productService.save(vangSachertote);
        productService.save(vangHojasManjar);

        productService.save(cPasteles);
//        productService.save(cEmpanadas);
        productService.save(cdelicias);
//        productService.save(mPanPascuas);
        // -------------------------------------------------------------------------------------------------------------

    }
}
