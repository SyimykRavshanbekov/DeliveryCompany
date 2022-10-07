package Service;

import entities.Customer;
import entities.DeliveryCompany;
import entities.Load;
import entities.Order;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class DeliveryCompanyService {
    private ArrayList<DeliveryCompany> deliveryCompanies = new ArrayList<>();


    public void creatCustomer(Customer customer, String companyName){
        deliveryCompanies.stream().filter(x -> x.getDeliveryCompanyName().equalsIgnoreCase(companyName)).findFirst().ifPresent(x -> x.setCustomer(customer));
    }

    public void acceptOrder(Order order, String company, String customer){
        Optional<DeliveryCompany> optional = deliveryCompanies.stream().filter(x -> x.getDeliveryCompanyName().equalsIgnoreCase(company)).findFirst();

        if (optional.isPresent()){
            if (order.getLoad().getHeight()*order.getLoad().getWidth() < DeliveryCompany.maxCapacityPerSquareMeter){
                boolean resultFindCustomer = optional.flatMap(x -> x.getCustomer().stream().filter(a -> a.getName().equals(customer)).findFirst()).isPresent();
                if (resultFindCustomer) optional.flatMap(x -> x.getCustomer().stream().filter(a -> a.getName().equals(customer)).findFirst()).ifPresent(b -> b.addOrder(order));
                else System.out.println("Customer l;ksajfnot found");
            }else System.out.println("Company cannot accept this order!");
        } else System.out.println("Company not found!");
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

    public static void getCompanyProfit(DeliveryCompany deliveryCompany) {
        int totalProfit = 0;
        for (Customer customer : deliveryCompany.getCustomer()) {
            totalProfit += getTotalFee(customer);
        }
        System.out.println("Company total profit: "+totalProfit);
    }

    public ArrayList<DeliveryCompany> getCompanies(){
        return deliveryCompanies;
    }
}
