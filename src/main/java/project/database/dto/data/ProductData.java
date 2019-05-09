package project.database.dto.data;

import project.database.dto.AbstractData;

public class ProductData extends AbstractData {

    private Long id;
    private String name;
    private double price;
    private int quantity;
    private String type = "data";

    public ProductData(){}

    public ProductData(String name,Double price,int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = 10L;
    }

    public ProductData(long id, String name, Double price, int quantity) {
        this(name,price,quantity);
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
