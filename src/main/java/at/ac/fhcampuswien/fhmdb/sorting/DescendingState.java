package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.Comparator;
import java.util.List;

public class DescendingState implements SortState {
    // Implement the sort method from the SortState interface
    @Override
    public void sort(List<Movie> movies) {
        // Sort the list of movies by their title in descending order
        movies.sort(Comparator.comparing(Movie::getTitle).reversed());
    }
}