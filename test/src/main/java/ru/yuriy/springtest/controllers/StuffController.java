package ru.yuriy.springtest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.yuriy.springtest.dao.PersonDAO;
import ru.yuriy.springtest.dao.ProductDAO;
import ru.yuriy.springtest.models.Person;
import ru.yuriy.springtest.models.Product;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class StuffController {

    private ProductDAO productDAO;

    @Autowired
    public StuffController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping()
    public String mainpage(@ModelAttribute("product") Product product) {
        return "stuff/startpage";
    }

    @GetMapping("/stuff")
    public String index(Model model) {
        // get all people from DAO and display them on view
        model.addAttribute("stuff", productDAO.index());
        return "stuff/index";
    }

    @GetMapping("/stuff/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        // get one person via id from DAO and display him on view
        model.addAttribute("product", productDAO.show(id));
        return "stuff/show";
    }

    @GetMapping("/stuff/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "stuff/new";
    }

    @PostMapping
    public String create(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "stuff/new";
        }
        productDAO.save(product);
        return "redirect:/";
    }

    @GetMapping("/stuff/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("product", productDAO.show(id));
        return "stuff/edit";
    }

    @PatchMapping("/stuff/{id}")
    public String update(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if(bindingResult.hasErrors()) {
            return "stuff/edit";
        }
        productDAO.update(id, product);
        return "redirect:/";
    }

    @DeleteMapping("/stuff/{id}")
    public String delete(@PathVariable("id") int id) {
        productDAO.delete(id);
        return "redirect:/";
    }

    @PostMapping("/stuff/search")
    public String search(@ModelAttribute("product") Product product, Model model) {
        // get one person via id from DAO and display him on view
        if(productDAO.show(product.getId()) == null) {
            return "stuff/notfound";
        }

        model.addAttribute("product", productDAO.show(product.getId()));
        return "stuff/show";
    }
}
