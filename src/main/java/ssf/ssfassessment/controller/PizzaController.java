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
import ssf.ssfassessment.model.Order;


    @Controller
    @RequestMapping("/")
    public class PizzaController {
        
        
        @Autowired
        Order o;


        @PostMapping(path = "order", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        public String handlePizzaOrder(@RequestParam("pizza") String type,
                                        @RequestParam("size") String size,
                                        @RequestParam("quantity") String quantity) {
            o = new Order(type, size, quantity);
            return "redirect:/order";
        }

        @GetMapping(path="/order")
        public String showOrder(Model model) {
            model.addAttribute("order", o);
            System.out.print(">>> " + o.getType());
            System.out.print(">>> " + o.getSize());
            System.out.print(">>> " + o.getQuantity());
            return "order";
        }

        public String saveContact(@Valid Order order, BindingResult binding, Model model) {
            if (binding.hasErrors()) {
                return "index";
            }
            return "order";
        }
    }

    // private Boolean checkPizzaType(String pizzaType) {
        
    //     switch (pizzaType) {
    //         case bella:
    //             return true;
    //         case margherita:
    //             return true;
    //         case marinara:
    //             return true;
    //         case spianatacalabrese:
    //             return true;
    //         case trioformaggio:
    //             return true;
    //         default:
    //             return false;
    //     }
    // }