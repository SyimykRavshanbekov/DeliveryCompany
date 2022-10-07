package entities;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Order> orders = new ArrayList<>();



    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Order> getOrder() {
        return orders;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

}
