package com.mikethefloorguy.ordertracker.controllers;


import com.mikethefloorguy.ordertracker.data.OrderData;
import com.mikethefloorguy.ordertracker.models.Order;
import com.mikethefloorguy.ordertracker.models.OrderType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("orders")
public class OrderController {

    @GetMapping
    public String displayAllOrders(Model model){
        model.addAttribute("title", "All Orders");
        model.addAttribute("orders", OrderData.getAll());
        return "orders/index";
    }

    @GetMapping("create")
    public String displayCreateOrderForm(Model model) {
        model.addAttribute("title", "Create Order");
        model.addAttribute(new Order());
        model.addAttribute("types", OrderType.values());
        return "orders/create";
    }

    @PostMapping("create")
    public String processCreateOrderForm(@ModelAttribute @Valid Order newOrder,
                                         Errors errors, Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Order");
            return "orders/create";
        }

        OrderData.add(newOrder);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteOrderForm(Model model) {
        model.addAttribute("title", "Delete Orders");
        model.addAttribute("orders", OrderData.getAll());
        return "orders/delete";
    }

    @PostMapping("delete")
    public String processDeleteOrderForm(@RequestParam(required = false) int[] orderIds) {

        if(orderIds != null) {
            for (int id : orderIds) {
                OrderData.remove(id);
            }
        }
        return "redirect:";
    }
}
