package fp01;

import java.util.List;

public class Demo2 {
    public static void main(String[] args) {

        List<Integer> integerList = List.of(12, 9, 32, 23, 45, 32, 10, 5, 78, 65);

        // old way prior to java 8
        printEvenNumbersInListStructured(integerList);

        System.out.println();

        // Modern way post java 8
        integerList.stream()
                //  Filter even numbers
                .filter(integer -> integer % 2 == 0)
                .forEach(System.out::println);
    }

    private static void printEvenNumbersInListStructured(List<Integer> integerList) {
        for (Integer integer : integerList) {
            if (integer % 2 == 0) {
                System.out.println(integer);
            }
        }
    }
}
