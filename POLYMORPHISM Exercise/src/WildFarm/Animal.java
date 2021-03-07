package WildFarm;

import java.text.DecimalFormat;

public abstract class Animal implements Eat,ProduceSound {
    private String name;
    private String type;
    private Double weight;
    private Integer foodEaten;

    public Animal(String name, String type, Double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.foodEaten = 0;
    }

    @Override
    public void eat (Food food){
        this.foodEaten+=food.getQuantity();
    }

    public String getType() {
        return type;
    }
    protected void incremenetFood(int quantity){
        this.foodEaten +=quantity;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %d]",
                this.name,
                new DecimalFormat("##.##").format(this.weight),
                this.foodEaten
                );
    }
}
