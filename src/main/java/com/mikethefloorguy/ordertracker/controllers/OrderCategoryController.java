package com.mikethefloorguy.ordertracker.controllers;

import com.mikethefloorguy.ordertracker.data.OrderCategoryRepository;
import com.mikethefloorguy.ordertracker.models.OrderCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("orderCategories")
public class OrderCategoryController {

    @Autowired
    private OrderCategoryRepository orderCategoryRepository;

    @GetMapping
    public String displayAllOrders(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("orderCategories", orderCategoryRepository.findAll());
        return "orderCategories/index";
    }

    @GetMapping("create")
    public String renderCreateOrderCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute(new OrderCategory());
        return "orderCategories/create";
    }

    @PostMapping("create")
    public String processCreateOrderCategoryForm(@ModelAttribute @Valid OrderCategory newOrderCategory,
                                                 Errors errors,
                                                 Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Category");
            return "orderCategories/create";
        }
        orderCategoryRepository.save(newOrderCategory);

        return "redirect:";
    }
}
