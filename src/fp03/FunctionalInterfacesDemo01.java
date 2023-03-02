package fp03;

import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionalInterfacesDemo01 {

    public static void main(String[] args) {

        List<Integer> integerList = List.of(12, 9, 32, 23, 45, 32, 10, 5, 78, 65);
        List<Integer> evenIntegerSquaresList = extractSquareOfEvenNumberFromList(integerList);

        System.out.println(evenIntegerSquaresList);

        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;

        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer1, Integer integer2) {
                return integer1 + integer2;
            }
        };
        int sum = integerList.stream()
                .reduce(0, sumBinaryOperator2).intValue();
        System.out.println(sum);

        Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*integer;
            }
        };

        List<Integer> squaredIntegerList = integerList.stream()
                .map(squareFunction).collect(Collectors.toList());
        System.out.println(squaredIntegerList);

        Supplier<Integer> randomIntegerSupplier = () -> new Random().nextInt(10);
        System.out.println(randomIntegerSupplier.get());

        UnaryOperator<Integer> unaryOperator = x -> x+new Random().nextInt(10);
        System.out.println(unaryOperator.apply(10));

        BiPredicate<String, String> biPredicate1 = (s1, s2) -> s1.length() == s2.length();
        System.out.println(biPredicate1.test("Hello", "hello"));

        BiPredicate<Integer, String> biPredicate2 = (integer, s1) -> s1.length() == integer;
        System.out.println(biPredicate2.test(10, "Hello Hello"));

        BiFunction<Integer, String, String> biFunction = (integer, s1) -> s1.concat(integer.toString());
        System.out.println(biFunction.apply(7, "Hello 00"));

        BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println("Sum is " + (a+b));
        biConsumer.accept(10, 20);

        IntBinaryOperator intBinaryOperator = (x, y) -> x + y;
        System.out.println(intBinaryOperator.applyAsInt(10, 20));
    }

    private static List<Integer> extractSquareOfEvenNumberFromList(List<Integer> integerList) {
        List<Integer> evenIntegerSquaresList = integerList.stream()
                .filter(integer -> integer % 2 == 0)
                .map(integer -> integer * integer)
                .collect(Collectors.toList());
        return evenIntegerSquaresList;
    }

}
