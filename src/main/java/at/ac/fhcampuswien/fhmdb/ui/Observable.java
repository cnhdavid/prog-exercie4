package at.ac.fhcampuswien.fhmdb.ui;

public interface Observable {
    // Method to add an observer
    void addObserver(Observer observer);
    // Method to remove an observer
    void removeObserver(Observer observer);
    // Method to notify all observers with a message
    void notifyObservers(String message);
}

