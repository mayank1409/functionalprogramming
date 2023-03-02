package fp02;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2 {
    public static void main(String[] args) {

        List<Integer> integerList = List.of(12, 12, 32, 23, 45, 32, 10, 5, 78, 5);
        printDistinctNumbersInListFunctional(integerList);
        System.out.println();

        printSortedNumbersInListFunctional(integerList);
        System.out.println();
        System.out.println();


        List<String> courses = List.of("Spring", "Spring Boot","Azure","Docker",
                "K8s","Helm", "AWS", "GCP", "PCF", "Microservices");

        sortCoursesInListFunctional(courses);
        System.out.println();
        System.out.println();


        sortedCoursesInReverseOrderInListFunctional(courses);
        System.out.println();
        System.out.println();

        sortedCoursesOnLengthInListFunctional(courses);
        System.out.println();
        System.out.println();

        // collect method demo

        List<Integer> squaredIntegerList = squareNumberInListAndReturnNewList(integerList);
        System.out.println(squaredIntegerList);

        List<Integer> evenIntegerList = evenNumberFromListAndReturnNewList(integerList);
        System.out.println(evenIntegerList);

        List<String> coursesWithLengths = courseWithLengthsFromList(courses);
        System.out.println(coursesWithLengths);
    }

    private static List<String> courseWithLengthsFromList(List<String> courses) {
        List<String> coursesWithLengths = courses.stream()
                .map(course -> course + " => " + course.length())
                .collect(Collectors.toList());
        return coursesWithLengths;
    }

    private static List<Integer> evenNumberFromListAndReturnNewList(List<Integer> integerList) {
        List<Integer> evenIntegerList = integerList.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());
        return evenIntegerList;
    }

    private static List<Integer> squareNumberInListAndReturnNewList(List<Integer> integerList) {
        return integerList.stream()
                .map(integer -> integer*integer)
                .collect(Collectors.toList());
    }

    private static void sortedCoursesOnLengthInListFunctional(List<String> courses) {
        courses.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(course -> System.out.print(course + ", "));
    }

    private static void sortedCoursesInReverseOrderInListFunctional(List<String> courses) {
        courses.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(course -> System.out.print(course + ", "));

    }

    private static void sortCoursesInListFunctional(List<String> courses) {
        courses.stream()
                .sorted()
                .forEach(course -> System.out.print(course + ", "));
    }

    private static void printSortedNumbersInListFunctional(List<Integer> integerList) {
        integerList.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void printDistinctNumbersInListFunctional(List<Integer> integerList) {
        integerList.stream()
                .distinct()
                .forEach(System.out::println);
    }


}
