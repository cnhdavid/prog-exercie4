package at.ac.fhcampuswien.fhmdb.ui;

public interface Observer {
    void update(boolean success, String message);
}