package at.ac.fhcampuswien.fhmdb.api;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import okhttp3.*;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class MovieAPI {
    private static final OkHttpClient client = new OkHttpClient();

    public static List<Movie> getAllMovies() throws MovieApiException {
        return getAllMovies(null, null, null, null);
    }

    public static List<Movie> getAllMovies(String query, Genre genre, String releaseYear, String ratingFrom) throws MovieApiException {
        // Erstellen der URL basierend auf den angegebenen Parametern
        String url = new MovieApiUrlBuilder()
                .setQuery(query)
                .setGenre(genre)
                .setReleaseYear(releaseYear)
                .setRatingFrom(ratingFrom)
                .build();

        // Erstellen der HTTP-Anfrage mit der gebauten URL
        Request request = new Request.Builder()
                .url(url)
                .removeHeader("User-Agent")  // Entfernt den bestehenden User-Agent Header
                .addHeader("User-Agent", "http.agent")  // Fügt einen neuen User-Agent Header hinzu
                .build();

        // Versuch, die Anfrage auszuführen und die Antwort zu verarbeiten
        try (Response response = client.newCall(request).execute()) {
            // Holt den Body der Antwort als String
            String responseBody = Objects.requireNonNull(response.body()).string();

            // Konvertiert das JSON-Antwort in ein Array von Movie-Objekten
            Gson gson = new Gson();
            Movie[] movies = gson.fromJson(responseBody, Movie[].class);

            // Gibt die Liste der Filme zurück
            return Arrays.asList(movies);
        } catch (Exception e) {
            // Bei einer Ausnahme wird eine MovieApiException mit der Fehlermeldung geworfen
            throw new MovieApiException(e.getMessage());
        }
    }


    public Movie requestMovieById(UUID id) throws MovieApiException {
        // Erstellen der URL basierend auf der übergebenen ID
        String url = new MovieApiUrlBuilder()
                .setQuery(id.toString())  // Annahme: Die ID wird als Abfrageparameter übergeben
                .build();

        // Erstellen der HTTP-Anfrage mit der gebauten URL
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Versuch, die Anfrage auszuführen und die Antwort zu verarbeiten
        try (Response response = client.newCall(request).execute()) {
            // Konvertiert das JSON-Antwort in ein Movie-Objekt
            Gson gson = new Gson();
            return gson.fromJson(Objects.requireNonNull(response.body()).string(), Movie.class);
        } catch (Exception e) {
            // Bei einer Ausnahme wird eine MovieApiException mit der Fehlermeldung geworfen
            throw new MovieApiException(e.getMessage());
        }
    }}

