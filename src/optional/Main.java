package optional;

import java.util.Objects;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//        Object s = Optional.ofNullable(null)
//                .orElseGet(() -> "default value");
//
//        Object s1 = Optional.ofNullable(null)
//                .orElseThrow(() -> new IllegalStateException("Exception"));

//        Optional.ofNullable("default value")
//                .ifPresent(value -> {
//                    System.out.println(value);
//                });

        Optional.of("default value")
                .ifPresent(System.out::println);

        Optional.ofNullable("sok@gamail.com")
                .ifPresent(email -> System.out.println("Sending email to " + email));

        Optional.ofNullable(null)
                .ifPresent(email -> System.out.println("Sending to " + email));

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending to " + email), () -> {
                    System.out.println("Cannot send email!!");
                });

    }
}
