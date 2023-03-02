package fp03;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class FPBehaviourParameterizationExercise01 {

    public static void main(String[] args) {

        List<Integer> integerList = List.of(12, 9, 32, 23, 45, 32, 10, 5, 78, 65);

        Function<Integer, Integer> squareMapperFunction = integer -> integer*integer;
        Function<Integer, Integer> cubeMapperFunction = integer -> integer*integer*integer;

        List<Integer> squaredIntegerList = mapAndCreateNewList(integerList, squareMapperFunction);
        System.out.println(squaredIntegerList);

        List<Integer> cubeIntegerList = mapAndCreateNewList(integerList, cubeMapperFunction);
        System.out.println(cubeIntegerList);

        Function<String, String> stringConcatFunction = s -> s + " " + s;
        String string = mapAndCreateNewString("Hello", stringConcatFunction);
        System.out.println(string);
    }

    private static String mapAndCreateNewString(String string, Function<String, String> function) {
       return function.apply(string);
    }

    public static List<Integer> mapAndCreateNewList(List<Integer> integerList,
                                                      Function<Integer, Integer> function) {
        return integerList.stream()
                .map(function)
                .collect(Collectors.toList());
    }
}
