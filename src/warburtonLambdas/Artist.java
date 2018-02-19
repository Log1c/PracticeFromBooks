package warburtonLambdas;

import java.util.stream.Stream;


//Один человек или группа, исполняющая музыкальные произведения
public class Artist {
    private String name;// имя или название исполнителя (например, «The Beatles»);
    private Stream<Artist> members; //другие исполнители, входящие в состав группы (например, «Джон Леннон»), это поле может быть пустым;
    private String origin;//место, где возникла группа (например, «Ливерпуль»).

    public Artist(String name) {
        this.name = name;
    }

    public Artist(String name, Stream<Artist> members) {
        this.members = members;
        this.origin = origin;
    }

    public Artist(String name, Stream<Artist> members, String origin) {
        this.name = name;
        this.members = members;
        this.origin = origin;
    }

    public Artist(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }

    public void setMembers(Stream<Artist> members) {
        this.members = members;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public Stream<Artist> getMembers() {
        return members;
    }

    public String getOrigin() {
        return origin;
    }
}
