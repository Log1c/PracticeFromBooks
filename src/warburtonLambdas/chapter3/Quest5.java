package warburtonLambdas.chapter3;

import warburtonLambdas.Artist;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Quest5 {
    public static Comparator<Artist> a = comparing(artist -> artist.getName().length());

    public static void main(String[] args) {
//        toUpperCase();
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney",
                "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
        System.out.println(getLongestNmae(names));
    }

    private static void toUpperCase() {
        List<String> list = asList("a", "b", "hello").stream()
                .map(String::toUpperCase)
                .collect(toList());


//        assertEquals(asList("A", "B", "HELLO"), collected);
    }

    public static void count() {
        Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);

    }

    //97
    public static String getLongestNmae(Stream<String> stream) {
        return stream.reduce("", StringUtil::LongestName);
    }
}
