package ru.jetforce;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {

    private List<Cheese> cheeses = new ArrayList<>();
    private Address billingAddress = new Address();
    public List<Cheese> getCheeses() {
        return cheeses;
    }
    public void setCheeses(List<Cheese> other) {
        cheeses = other;
    }
    public Address getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(Address other) {
        billingAddress = other;
    }

        public double getTotal() {
            double total = 0;
            for(Cheese cheese : cheeses) {
                total += cheese.getPrice();
            }
            return total;
        }

}