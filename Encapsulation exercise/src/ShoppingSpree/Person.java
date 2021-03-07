package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name.trim();
    }


    private void setMoney(double money) {
        Validator.validateMoney(money);
        this.money = money;

    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            throw new IllegalStateException(this.name + " can't afford " + product.getName());
        }
        this.products.add(product);
        this.money -= product.getCost();

    }

    @Override
    public String toString() {
        String postfix = this.products.size() > 0 ? this.products
                .stream()
                .map(Product::getName)
                .collect(Collectors.joining(", ")) : "Nothing bought";

        return this.name + " - " + postfix;
    }
}
