package warburtonLambdas.chapter4;

import warburtonLambdas.Artist;

import java.util.List;
import java.util.Optional;

/**
 * Created by Log1c on 02.01.2016.
 */
public class Artists {
    private List<Artist> artists;

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }

    public Optional<Artist> getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            return Optional.empty();
        }

        return Optional.of(artists.get(index));
    }

    public String getArtistName(int index) {
        Optional<Artist> artist = getArtist(index);
        return artist.map(Artist::getName)
                .orElse("unknown");
    }
}
