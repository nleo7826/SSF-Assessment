package ssf.ssfassessment.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
public class Order {

    @NotNull(message = "Please select a pizza.")
    private String type;

    @NotNull(message = "Please select a size")
    private String size;

    @Size(min = 1, max = 10, message = "Quantity must be between 1 to 10.")
    private String quantity;


    public Order() {

    }
    
    public Order(String type, String size, String quantity) {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getSize() {
        return size;
    }


    public void setSize(String size) {
        this.size = size;
    }


    public String getQuantity() {
        return quantity;
    }


    public void setQuantity(String quantity) {
        this.quantity = quantity;
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