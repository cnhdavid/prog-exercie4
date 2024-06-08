package at.ac.fhcampuswien.fhmdb.ui;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(boolean success, String message);
}

