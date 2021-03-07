package Zoo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Puppy puppy = new Puppy();

        puppy.eat();
        puppy.bark();
        puppy.weep();

        List<Animal> animals = new ArrayList<>();

        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Puppy());

    }
}
