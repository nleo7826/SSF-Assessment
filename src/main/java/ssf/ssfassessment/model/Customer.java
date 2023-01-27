package ssf.ssfassessment.model;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Name cannot be empty")
    @Size(min = 3, message = "Name must be at least 3 characters.")
    private String name;

    @NotNull(message = "Address cannot be empty.")
    private String address = null;

    @Size(min = 8, message = "Phone number must be at least 8 digits.")
    private String phoneno = null;

    private Boolean rush = false;
    private String comments = null;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneno() {
        return phoneno;
    }
    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
    public Boolean getRush() {
        return rush;
    }
    public void setRush(Boolean rush) {
        this.rush = rush;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
}
