package Service;

import entities.Customer;
import entities.DeliveryCompany;
import entities.Load;
import entities.Order;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class DeliveryCompanyService {
    private ArrayList<DeliveryCompany> deliveryCompanies;

    Scanner scannerS =  new Scanner(System.in);
    Scanner scannerN =  new Scanner(System.in);

    public void acceptOrder(Order order, String company, String customer){
        Optional<DeliveryCompany> optional = deliveryCompanies.stream().filter(x -> x.getDeliveryCompanyName().equals(company)).findFirst();

        if (order.getLoad().getHeight()*order.getLoad().getWidth() < DeliveryCompany.maxCapacityPerSquareMeter){
            optional.ifPresent(x -> x.getCustomer().stream().filter(a -> a.getName().equals(customer)).findFirst().ifPresent(b -> b.addOrder(order)));
        }
    }

    public void createDeliveryCompany(String nameOfDeliveryCompany) {
        DeliveryCompany deliveryCompany = new DeliveryCompany(nameOfDeliveryCompany);
        deliveryCompanies.add(deliveryCompany);
    }

    public static int getTotalFee(Customer customer) {
        int totalFee = 0;
        for( Order order: customer.getOrder()) {
            totalFee += order.getOrderFee();
        }
        return totalFee;
    }

    public static int getCompanyProfit(DeliveryCompany deliveryCompany) {
        int totalProfit = 0;
        for (Customer customer : deliveryCompany.getCustomer()) {
            totalProfit += getTotalFee(customer);
        }
        return totalProfit;
    }
}
