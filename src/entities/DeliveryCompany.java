package entities;

import java.util.ArrayList;

public class DeliveryCompany {
    private String deliveryCompanyName;
    public static final int pricePerKilogram = 10;
    private ArrayList<Customer> customer = new ArrayList<>();
    public static final int maxCapacityPerSquareMeter = 20;

    public DeliveryCompany(String deliveryCompanyName) {
        this.deliveryCompanyName = deliveryCompanyName;
    }

    public String getDeliveryCompanyName() {
        return deliveryCompanyName;
    }

    public void setDeliveryCompanyName(String deliveryCompanyName) {
        this.deliveryCompanyName = deliveryCompanyName;
    }

    public int getPricePerKilogram() {
        return pricePerKilogram;
    }

    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer.add(customer);
    }

    public int getMaxCapacityPerSquareMeter() {
        return maxCapacityPerSquareMeter;
    }
}
