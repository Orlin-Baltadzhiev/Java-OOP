import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Stream;
@SuppressWarnings("uchecked")
public class Main {
    public static void main(String[] args) {




        Class clazz = Reflection.class;

        Field[] declaredFields = Arrays.stream(clazz.getDeclaredFields()).sorted(Comparator.comparing(Field::getName)).toArray(Field[]::new);

        for (Field field : declaredFields) {
            Annotation[] declaredAnnotation = field.getDeclaredAnnotations();
            }
        }

    }


