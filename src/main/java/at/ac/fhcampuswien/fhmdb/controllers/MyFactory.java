package at.ac.fhcampuswien.fhmdb.controllers;

import javafx.util.Callback;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyFactory implements Callback<Class<?>, Object> {
    // Cache to store instances of classes
    private final Map<Class<?>, Object> cache = new HashMap<>();
    // Logger for logging messages
    private static final Logger logger = Logger.getLogger(MyFactory.class.getName());

    @Override
    public Object call(Class<?> type) {
        // Use cache to return existing instance or create a new one
        return cache.computeIfAbsent(type, k -> {
            try {
                // Log the creation of a new instance
                logger.log(Level.INFO, "Creating a new instance of " + type.getName());
                // Create a new instance using the default constructor
                return type.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                // Log the error if instance creation fails
                logger.log(Level.SEVERE, "Could not create controller: " + type.getName(), e);
                // Throw a RuntimeException if instance creation fails
                throw new RuntimeException("Could not create controller: " + type.getName(), e);
            }
        });
    }
}
