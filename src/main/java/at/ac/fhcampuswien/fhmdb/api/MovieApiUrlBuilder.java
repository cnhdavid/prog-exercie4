package at.ac.fhcampuswien.fhmdb.api;

import at.ac.fhcampuswien.fhmdb.models.Genre;

public class MovieApiUrlBuilder {
    // Base URL for the movie API
    private static final String BASE_URL = "https://prog2.fh-campuswien.ac.at/movies";
    private static final String DELIMITER = "&"; // Delimiter for URL parameters

    private String query;
    private Genre genre;
    private String releaseYear;
    private String ratingFrom;

    // Set the query parameter and log the URL
    public MovieApiUrlBuilder setQuery(String query) {
        this.query = query;
        logUrl();
        return this;
    }

    // Set the genre parameter and log the URL
    public MovieApiUrlBuilder setGenre(Genre genre) {
        this.genre = genre;
        logUrl();
        return this;
    }

    // Set the release year parameter and log the URL
    public MovieApiUrlBuilder setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
        logUrl();
        return this;
    }

    // Set the rating from parameter and log the URL
    public MovieApiUrlBuilder setRatingFrom(String ratingFrom) {
        this.ratingFrom = ratingFrom;
        logUrl();
        return this;
    }

    // Construct and log the current state of the URL
    private void logUrl() {
        StringBuilder url = new StringBuilder(BASE_URL);
        boolean hasParameters = false;

        // Append query parameter if set
        if (query != null && !query.isEmpty()) {
            url.append(hasParameters ? DELIMITER : "?").append("query=").append(query);
            hasParameters = true;
        }
        // Append genre parameter if set
        if (genre != null) {
            url.append(hasParameters ? DELIMITER : "?").append("genre=").append(genre);
            hasParameters = true;
        }
        // Append release year parameter if set
        if (releaseYear != null) {
            url.append(hasParameters ? DELIMITER : "?").append("releaseYear=").append(releaseYear);
            hasParameters = true;
        }
        // Append rating from parameter if set
        if (ratingFrom != null) {
            url.append(hasParameters ? DELIMITER : "?").append("ratingFrom=").append(ratingFrom);
            hasParameters = true;
        }

        // Log the constructed URL
        System.out.println("Constructed URL: " + url.toString());
    }

    // Build and return the final URL
    public String build() {
        StringBuilder url = new StringBuilder(BASE_URL);
        boolean hasParameters = false;

        // Append query parameter if set
        if (query != null && !query.isEmpty()) {
            url.append(hasParameters ? DELIMITER : "?").append("query=").append(query);
            hasParameters = true;
        }
        // Append genre parameter if set
        if (genre != null) {
            url.append(hasParameters ? DELIMITER : "?").append("genre=").append(genre);
            hasParameters = true;
        }
        // Append release year parameter if set
        if (releaseYear != null) {
            url.append(hasParameters ? DELIMITER : "?").append("releaseYear=").append(releaseYear);
            hasParameters = true;
        }
        // Append rating from parameter if set
        if (ratingFrom != null) {
            url.append(hasParameters ? DELIMITER : "?").append("ratingFrom=").append(ratingFrom);
            hasParameters = true;
        }

        // Return the final constructed URL
        return url.toString();
    }
}
