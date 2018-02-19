package warburtonLambdas.chapter5;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Created by Log1c on 03.01.2016.
 */
public class RefOnMethods {
    public static String toUpperCase(String s) {
        return s.toUpperCase();
    }

    public static Integer sum(Integer i1, Integer i2) {
        return i1+i2;
    }

    //    public static Number con(Stream n1) {
//        return n1.stream();
//    }

    public static void main(String[] args) {
        List<String> collected = Stream.of("a", "b", "hello")
                .map(RefOnMethods::toUpperCase)
                .collect(toList());
        System.out.println(collected);

        int sum = Stream.of(1, 2, 3)
                .reduce(0, RefOnMethods::sum);
        System.out.println(sum);

        //don't made
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());
        System.out.println(together);
    }
}
