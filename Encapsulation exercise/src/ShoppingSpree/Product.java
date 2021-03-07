package ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
       Validator.validateName(name);
        this.name = name.trim();
    }

    private void setCost(double cost) {
       Validator.validateMoney(cost);
       this.cost=cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
