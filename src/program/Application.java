package program;

import entities.Gender;
import entities.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        List<Person> peoples = getPerson();

        //Imperative approach
//        List<Person> females = new ArrayList<>();
//        for (Person p : peoples) {
//            if (p.getGender().equals(Gender.FEMALE)) {
//                females.add(p);
//            }
//        }
//
//        females.forEach(System.out::println);

        //Filter
        List<Person> females = peoples.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
//        females.forEach(System.out::println);
        //Sort
        List<Person> sortedByAge = peoples.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender))
                .collect(Collectors.toList());
//        sortedByAge.forEach(System.out::println);
        //All Match
        boolean allMatch = peoples.stream()
                .allMatch(person -> person.getAge() > 5);
        System.out.println(allMatch);
        //Any match
        boolean anyMatch = peoples.stream()
                .anyMatch(person -> person.getAge() > 121);
        System.out.println(anyMatch);
        //None match
        boolean noneMatch = peoples.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));
        System.out.println(noneMatch);
        // Max
        peoples.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        // Min
        peoples.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        // Group
        Map<Gender, List<Person>> mapGender = peoples.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        mapGender.forEach((gender, people) -> {
            System.out.println(gender);
            people.forEach(System.out::println);
        });
        Optional<String> oldFemale = peoples.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .min(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldFemale.ifPresent(System.out::println);
    }


    private static List<Person> getPerson() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}
