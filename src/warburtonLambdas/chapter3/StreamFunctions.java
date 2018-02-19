package warburtonLambdas.chapter3;

import warburtonLambdas.Album;
import warburtonLambdas.Artist;
import warburtonLambdas.Track;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamFunctions {

    //    Функцию, которая получает исполнителя и возвращает список строк, содержащих имена и место происхождения.
    public static List<String> getNamesAndOrigins(List<Artist> artists) {
        return artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getOrigin()))
                .collect(toList());
    }

    //    Функцию, которая получает исполнителя и возвращает список строк, содержащих имена и место происхождения.
    public static List<String> getNamesAndOriginsMy(List<Artist> artists) {
        List<String> artistsName = artists.stream()
                .map(artist -> artist.getName())
                .collect(toList());

        List<String> artistsOrigins = artists.stream()
                .map(artist -> artist.getOrigin())
                .collect(toList());

        List<String> together = Stream.of(artistsName, artistsOrigins)
                .flatMap(string -> string.stream())
                .collect(toList());

        return together;
    }

    //Функцию, которая получает альбомы и возвращает список альбомов, содержащих не более трех произведений.
    public static Set<Album> get3track(Set<Album> albums) {
        return albums.stream()
                .filter(album -> album.getTracks().count()<=3)
                .collect(toSet());
    }

    public static void main(String[] args) {

        //Функцию сложения чисел, то есть int addUp(Stream<Integer> numbers).
        int sum = Stream.of(1, 3, 5)
                .reduce(0, (acc, element) -> acc + element);
        System.out.println(sum);

        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Edd", "Minesota"));
        artists.add(new Artist("Vik", "NY"));
        artists.add(new Artist("Sonya", "Bangkok"));
        System.out.println(getNamesAndOriginsMy(artists));

        Set<Album> albums = new HashSet<>();

        Set<Track> tracks1 = new HashSet<>();
        tracks1.add(new Track("Safe me"));
        tracks1.add(new Track("Bring me to life"));
        tracks1.add(new Track("Satisfaction"));
        tracks1.add(new Track("Sea"));
        Album sophyLoren = new Album("Sophy Loren");
        sophyLoren.setTracks(tracks1.stream());
        albums.add(sophyLoren);

        Set<Track> tracks2 = new HashSet<>();
        tracks2.add(new Track("Runkeeper"));
        tracks2.add(new Track("Breathe"));
        Album prodigy = new Album("Prodigy");
        prodigy.setTracks(tracks2.stream());
        albums.add(prodigy);

//        new Album("Prodigy", tracks2, null).getTracks();
        Set<Album> filteredAlbums = get3track(albums);
        System.out.println(filteredAlbums.size());
        for (Album album : filteredAlbums) {
            System.out.println(album);
        }

    }


}