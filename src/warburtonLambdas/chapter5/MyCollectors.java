package warburtonLambdas.chapter5;


import warburtonLambdas.Artist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.Comparator.comparing;

public class MyCollectors {

    //Найдите исполнителя с самым длинным именем. В решении воспользуйтесь коллектором и функцией высшего порядка
    //reduce, описанной в главе 3. Сравните обе реализации: какую проще писать, а какую – читать?
    private static Comparator<Artist> byNameLength = comparing(artist -> artist.getName().length());

    public static Artist byCollecting(List<Artist> artists) {
        return artists.stream()
                .collect(Collectors.maxBy(byNameLength))
                .orElseThrow(RuntimeException::new);
    }

    public static Artist byReduce(List<Artist> artists) {
        return artists.stream()
                .reduce((acc, artist) -> {
                    return (byNameLength.compare(acc, artist) >= 0) ? acc : artist;
                })
                .orElseThrow(RuntimeException::new);
    }

//    public Optional<Artist> biggestGroup(Stream<Artist> artists) {
//        Function<Artist,Long> getCount = artist -> artist.getMembers().count();
//        return artists.collect(maxBy(comparing(getCount)));
//    }

    //Пусть дан поток, элементы которого – слова. Посчитайте, сколько раз встречается каждое слово. При следующих ис-
    //ходных данных должен быть возвращен такой объект Map:[John  3, Paul  2, George  1]:
    //Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");
    public static Map<String, Long> countWords(Stream<String> names) {
        return names.collect(groupingBy(name -> name, counting()));
    }

    public static void main(String[] args) {
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("John Lennon"));
        artists.add(new Artist("Paul McCartney"));
        artists.add(new Artist("George Harrison"));
        artists.add(new Artist("Ringo Starr"));
        artists.add(new Artist("Pete Best"));
        artists.add(new Artist("Stuart Sutcliffe"));

        System.out.println(byCollecting(artists));

        System.out.println(countWords(Stream.of("John", "Paul", "George", "John", "Paul", "John")));
    }
}