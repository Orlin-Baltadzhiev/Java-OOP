package WildFarm;

public class Mousse extends Mammal {
    public Mousse(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public String toString() {
        return "Mouse" + super.toString();
    }
}
