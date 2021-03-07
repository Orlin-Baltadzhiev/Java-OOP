package BorderControl;

public class Citizen implements  Identifiable  {
    private String id;
    private int age;
    private String name;



    public Citizen(String name, int age, String id) {
        this.id = id;
        this.age = age;
        this.name = name;

    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
