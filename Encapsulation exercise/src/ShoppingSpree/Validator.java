package ShoppingSpree;

public class Validator {


    public static void validateName(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException(("Name cannot be empty"));
        }

    }

    public static void validateMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

    }
}

