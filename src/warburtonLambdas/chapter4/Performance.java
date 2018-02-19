package warburtonLambdas.chapter4;

import warburtonLambdas.Artist;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 * Created by Log1c on 02.01.2016.
 */
public interface Performance {
    public String getName();
    public Stream<Artist> getMusicians();

    default Stream<Artist> getAllMusicians() {
            return getMusicians()
                    .flatMap(artist -> concat(Stream.of(artist), artist.getMembers()));
    }
}
