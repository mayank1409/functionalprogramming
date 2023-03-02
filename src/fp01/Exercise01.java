package fp01;

import java.util.List;

public class Exercise01 {

    public static void main(String[] args) {

        // Print only odd numbers
        List<Integer> integerList = List.of(12, 9, 43, 21, 45, 65, 78, 46, 32);

        printOddNumbersInList(integerList);
        System.out.println();

        printSquareOfOddNumbersInList(integerList);
        System.out.println();

        List<String> courses = List.of("Functional Programming in Action", "Spring In Action", "Spring Boot in Action",
                "AWS in Action", "Microservices using Spring boot and Spring cloud");

        printAllCourses(courses);
        System.out.println();

        printAllCoursesContainingSpring(courses);
        System.out.println();

        printAllCoursesWithLengthGE20(courses);
        System.out.println();

        printAllCoursesLength(courses);
        System.out.println();
    }

    private static void printAllCoursesLength(List<String> courses) {
        courses.stream()
                .map(course ->  course + " => " + course.length())
                .forEach(System.out::println);
    }

    private static void printSquareOfOddNumbersInList(List<Integer> integerList) {
        integerList.stream()
                .filter(integer -> integer % 2 == 1)
                .map(integer -> integer*integer)
                .forEach(System.out::println);
    }

    private static void printAllCoursesWithLengthGE20(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() > 20)
                .forEach(System.out::println);
    }

    private static void printAllCoursesContainingSpring(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printAllCourses(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }

    private static void printOddNumbersInList(List<Integer> integerList) {
        integerList.stream()
                .filter(integer -> integer % 2 == 1)
                .forEach(System.out::println);
    }
}
