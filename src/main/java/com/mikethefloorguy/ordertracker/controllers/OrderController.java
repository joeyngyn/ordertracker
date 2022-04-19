package com.mikethefloorguy.ordertracker.controllers;


import com.mikethefloorguy.ordertracker.data.OrderCategoryRepository;
import com.mikethefloorguy.ordertracker.data.OrderRepository;
import com.mikethefloorguy.ordertracker.data.TagRepository;
import com.mikethefloorguy.ordertracker.models.Order;
import com.mikethefloorguy.ordertracker.models.OrderCategory;
import com.mikethefloorguy.ordertracker.models.Tag;
import com.mikethefloorguy.ordertracker.models.dto.OrderTagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderCategoryRepository orderCategoryRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public String displayAllOrders(@RequestParam(required = false) Integer categoryId, Model model){
        if (categoryId == null) {
            model.addAttribute("title", "All Orders");
            model.addAttribute("orders", orderRepository.findAll());
        } else {
            Optional<OrderCategory> result = orderCategoryRepository.findById(categoryId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Category Id: " + categoryId);
            } else {
                OrderCategory category = result.get();
                model.addAttribute("title", "Orders in category: " + category.getName());
                model.addAttribute("orders", category.getOrders());
            }
        }
        return "orders/index";
    }

    @GetMapping("create")
    public String displayCreateOrderForm(Model model) {
        model.addAttribute("title", "Create Order");
        model.addAttribute(new Order());
        model.addAttribute("types", orderCategoryRepository.findAll());
        return "orders/create";
    }

    @PostMapping("create")
    public String processCreateOrderForm(@ModelAttribute @Valid Order newOrder,
                                         Errors errors, Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Order");
            return "orders/create";
        }

        orderRepository.save(newOrder);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteOrderForm(Model model) {
        model.addAttribute("title", "Delete Orders");
        model.addAttribute("orders", orderRepository.findAll());
        return "orders/delete";
    }

    @PostMapping("delete")
    public String processDeleteOrderForm(@RequestParam(required = false) int[] orderIds) {

        if(orderIds != null) {
            for (int id : orderIds) {
                orderRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("detail")
    public String displayOrderDetails(@RequestParam Integer eventId, Model model) {
        Optional<Order> result = orderRepository.findById(eventId);

        if(result.isEmpty()) {
            model.addAttribute("title", "Invalid Event ID: " + eventId);
        } else {
            Order order = result.get();
            model.addAttribute("title", order.getName() + "Details");
            model.addAttribute("event", order);
            model.addAttribute("tags", order.getTags());
        }
        return "events/detail";
    }

    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer eventId, Model model){
        Optional<Order> result = orderRepository.findById(eventId);
        Order order = result.get();
        model.addAttribute("title", "Add Tag to: " + order.getName());
        model.addAttribute("tags", tagRepository.findAll());
        OrderTagDTO orderTag = new OrderTagDTO();
        orderTag.setOrder(order);
        model.addAttribute("orderTag", orderTag);
        return "orders/add-tag.html";
    }

    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid OrderTagDTO orderTag,
                                    Errors errors,
                                    Model model){
        if (!errors.hasErrors()) {
            Order order = orderTag.getOrder();
            Tag tag = orderTag.getTag();
            if(!order.getTags().contains(tag)) {
                order.addTag(tag);
                orderRepository.save(order);
            }
            return "redirect:detail?orderId=" + order.getId();
        }
        return "redirect:add-tag";
    }
}
