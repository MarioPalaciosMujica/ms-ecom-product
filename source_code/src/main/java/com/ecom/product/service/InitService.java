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
        Category tradicionales = new Category(null, "Tortas Tradicionáles", new Date(), null, null);
        Category vanguard = new Category(null, "Tortas de Vanguardia", new Date(), null, null);
        //Category alfajores = new Category(null, "Alfajores", new Date(), null, null);
        Category coctel = new Category(null, "Coctel", new Date(), null, null);
        Category masas = new Category(null, "Masas", new Date(), null, null);
        Category dulces = new Category(null, "Dulces", new Date(), null, null);
        Category pan = new Category(null, "Pan", new Date(), null, null);

        tradicionales = categoryService.save(tradicionales);
        vanguard = categoryService.save(vanguard);
        //alfajores = categoryService.save(alfajores);
        coctel = categoryService.save(coctel);
        masas = categoryService.save(masas);
        dulces = categoryService.save(dulces);
        pan = categoryService.save(pan);
        // -------------------------------------------------------------------------------------------------------------

        // Tags:

        Tag sinAzucar = new Tag(null, "Sin azúcar", null, null, null);
        Tag sinLactosa = new Tag(null, "Sin lactosa", null, null, null);
        Tag sinGluten = new Tag(null, "Sin gluten", null, null, null);
        Tag sinLeche = new Tag(null, "Sin leche", null, null, null);
        Tag conStevia = new Tag(null, "Con stevia", null, null, null);
        Tag conSucralosa = new Tag(null, "Con sucralosa", null, null, null);
        sinAzucar = tagService.save(sinAzucar);
        sinLactosa = tagService.save(sinLactosa);
        sinGluten = tagService.save(sinGluten);
        sinLeche = tagService.save(sinLeche);
        conStevia = tagService.save(conStevia);
        conSucralosa = tagService.save(conSucralosa);
        // -------------------------------------------------------------------------------------------------------------

        // Images:
        List<Image> listImages = this.genImages(new ArrayList<>(
                Arrays.asList(
                        "adornos_ninos_01", //
                        "adornos_ninos_02", //
                        "adornos_tortas_01", //
                        "adornos_tortas_02", //
                        "adornos_tortas_03", //
                        "adornos_tortas_04", //
                        "adornos_tortas_05", //
                        "adornos_tortas_06", //
                        "alfajores_01",
                        "alfajores_02",
                        "cupcake_diseno_01",
                        "cupcake_diseno_02",
                        "cupcake_diseno_03",
                        "cupcake_diseno_04",
                        "cupcake_diseno_05",
                        "cupcake_diseno_06",
                        "cupcake_tradicional_01",
                        "cupcake_tradicional_02",
                        "cupcake_tradicional_03",
                        "empanadas_01",
                        "empanadas_02",
                        "empanadas_03",
                        "fruta_01",
                        "fruta_02",
                        "frutos_del_bosque_01",
                        "frutos_del_bosque_02",
                        "frutos_del_bosque_03",
                        "kuchen_arandano_01",
                        "kuchen_manzana_01",
                        "mousse_frutilla_01",
                        "pastelitos_surtidos_01",
                        "pastelitos_surtidos_02",
                        "pastelitos_surtidos_03",
                        "pastelitos_surtidos_04",
                        "pie_limon_01",
                        "sachertorte_01",
                        "selva_negra_01",
                        "selva_negra_02",
                        "selva_negra_03",
                        "tarta_indi_01",
                        "tartaleta_01",
                        "tartaleta_02",
                        "tartaleta_03",
                        "tartaleta_04",
                        "tartaleta_05",
                        "tartaleta_06",
                        "tasitas_chocolate_01",
                        "tasitas_chocolate_02",
                        "torta_chocolate_01",
                        "torta_chocolate_02",
                        "torta_chocolate_03",
                        "torta_chocolate_04",
                        "torta_chocolate_05",
                        "torta_hojarasca_manjar_01",
                        "torta_manjar_chocolate_01",
                        "torta_matcha_01",
                        "torta_matcha_02",
                        "torta_matcha_03",
                        "torta_moka_01",
                        "torta_moka_02",
                        "torta_musse_frutas_01",
                        "torta_naranja_01",
                        "torta_oriente_01",
                        "torta_oriente_02",
                        "torta_pina_01",
                        "torta_pina_02",
                        "torta_pina_03",
                        "torta_rosa_01",
                        "torta_rosa_02",
                        "torta_tres_leches_01",
                        "torta_tres_leches_02",
                        "canapes_01",
                        "canapes_02",
                        "pan_molde_01",
                        "pan_molde_02",
                        "pan_almendra_01",
                        "torta_lucuma_01",
                        "torta_manjar_01",
                        "tapaditos_01",
                        "tapaditos_02",
                        "pan_linaza_01"
                )
        ));


        // -------------------------------------------------------------------------------------------------------------

        // Collections:
        Collection destacados = new Collection(null, "Destacados", null, null, null);
        Collection populares = new Collection(null, "Populares", null, null, null);
        Collection vendidos = new Collection(null, "Más Vendidos", null, null, null);
        Collection fechas = new Collection(null, "Fechas Importantes", null, null, null);
        destacados = collectionService.save(destacados);
        populares = collectionService.save(populares);
        vendidos = collectionService.save(vendidos);
        fechas = collectionService.save(fechas);
        // -------------------------------------------------------------------------------------------------------------

        // Products:
        String TortadeHojarasca = "Torta de Hojarasca, manjar chocolate. Sin Gluten, Sin Lactosa con Stevia. Venta solo en local San Bernardo. Torta para 15 personas.";
        String AlfajoresdeManjaryChocolate = "Caja de 12 unidades.Sin Gluten, Sin Lactosa con Stevia. Sin Azucar añadida.";
        String TortaRosa = "Biscocho blanco, crema vegetal, mermelada de frambuesa, frambuesa natural, puede ser sin lactosa, con Stevia. Torta para 15 personas.";
        String SelvaNegra = "Biscocho Negro, crema vegetal, mermelada de frambuesa, frambuesa natural, guindas, cacao, chocolate. puede ser sin lactosa y  con Stevia. Torta para 15 personas.";
        String TortadeLucuma = "Biscocho Blanco, crema vegetal con  Pulpa de lúcuma natural, puede ser con nuez o durazno. Sin lactosa y con Stevia. Torta para 15 personas.";
        String TortadeFruta = "Biscocho Blanco, crema vegetal, Piña, Mango o Fruta de la temporada. Sin lactosa, con o sin Stevia. Torta para 15 personas.";
        String TortadeMousseFrutilla = "Biscocho Blanco, crema vegetal, yogurt, Frutilla. Puede ser Sin lactosa, con o sin Stevia. Torta para 15 personas.";
        String TortadeManjar = "Biscocho Blanco, crema vegetal, yogurt, Frutilla. Puede ser Sin lactosa, con o sin Stevia. Torta para 15 personas.";
        String TortadePina = "Biscocho blanco, crema vegetal y piña natural. Puede ser sin lactosa y con Stevia Torta para 15 personas..";
        String TortadeChocolate = "Biscocho negro, crema vegetal, cobertura de chocolate con o sin azúcar 70% cacao. Puede ser sin lactosa, con sucralosa. Torta para 15 personas.";
        String TortadeCafé = "Biscocho negro, crema vegetal, cobertura de chocolate con o sin azúcar 70% cacao. Puede ser sin lactosa, con sucralosa. Torta para 15 personas.";


        String TortadeManjaryAlmendras = "Biscocho blanco, crema vegetal con manjar, almendras peladas. Puede ser sin azúcar o sin lactosa. Torta para 15 personas.";
        String TortaSanMarcos = "Biscocho blanco, crema vegetal, crema de huevo, trufa de chocolate y almendras. Puede ser sin azúcar o sin leche. Torta para 15 personas.";
        String TortaOriente = "Biscocho blanco, crema vegetal, mousse de pistacho y almendras. Puede ser sin azúcar o sin leche. Torta para 15 personas.";
        String TortaSachertorte = "Biscocho negro, crema de chocolate, mermelada de frambueza y damasco, bañado en chocolate. Puede ser sin azúcar o sin leche. Torta para 15 personas.";
        String TortadeNaranja = "Biscocho negro, crema de chocolate, mermelada de frambueza y damasco, bañado en chocolate. Puede ser sin azúcar o sin leche. Torta para 15 personas.";
        String TortaFrutosdelBosque = "Biscocho negro, crema vegetal, crema de chocolate, mermelada de berries, berries naturales. Puede ser sin azúcar o sin leche. Torta para 15 personas.";
        String TortaTresLeches = "Biscocho blanco, crema vegetal, leche condensada, leche evaporada, merengue de huevo natural. Torta para 15 personas.";
        String TortaHojarascaManjar = "Hojarasca, manjar con crema vegetal. Puede ser sin azúcar o sin leche. Torta para 15 personas.";
        String TortaManjarChocolate = "Torta de mankar y chocolate. Puede ser sin azúcar o sin leche. Torta para 15 personas.";
        String TortaMatcha = "Torta insignia de Dulcelia. Sin gluten y puede ser sin azúcar o sin leche. Torta para 15 personas.";

        String KuchenFrutas = "Kuchenes de diferentes frutas a elección. Puede ser sin lactosa, con sucralosa.";
        String TartaletaFrutas = "Tartaletas de frutas de estación, a su elección. Puede ser sin lactosa, con sucralosa.";
        String PieLimon = "Pie de Limón sin gluten. Puede ser sin lactosa, con sucralosa.";

        String PastelesSurtidos = "100 Unidades.";
        String CupcakesTradicionales = "Los cupcakes tradicionáles que conoces. Pueden ser con mousse de chocolate o manjar. Sin gluten y sin lactosa. El precio es por cada unidad.";
        String CupcakesDiseno = "Cupcakes con diferentes diseños, colores y adornos. Pueden ser con mousse de chocolate o manjar. Sin gluten y sin lactosa. El precio es por cada unidad.";
        String CanapesSurtidos = "100 Unidades. ";
        String Tapaditos = "100 Unidades. ";
        String Pizzetas = "100 Unidades. ";
        String Canoas  = "100 Unidades. Rellenas saltadas.";
        String TacitasdeChocolate = "100 Unidades. Crema de diferentes sabores.";

        String PanMolde = "Sin gluten, Sin leche, Sin azúcar";
        String PanLinaza = "Sin gluten, Sin leche, Sin azúcar";
        String PanAlmendras = "Sin gluten, Sin leche, Sin azúcar";
        String PastelesBrazosdeReina = "100 Unidades.";
        String EmpanaditasSurtidas = "Empanadas de pino, champiñón queso, verduras, camarones queso. Sin gluten, sin azucar y sin leche. 100 Unidades.";
        String PandePascuas = "Sin gluten, sin azucar y sin leche.";
        String Pan = "Sin gluten, sin azucar y sin leche.";
        String Empanadas = "Sin gluten, sin azucar y sin leche.";

        // TRADICIONALES

        // torta rosa
        this.genProduct("Torta Rosa", TortaRosa, false, new BigDecimal(19990), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("torta_rosa_01", "torta_rosa_02"))), new HashSet<Category>(Arrays.asList(tradicionales)), fechas, new HashSet<Tag>(Arrays.asList(sinLactosa, conStevia)));

        // torta selva negra
        this.genProduct("Selva Negra", SelvaNegra, false, new BigDecimal(19990), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("selva_negra_01", "selva_negra_02", "selva_negra_03"))), new HashSet<Category>(Arrays.asList(tradicionales)), populares, new HashSet<Tag>(Arrays.asList(sinLactosa, conStevia)));

        // torta de piña
        this.genProduct("Torta de Piña", TortadePina, false, new BigDecimal(19990), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("torta_pina_01", "torta_pina_02", "torta_pina_03"))), new HashSet<Category>(Arrays.asList(tradicionales)), populares, new HashSet<Tag>(Arrays.asList(sinLactosa, conStevia)));

        // torta de lucuma
        this.genProduct("Torta de Lúcuma", TortadeLucuma, false, new BigDecimal(19990), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("torta_lucuma_01"))), new HashSet<Category>(Arrays.asList(tradicionales)), vendidos, new HashSet<Tag>(Arrays.asList(sinLactosa, conStevia)));

        // torta de chocolate
        this.genProduct("Torta de Chocolate", TortadeChocolate, false, new BigDecimal(19990), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("torta_chocolate_01", "torta_chocolate_02", "torta_chocolate_03", "torta_chocolate_04", "torta_chocolate_05"))),
                new HashSet<Category>(Arrays.asList(tradicionales)), vendidos, new HashSet<Tag>(Arrays.asList(sinLactosa, conSucralosa)));

        // torta de fruta
        this.genProduct("Torta de Fruta", TortadeFruta, false, new BigDecimal(19990), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("fruta_01", "fruta_02"))), new HashSet<Category>(Arrays.asList(tradicionales)), vendidos, new HashSet<Tag>(Arrays.asList(sinLactosa, conStevia)));

        // torta de moka
        this.genProduct("Torta de Moka", TortadeCafé, false, new BigDecimal(19990), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("torta_moka_01", "torta_moka_02"))), new HashSet<Category>(Arrays.asList(tradicionales)), vendidos, new HashSet<Tag>(Arrays.asList(sinLactosa, conStevia)));


        // mousse de frutas / frutilla
        this.genProduct("Torta Mousse de Frutas", TortadeMousseFrutilla, false, new BigDecimal(19990), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("mousse_frutilla_01"))), new HashSet<Category>(Arrays.asList(tradicionales)), populares, new HashSet<Tag>(Arrays.asList(sinLactosa, conStevia)));



        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // VANGUARDIA

        // torta san marcos
//        this.genProduct("Torta San Marcos", TortaSanMarcos, false, new BigDecimal(21500), this.searchImage(listImages,
//                new ArrayList<>(Arrays.asList("mousse_01"))), new HashSet<Category>(Arrays.asList(vanguard)), destacados, new HashSet<Tag>(Arrays.asList(sinAzucar, sinLeche)));

        // torta manjar almendras
//        this.genProduct("Torta de Manjar y Almendras", TortaHojarascaManjar, false, new BigDecimal(21500), this.searchImage(listImages,
//                new ArrayList<>(Arrays.asList("torta_mousse_05"))), new HashSet<Category>(Arrays.asList(tradicionales)), fechas, new HashSet<Tag>(Arrays.asList(sinAzucar, sinLactosa)));

        // torta de naranja
        this.genProduct("Torta de Naranja", TortadeNaranja, false, new BigDecimal(21500), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("torta_naranja_01"))), new HashSet<Category>(Arrays.asList(vanguard)), destacados, new HashSet<Tag>(Arrays.asList(sinAzucar, sinLeche)));

        // torta frutos del bosque
        this.genProduct("Torta Frutos del Bosque", TortaFrutosdelBosque, false, new BigDecimal(21500), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("frutos_del_bosque_01", "frutos_del_bosque_02"))), new HashSet<Category>(Arrays.asList(vanguard)), destacados, new HashSet<Tag>(Arrays.asList(sinAzucar, sinLeche)));

        // torta oriente
        this.genProduct("Torta Oriente", TortaOriente, false, new BigDecimal(22500), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("torta_oriente_01", "torta_oriente_02"))), new HashSet<Category>(Arrays.asList(vanguard)), destacados, new HashSet<Tag>(Arrays.asList(sinAzucar, sinLeche)));

        // torta tres leches
        this.genProduct("Torta Tres Leches", TortaTresLeches, false, new BigDecimal(21500), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("torta_tres_leches_01", "torta_tres_leches_02"))), new HashSet<Category>(Arrays.asList(vanguard)), destacados, new HashSet<Tag>(Arrays.asList(sinAzucar, sinGluten)));

        // sachertorte
        this.genProduct("Torta Sachertorte", TortaSachertorte, false, new BigDecimal(21500), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("sachertorte_01"))), new HashSet<Category>(Arrays.asList(vanguard)), destacados, new HashSet<Tag>(Arrays.asList(sinAzucar, sinLeche)));

        // torta hojarasca manjar
        this.genProduct("Torta Hojarasca Manjar", TortaHojarascaManjar, false, new BigDecimal(21500), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("torta_hojarasca_manjar_01"))), new HashSet<Category>(Arrays.asList(vanguard)), destacados, new HashSet<Tag>(Arrays.asList(sinAzucar, sinLeche)));

        // torta manjar chocolate
        this.genProduct("Torta de Manjar Chocolate", TortaManjarChocolate, false, new BigDecimal(21500), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("torta_manjar_01"))), new HashSet<Category>(Arrays.asList(vanguard)), destacados, new HashSet<Tag>(Arrays.asList(sinAzucar, sinLeche)));

        // torta matcha
        this.genProduct("Torta Matcha", TortaMatcha, false, new BigDecimal(22500), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("torta_matcha_01", "torta_matcha_02", "torta_matcha_03"))), new HashSet<Category>(Arrays.asList(vanguard)), destacados, new HashSet<Tag>(Arrays.asList(sinAzucar, sinLeche)));

        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // COCTEL

        // cupcakes tradicionales
        this.genProduct("Cupcakes Tradicionáles", CupcakesTradicionales, false, new BigDecimal(1500), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("cupcake_tradicional_01", "cupcake_tradicional_02", "cupcake_tradicional_03"))),
                new HashSet<Category>(Arrays.asList(coctel)), populares, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // cupcakes con diseño
        this.genProduct("Cupcakes con Diseño", CupcakesDiseno, false, new BigDecimal(1800), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("cupcake_diseno_01", "cupcake_diseno_02", "cupcake_diseno_03", "cupcake_diseno_04", "cupcake_diseno_05", "cupcake_diseno_06"))),
                new HashSet<Category>(Arrays.asList(coctel)), populares, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // pasteles surtidos
        this.genProduct("Pastelitos Surtidos", PastelesSurtidos, false, new BigDecimal(35500), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("pastelitos_surtidos_01", "pastelitos_surtidos_02", "pastelitos_surtidos_03", "pastelitos_surtidos_04"))),
                new HashSet<Category>(Arrays.asList(coctel)), populares, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // empanadas surtidas
        this.genProduct("Empanaditas Surtidas", EmpanaditasSurtidas, false, new BigDecimal(35500), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("empanadas_01"))), new HashSet<Category>(Arrays.asList(coctel)), populares, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // canapes surtidos
        this.genProduct("Canapes Surtidos", CanapesSurtidos, false, new BigDecimal(34900), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("canapes_01", "canapes_02"))),
                new HashSet<Category>(Arrays.asList(coctel)), fechas, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // tapaditos
        this.genProduct("Tapaditos", Tapaditos, false, new BigDecimal(34500), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("tapaditos_01", "tapaditos_02"))), new HashSet<Category>(Arrays.asList(coctel)), vendidos, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // pizzetas
//        this.genProduct("Pizzetas", Pizzetas, false, new BigDecimal(32500), this.searchImage(listImages,
//                new ArrayList<>(Arrays.asList("coctel_06"))), new HashSet<Category>(Arrays.asList(coctel)), fechas, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // canoas
//        this.genProduct("Canoas", Canoas, false, new BigDecimal(32500), this.searchImage(listImages,
//                new ArrayList<>(Arrays.asList("coctel_07"))), new HashSet<Category>(Arrays.asList(coctel)), vendidos, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // tacitas de chocolate
        this.genProduct("Tacitas de Chocolate", TacitasdeChocolate, false, new BigDecimal(35500), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("tasitas_chocolate_01", "tasitas_chocolate_02"))), new HashSet<Category>(Arrays.asList(coctel)), fechas, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // DULCES

        // alfajores
        this.genProduct("Alfajores", AlfajoresdeManjaryChocolate, false, new BigDecimal(9800), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("alfajores_01", "alfajores_02"))), new HashSet<Category>(Arrays.asList(dulces)), vendidos, new HashSet<Tag>(Arrays.asList(sinGluten, sinLactosa, conStevia)));

        // kuchen de frutas
        this.genProduct("Kuchen de Frutas", KuchenFrutas, false, new BigDecimal(17900), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("kuchen_arandano_01", "kuchen_manzana_01"))), new HashSet<Category>(Arrays.asList(dulces)), populares, new HashSet<Tag>(Arrays.asList(sinLactosa, conStevia)));

        // tartaletas de frutas
        this.genProduct("Tartaletas de Frutas de Temporada", TartaletaFrutas, false, new BigDecimal(17900), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("tartaleta_01", "tartaleta_02", "tartaleta_03", "tartaleta_04", "tartaleta_05", "tartaleta_06"))),
                new HashSet<Category>(Arrays.asList(dulces)), destacados, new HashSet<Tag>(Arrays.asList(sinAzucar, sinLeche)));

        // pie de limon
        this.genProduct("Pie de Limon", PieLimon, false, new BigDecimal(17900), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("pie_limon_01"))), new HashSet<Category>(Arrays.asList(dulces)), populares, new HashSet<Tag>(Arrays.asList(sinLactosa, conStevia)));

        // mousse de frutas
//        this.genProduct("Mousse de Frutas", TortadeMousseFrutilla, false, new BigDecimal(17900), this.searchImage(listImages,
//                new ArrayList<>(Arrays.asList(""))), new HashSet<Category>(Arrays.asList(dulces)), populares, new HashSet<Tag>(Arrays.asList(sinLactosa, conStevia)));

        // brazo de reina
//        this.genProduct("Brazos de Reina", PastelesBrazosdeReina, false, new BigDecimal(35500), this.searchImage(listImages,
//                new ArrayList<>(Arrays.asList(""))), new HashSet<Category>(Arrays.asList(coctel)), vendidos, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // PANES

        // pan de molde semilla
        this.genProduct("Pan de Molde", PanMolde, false, new BigDecimal(3300), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("pan_molde_01", "pan_molde_02"))),
                new HashSet<Category>(Arrays.asList(pan)), vendidos, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // linaza
        this.genProduct("Pan de Molde de Linaza", PanLinaza, false, new BigDecimal(3800), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("pan_linaza_01"))), new HashSet<Category>(Arrays.asList(pan)), vendidos, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // almendra
        this.genProduct("Pan de Molde de Almendra", PanAlmendras, false, new BigDecimal(1800), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("pan_almendra_01"))), new HashSet<Category>(Arrays.asList(pan)), vendidos, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));


        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // MASAS

        // empanadas
        this.genProduct("Empanadas", Empanadas, false, new BigDecimal(2300), this.searchImage(listImages,
                new ArrayList<>(Arrays.asList("empanadas_01", "empanadas_02", "empanadas_03"))),
                new HashSet<Category>(Arrays.asList(masas)), vendidos, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // pan de pascuas
//        this.genProduct("Pan de Pascuas", PandePascuas, false, new BigDecimal(4900), this.searchImage(listImages,
//                new ArrayList<>(Arrays.asList(""))), new HashSet<Category>(Arrays.asList(masas)), populares, new HashSet<Tag>(Arrays.asList(sinGluten, sinAzucar, sinLeche)));

        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------

    }


    private List<Image> genImages(List<String> listImages){
        String rootDir = "assets/dulcelia-demo/products/";
        String imgExt = ".jpg";
        List<Image> listEntities = new ArrayList<>();
        for (String imgName : listImages){
            Image newImage = imageService.save(new Image(null, imgName, rootDir + imgName + imgExt, null, null, null));
            listEntities.add(newImage);
        }
        return listEntities;
    }

    private HashSet<Image> searchImage(List<Image> listImages, List<String> listNames){
        HashSet<Image> setImages = new HashSet<>();
        for (Image image : listImages){
            for (String name : listNames){
                if(image.getAlt().equals(name)){
                    setImages.add(image);
                }
            }
        }
        return setImages;
    }

    //TODO: update this method
    private void genProduct(String title, String desc, boolean isNew, BigDecimal price, HashSet<Image> images, HashSet<Category> categories, Collection collection, HashSet<Tag> tags){
        productService.save(new Product(null, null, title, desc, isNew, 0, price, false, null, null, null,
                true, null, null, null, images, categories, collection, tags,null));
    }

}
