package fp02;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(12, 9, 32, 23, 45, 32, 10, 5, 78, 65);

        // Old Way before java 8
        sumOfNumbersStructured(integerList);

        // Modern Way after java 8
        sumOfNumbersFunctional(integerList);
    }

    private static void sumOfNumbersFunctional(List<Integer> integerList) {
        int sum = integerList.stream()
                 // .reduce(0, (a,b) -> a+b))
                .reduce(0, Integer::sum).intValue();
        System.out.println("Sum using functional = " + sum);
    }

    private static void sumOfNumbersStructured(List<Integer> integerList) {
        int sum = 0;
        for (Integer integer: integerList) {
            sum+=integer;
        }
        System.out.println("Sum using structured = " + sum);
    }
}
