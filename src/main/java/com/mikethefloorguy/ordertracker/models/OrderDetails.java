package com.mikethefloorguy.ordertracker.models;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class OrderDetails extends AbstractEntity {

    @Size(max = 50, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank (message = "Order number must be entered.")
    private String orderNumber;

    @NotBlank(message = "Pricing must be included!")
    private String orderPrice;

    @NotBlank(message = "Please input customer address.")
    private String orderAddress;

    public OrderDetails(String description, String contactEmail, String orderNumber, String orderPrice, String orderAddress) {
        this.description = description;
        this.contactEmail = contactEmail;
        this.orderNumber = orderNumber;
        this.orderPrice = orderPrice;
        this.orderAddress = orderAddress;
    }

    public OrderDetails() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    @Override
    public boolean isMatchingPassword(String password) {
        return false;
    }
}
