package warburtonLambdas.chapter3;

import warburtonLambdas.Artist;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Quest2 {
    public static void main(String[] args) {
        Artist artist1 = new Artist("Jon Lennon");
        artist1.setOrigin("USA");
        Artist artist2 = new Artist("Naomi");
        artist2.setOrigin("Kentuki");
        List<Artist> artists = new ArrayList<>();
        Artist jon = new Artist("Jon");
        jon.setMembers(asList(artist1).stream());
        artists.add(jon);

        Artist artist3 = new Artist("Vanessa");
        artist3.setOrigin("Canada");
        artist3.setMembers(asList(artist1, artist2).stream());

        artists.add(artist3);
        long totalMembers = artists.stream()
                .mapToLong(n -> n.getMembers().count())
                .reduce(0l, (x, y) -> x + y);

//        int totalMembers = 0;
//        for (Artist artist : artists) {
//            Stream<Artist> members = artist.getMembers();
//            totalMembers += members.count();
//        }
        System.out.println(totalMembers);

    }
}
