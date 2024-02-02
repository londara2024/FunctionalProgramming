package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Mary", Gender.FEMALE),
                new Person("Peter", Gender.MALE),
                new Person("King", Gender.MALE),
                new Person("Kong", Gender.FEMALE),
                new Person("Sok", Gender.MALE)
        );

        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        boolean b = people.stream()
                .allMatch(person -> Gender.FEMALE.equals(person.gender));
        System.out.println(b);

        boolean b1 = people.stream()
                .anyMatch(person -> Gender.FEMALE.equals(person.gender));
        System.out.println(b1);

        boolean b2 = people.stream()
                .noneMatch(person -> Gender.ANOTHER.equals(person.gender));
        System.out.println(b2);

    }

    static class Person {
        private String name;
        private Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, ANOTHER;
    }
}
