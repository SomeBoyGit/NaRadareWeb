package ru.someboy.naradareweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.someboy.naradareweb.dao.ProductDAO;
import ru.someboy.naradareweb.model.Search;

/**
 * @author Slipets Artem
 */
@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductDAO productDAO;

    public ProductsController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping("/index")
    public String index(Model model) {
        //Получим всех людей из DAO и передадим на отображение в представление
        model.addAttribute("products", productDAO.index());
        return "products/index";
    }

    @GetMapping
    public String front(Model model) {
        model.addAttribute("search", new Search());
        return "products/front";
    }

    @PostMapping("/result")
    public void result(@ModelAttribute("search") Search searchText, Model model) {
        getSearchPage(model, searchText);
    }

    @GetMapping("/search")
    public void getSearchPage(Model model, Search searchText) {
        model.addAttribute("products", productDAO.searchInDB(searchText.getSearchText()));
    }

    @GetMapping("/test")
    public String test(Model model) {
        //Получим всех людей из DAO и передадим на отображение в представление
        model.addAttribute("products", productDAO.index());
        return "products/index";
    }

    @GetMapping("/{idProduct}")
    public String show(Model model, @PathVariable("idProduct") int idProduct) {
        //Получим одного человека по id из DAO и передадим на отображение в предаставление
        model.addAttribute("product", productDAO.show(idProduct));
        return "products/show";
    }
}