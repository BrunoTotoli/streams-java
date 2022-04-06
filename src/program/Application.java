package program;

import entities.Gender;
import entities.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
