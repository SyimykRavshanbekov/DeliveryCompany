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
    
    
}
