package warburtonLambdas.chapter3;

import warburtonLambdas.Album;
import warburtonLambdas.Artist;
import warburtonLambdas.Track;

import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Quest1 {
    public static void main(String[] args) {
        test1();
    }

    public Optional<Integer> addUp(Stream<Integer> numbers) {
        return numbers.reduce((x, y) -> (x + y));
    }

    //Функцию, которая получает исполнителя и возвращает список строк, содержащих имена и место происхождения.
    public Stream<String> getNamesAndOrigin(Artist artist) {
        return artist.getMembers().map(n -> "" + n.getName() + "; " + n.getOrigin());
    }

    //получает альбомы и возвращает список альбомов, содержащих не более трех произведений.
    public Stream<Album> getAlbumsLow3(Stream<Album> albums) {
        return albums.filter(n -> n.getTracks().count() <= 3);
    }

    private static void test3() {
        Quest1 quest1 = new Quest1();
        Album album = new Album("Enigma");
        album.setTracks(asList(new Track("1"), new Track("2"), new Track("3"), new Track("4")).stream());

        Album album1 = new Album("Scooter");
        album1.setTracks(Stream.of(new Track("5")));

        Stream<Album> result = quest1.getAlbumsLow3(asList(album, album1).stream());
        result.forEach(System.out::println);
    }

    private static void test1() {
        Quest1 quest1 = new Quest1();
        System.out.println(quest1.addUp(asList(1, 2, 4).stream()).get());
    }

    private static void test2() {
        Artist artist1 = new Artist("Jon Lennon");
        artist1.setOrigin("USA");
        Artist artist2 = new Artist("Naomi");
        artist2.setOrigin("Kentuki");
        Artist artist3 = new Artist("Vanessa");
        artist3.setOrigin("Canada");
        artist3.setMembers(asList(artist1, artist2).stream());
        Stream<String> result = new Quest1().getNamesAndOrigin(artist3);
        result.forEach(System.out::println);
    }
}

