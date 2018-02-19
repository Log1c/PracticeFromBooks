package warburtonLambdas;

import java.util.stream.Stream;

/**
 * https://github.com/RichardWarburton/java-8-lambdas-exercises.
 */

//собрание нескольких музыкальных произведений в одном издании
public class Album {
    private String name;
    private Stream<Track> tracks;
    private Stream<Artist> musician;

    public Album(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Stream<Track> getTracks() {
        return tracks;
    }

    public Stream<Artist> getMusicians() {
        return musician;
    }

    public void setTracks(Stream<Track> tracks) {
        this.tracks = tracks;
    }

    public void setMusician(Stream<Artist> musician) {
        this.musician = musician;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                '}';
    }
}
