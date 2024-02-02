package Imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Mary", Gender.FEMALE),
                new Person("Peter", Gender.MALE),
                new Person("John", Gender.MALE),
                new Person("Mary", Gender.FEMALE),
                new Person("Peter", Gender.MALE)
        );

        // imperative approach
        System.out.println("imperative approach");
        List<Person> female = new ArrayList<>();

        for (Person person : people) {
            if (Gender.FEMALE.equals(person.gender)) {
                female.add(person);
            }
        }

        for(Person f : female) {
            System.out.println(f);
        }

        // Declarative approach
        System.out.println("Declarative approach");
        people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);


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
        MALE, FEMALE;
    }

}