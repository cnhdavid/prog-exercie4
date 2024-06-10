package at.ac.fhcampuswien.fhmdb.api;  // Das Paket, in dem sich die Klasse befindet

// Definiert eine benutzerdefinierte Ausnahme, die von Exception erbt
public class MovieApiException extends Exception {

    // Standardkonstruktor ohne Parameter
    public MovieApiException() {
        super();  // Ruft den Standardkonstruktor der Basisklasse Exception auf
    }

    // Konstruktor, der eine Fehlermeldung als Parameter annimmt
    public MovieApiException(String message) {
        super(message);  // Ruft den Konstruktor der Basisklasse mit der Fehlermeldung auf
    }
}
