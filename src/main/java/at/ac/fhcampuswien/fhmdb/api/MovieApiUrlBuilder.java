package at.ac.fhcampuswien.fhmdb.api;

import at.ac.fhcampuswien.fhmdb.models.Genre;

public class MovieApiUrlBuilder {
    private static final String BASE_URL = "https://prog2.fh-campuswien.ac.at/movies";
    private static final String DELIMITER = "&";

    private String query;
    private Genre genre;
    private String releaseYear;
    private String ratingFrom;

    public MovieApiUrlBuilder setQuery(String query) {
        this.query = query;
        logUrl();
        return this;
    }

    public MovieApiUrlBuilder setGenre(Genre genre) {
        this.genre = genre;
        logUrl();
        return this;
    }

    public MovieApiUrlBuilder setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
        logUrl();
        return this;
    }

    public MovieApiUrlBuilder setRatingFrom(String ratingFrom) {
        this.ratingFrom = ratingFrom;
        logUrl();
        return this;
    }

    private void logUrl() {
        StringBuilder url = new StringBuilder(BASE_URL);
        boolean hasParameters = false;

        if (query != null && !query.isEmpty()) {
            url.append(hasParameters ? DELIMITER : "?").append("query=").append(query);
            hasParameters = true;
        }
        if (genre != null) {
            url.append(hasParameters ? DELIMITER : "?").append("genre=").append(genre);
            hasParameters = true;
        }
        if (releaseYear != null) {
            url.append(hasParameters ? DELIMITER : "?").append("releaseYear=").append(releaseYear);
            hasParameters = true;
        }
        if (ratingFrom != null) {
            url.append(hasParameters ? DELIMITER : "?").append("ratingFrom=").append(ratingFrom);
            hasParameters = true;
        }

        System.out.println("Constructed URL: " + url.toString());
    }

    public String build() {
        StringBuilder url = new StringBuilder(BASE_URL);
        boolean hasParameters = false;

        if (query != null && !query.isEmpty()) {
            url.append(hasParameters ? DELIMITER : "?").append("query=").append(query);
            hasParameters = true;
        }
        if (genre != null) {
            url.append(hasParameters ? DELIMITER : "?").append("genre=").append(genre);
            hasParameters = true;
        }
        if (releaseYear != null) {
            url.append(hasParameters ? DELIMITER : "?").append("releaseYear=").append(releaseYear);
            hasParameters = true;
        }
        if (ratingFrom != null) {
            url.append(hasParameters ? DELIMITER : "?").append("ratingFrom=").append(ratingFrom);
            hasParameters = true;
        }

        return url.toString();
    }
}
