package fp03;

import java.util.List;
import java.util.function.Predicate;

public class FPBehaviourParameterizationDemo01 {
    
    public static void main(String[] args) {

        List<Integer> integerList = List.of(12, 9, 32, 23, 45, 32, 10, 5, 78, 65);

        Predicate<Integer> evenPredicate = integer -> integer%2 == 0;
        Predicate<Integer> oddPredicate = integer -> integer%2 == 1;

        filterAndPrint(integerList, evenPredicate);

        System.out.println();

        filterAndPrint(integerList, oddPredicate);

        System.out.println();

        filterAndPrint(integerList, integer -> integer%3==0);

    }

    private static void filterAndPrint(List<Integer> integerList, Predicate<Integer> predicate) {
        integerList.stream()
                .filter(predicate)
                .forEach(integer -> System.out.print(integer + " "));
    }

}
