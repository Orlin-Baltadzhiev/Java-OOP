package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        while (!input.equals("HARVEST")) {

            Field[] fields = RichSoilLand.class.getDeclaredFields();


            for (Field field : fields) {
                int modifier = field.getModifiers();
				String modifierAsString = Modifier.toString(modifier);
				if (modifierAsString.equals(input) || input.equals("all")) {
                    System.out.println(String.format("%s %s %s ",modifierAsString , field.getType().getSimpleName(),
                            field.getName()));
                }

            }

            input = scanner.nextLine();
        }
    }
}
