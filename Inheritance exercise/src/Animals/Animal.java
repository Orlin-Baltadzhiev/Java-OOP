package Animals;


public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    private void setGender(String gender) {
        validateParam(gender);
        this.gender = gender;
    }

    private void setAge(int age) {
        if(age<0){
            throw new IllegalStateException("Invalid input!");
        }
        this.age = age;
    }

    private void setName(String name) {
        validateParam(name);
        this.name = name;
    }

    private void validateParam(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalStateException("Invalid input!");
        }
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName(), this.name, this.age, this.gender,this.produceSound());
    }

    public String produceSound() {
        return "";
    }
}
