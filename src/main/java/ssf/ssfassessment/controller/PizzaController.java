package ssf.ssfassessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import ssf.ssfassessment.model.Customer;
import ssf.ssfassessment.model.Order;


    @Controller
    @RequestMapping("/")
    public class PizzaController {
        
        @Autowired
        Order o;

        @PostMapping(path = "order", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        public String handlePizzaOrder(@RequestParam("pizza") String type,
                                        @RequestParam("size") String size,
                                        @RequestParam("quantity") String quantity, Model model) {
                                    
            o = new Order(type, size, quantity);
            Double orderCost = o.calculate();
            o.setOrderCost(orderCost);
            System.out.println(">>> " + o.getOrderCost());
            model.addAttribute("order", o);
            return "redirect:/order";
        }
                       

        @GetMapping(path="/order")
        public String showOrder(@Valid Order order, BindingResult binding, Model model) {
            // binding.hasErrors always true
            // if (binding.hasErrors()) {
            //     return "redirect:/";
            // }

            return "order";
        }
        
        @GetMapping(path="/confirm")
        public String saveCustomer(@Valid Customer cust, BindingResult binding, Model model) {
            if (binding.hasErrors()) {
                return "index";
            }
            // System.out.println(">>> " + o.getType());
            // System.out.println(">>> " + o.getSize());
            // System.out.println(">>> " + o.getQuantity());
            // String orderCost = o.calculate();
            // o.setOrderCost(orderCost);
            // model.addAttribute("custOrder", o);
            return "confirm";
        }
    }