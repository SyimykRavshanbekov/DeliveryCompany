package entities;

public class Order {
    private int orderFree;
    private Load load;

    public Order(Load load) {
        this.orderFree = load.getWeight()*DeliveryCompany.pricePerKilogram;
        this.load = load;
    }

    public int getOrderFree() {
        return orderFree;
    }

    public void setOrderFree(int orderFree) {
        this.orderFree = orderFree;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad(Load load) {
        this.load = load;
    }
}
