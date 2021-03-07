package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        BlackBoxInt blackBoxInt;
        try {
            Constructor<?> ctor = BlackBoxInt.class.getDeclaredConstructor(int.class);
            ctor.setAccessible(true);
           blackBoxInt = (BlackBoxInt) ctor.newInstance(0);


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        Map<String, Method> methodByName = Arrays.stream(blackBoxInt.getClass().getDeclaredMethods())
                .peek(m -> m.setAccessible(true))
                .collect(Collectors.toMap(Method::getName, method -> method));

        while (!input.equals("END")) {

            String[] tokens = input.split("_");

            String command = tokens[0];
            int param = Integer.parseInt(tokens[1]);

            Method[] methods = blackBoxInt.getClass().getDeclaredMethods();
            Method method = methodByName.get(command);

            method.invoke(blackBoxInt, param);

            Field innerValues = BlackBoxInt.class.getDeclaredField("innerValue");

            innerValues.setAccessible(true);

            int value =(int) innerValues.get(blackBoxInt);

            System.out.println(value);
            input = scanner.nextLine();
        }
    }
}
