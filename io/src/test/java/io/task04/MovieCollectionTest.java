package io.task04;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MovieCollectionTest {
    @Test
    public void serializeTest() throws Exception {
        MovieCollection collection =  MovieCollection.getCollection();

        Actor harrisonFord = new Actor("Harison", "Ford", 1942);
        Actor michaelJFox = new Actor("Michael J.", "Fox", 1961);
        Actor anthonyHopkins = new Actor("Anthony", "Hopkins", 1937);

        Movie starWars = new Movie("Star Wars: Episode IV - A New Hope", 1977);
        starWars.getActors().add(harrisonFord);

        Movie backToTheFuture = new Movie("Back to the Future", 1985);
        backToTheFuture.getActors().add(michaelJFox);

        Movie silencOfTheLambs = new Movie("The Silence of the Lambs", 1991);
        silencOfTheLambs.getActors().add(anthonyHopkins);

        collection.addMovie(starWars);
        collection.addMovie(backToTheFuture);

        collection.serialize();
        MovieCollection loadedCollection = MovieCollection.getCollection();

        collection.addMovie(silencOfTheLambs);
        loadedCollection.addMovie(silencOfTheLambs);

        assertTrue(collection.equals(loadedCollection));
        for (Movie m : collection.getMovies()){
            System.out.println(m);
        }
    }
}