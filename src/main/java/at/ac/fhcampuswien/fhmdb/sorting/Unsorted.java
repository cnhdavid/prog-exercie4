package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.List;

public class Unsorted implements SortState {
    @Override
    public void sort(List<Movie> movies) {
        // No sorting
    }
}