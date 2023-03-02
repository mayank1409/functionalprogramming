package fp02;

import java.util.List;

public class Exercise01 {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(12, 9, 32, 23, 45, 32, 10, 5, 78, 65);

        sumOfSquaresOfNumbersInListFunctional(integerList);
        sumOfOddNumbersInListFunctional(integerList);
    }

    private static void sumOfOddNumbersInListFunctional(List<Integer> integerList) {
        int sumOfOddNumbers = integerList.stream()
                .filter(integer -> integer % 2 == 1)
                .reduce(0, Integer::sum).intValue();
        System.out.println("sum of odd numbers = " + sumOfOddNumbers);
    }

    private static void sumOfSquaresOfNumbersInListFunctional(List<Integer> integerList) {
        int sumOfSquares = integerList.stream()
                .map(integer -> integer * integer)
                .reduce(0, Integer::sum).intValue();
        System.out.println("sum of squares = " + sumOfSquares);
    }
}
