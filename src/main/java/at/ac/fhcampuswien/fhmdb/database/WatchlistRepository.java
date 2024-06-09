package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.ui.Observable;
import at.ac.fhcampuswien.fhmdb.ui.Observer;
import com.j256.ormlite.dao.Dao;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class WatchlistRepository implements Observable {
    private static WatchlistRepository instance;
    private Dao<WatchlistMovieEntity, Long> dao;
    private static final List<Observer> observers = new ArrayList<>();

    public WatchlistRepository() throws DataBaseException {
        try {
            this.dao = DatabaseManager.getInstance().getWatchlistDao();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public static WatchlistRepository getInstance() throws DataBaseException {
        if (instance == null) {
            instance = new WatchlistRepository();
        }
        return instance;
    }

    public List<WatchlistMovieEntity> getWatchlist() throws DataBaseException {
        try {
            return dao.queryForAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while reading watchlist");
        }
    }

    public int addToWatchlist(WatchlistMovieEntity movie) throws DataBaseException {
        try {
            // Only add the movie if it does not exist yet
            long count = dao.queryBuilder().where().eq("apiId", movie.getApiId()).countOf();
            if (count == 0) {
                int result = dao.create(movie);
                if (result > 0) {
                    notifyObservers("Added Watchlist");
                }
                return result;
            } else {
                notifyObservers("Already added to Watchlist");
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while adding to watchlist");
        }
    }

    public int removeFromWatchlist(String apiId) throws DataBaseException {
        try {
            return dao.delete(dao.queryBuilder().where().eq("apiId", apiId).query());
        } catch (Exception e) {
            throw new DataBaseException("Error while removing from watchlist");
        }
    }


    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) observer.update(message);
    }


}
