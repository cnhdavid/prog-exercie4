package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.List;

public class MovieSortManager {
    public SortState currentState;

    public MovieSortManager() {
        this.currentState = new Unsorted();  // Default state
    }

    public void setSortState(SortState state) {
        this.currentState = state;
    }

    public void sortMovies(List<Movie> movies) {
        currentState.sort(movies);
    }
}