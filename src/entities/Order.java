package entities;

public class Order {
    private int orderFee;
    private Load load;

    public Order(Load load) {
        this.orderFee = load.getWeight() * DeliveryCompany.pricePerKilogram;
        this.load = load;
    }

    public int getOrderFee() {
        return orderFee;
    }

    public void setOrderFee(int orderFree) {
        this.orderFee = orderFree;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad(Load load) {
        this.load = load;
    }
}
