package fp01;

import java.util.Arrays;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {

        // Old Way before java 8
        List<Integer> integerList = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        printAllNumbersInListStructured(integerList);

        System.out.println();

        // Modern way after java 8
        integerList.forEach(System.out::println);
    }

    private static void printAllNumbersInListStructured(List<Integer> integerList) {
        for (Integer integer : integerList) {
            System.out.println(integer);
        }
    }

}
