package io.task04;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.HashSet;

@SuppressWarnings("WeakerAccess")
@EqualsAndHashCode(exclude = "actors")
public class Movie implements Serializable {
    @Getter
    private final String title;
    @Getter
    private final int year;

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Getter
    private final HashSet<Actor> actors;

    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
        actors = new HashSet<>();
    }

    @Override
    public String toString() {
        return title + ", " + year + ", actors = " + actors;
    }
}
