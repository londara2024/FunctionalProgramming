package finalsection;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        hello(null, "Motanse", value -> {
            System.out.println("no last name provided for " + value);
        });

        hello2("Jhon", null, () -> {
            System.out.println("no last name provided");
        });
    }

    static void hello (String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);

        if (firstName != null) {
            System.out.println(firstName);
        } else {
            callback.accept(firstName);
        }

        if(lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2 (String firstName, String lastName, Runnable callback) {

        if(lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}
