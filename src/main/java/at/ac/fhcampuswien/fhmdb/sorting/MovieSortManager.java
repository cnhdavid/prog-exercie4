package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.List;

public class MovieSortManager {
    public SortState currentState;

    // Constructor initializes the default state to Unsorted
    public MovieSortManager() {
        this.currentState = new Unsorted();  // Default state
    }

    // Method to set the current sort state
    public void setSortState(SortState state) {
        this.currentState = state;
    }

    // Method to sort movies based on the current state
    public void sortMovies(List<Movie> movies) {
        currentState.sort(movies);
    }
}