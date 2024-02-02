package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambda {
    public static void main(String[] args) {
//        Function<String, String> upperCaseName = name -> name.toUpperCase();
        Function<String, String> upperCaseName = String::toUpperCase;
        System.out.println(upperCaseName.apply("upper"));

        BiFunction<String, Integer, String> upperCase = (name, age) -> {
            if (name.isBlank()) throw new IllegalArgumentException("name is blank");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCase.apply("view", 12));
    }
}
