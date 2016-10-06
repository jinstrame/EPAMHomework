package io.task04;

import lombok.*;

import java.io.*;
import java.util.HashSet;

@SuppressWarnings("WeakerAccess")
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MovieCollection implements Serializable {
    private static String DEFAULT_PATH = "src\\main\\resources\\serializedMovies";

    @Getter
    private HashSet<Movie> movies;

    public void addMovie(Movie a){
        if (!movies.contains(a))
            movies.add(a);
    }

    public static MovieCollection getCollection(){
        MovieCollection movieCollection;
        Object readed;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DEFAULT_PATH))){
            movieCollection = (MovieCollection)inputStream.readObject();
        } catch (Exception e) {
            movieCollection = new MovieCollection(new HashSet<>());
        }

        return movieCollection;
    }

    public void serialize(){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DEFAULT_PATH))){
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
