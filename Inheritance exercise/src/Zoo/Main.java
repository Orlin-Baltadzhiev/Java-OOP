package Zoo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();

        animalList.add(new Snake("Python"));
        animalList.add(new Lizard("Gandalf"));
        animalList.add(new Gorilla("King Kong"));
        animalList.add(new Bear("Gonna bear"));

        for (Animal animal : animalList) {
            animal.feedAnima();
        }

    }
}
