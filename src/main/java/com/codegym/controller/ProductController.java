package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Product> productList = productService.findAll();
        modelAndView.addObject("products", productList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Product product, RedirectAttributes redirect) {
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        redirect.addFlashAttribute("success", "Successful new creation");
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(Product product,RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Successful edit");
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView remove(Product product,RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Successful delete");
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }


}
