package ssf.ssfassessment.model;

import java.util.Random;

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

    private String id;
    private Double orderCost;

    public Order() {
        this.id = generateId(8);
    }
    
    public Order(String type, String size, String quantity) {
        this.id = generateId(8);
        this.type = type;
        this.size = size;
        this.quantity = quantity;
    }

    public Order(String id, String type, String size, String quantity) {
        this.id = generateId(8);
        this.type = type;
        this.size = size;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Double orderCost) {
        this.orderCost = orderCost;
    }

    private synchronized String generateId(int numChars) {
        Random r = new Random();
        StringBuilder strBuilder = new StringBuilder();
        while (strBuilder.length() < numChars) {
            strBuilder.append(Integer.toHexString(r.nextInt()));
        }
        return strBuilder.toString().substring(0, numChars);
    }

    public Double calculate() {
        
        Double basePrice;
        Double sizeMultiplier;
        String type = this.getType();
        String size = this.getSize();

        if(type.equals("bella")){
            basePrice = 30.0;
        }else if(type.equals("marinara")){
            basePrice = 30.0;
        }else if(type.equals("magherita")){
            basePrice = 22.0;
        }else if(type.equals("trio formaggio")){
            basePrice = 25.0;
        }else{
            basePrice = 0.0;
        }

        if(size.equals("small")){
            sizeMultiplier = 1.0;
        }else if(size.equals("medium")){
            sizeMultiplier = 1.2;
        }else if(size.equals("large")){
            sizeMultiplier = 1.5;
        }else{
            sizeMultiplier = 1.0;
        }

        Double orderCost = basePrice * sizeMultiplier * Integer.parseInt(quantity);

        return orderCost;
    }
    
}