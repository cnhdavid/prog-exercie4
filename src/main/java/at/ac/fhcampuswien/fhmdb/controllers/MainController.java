package at.ac.fhcampuswien.fhmdb.controllers;

import at.ac.fhcampuswien.fhmdb.database.DataBaseException;
import at.ac.fhcampuswien.fhmdb.ui.Observer;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, Observer {
    @FXML
    public JFXHamburger hamburgerMenu;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private BorderPane mainPane;

    @FXML
    private JFXButton homeBtn;

    @FXML
    private JFXButton watchlistBtn;

    @FXML
    private JFXButton aboutBtn;

    private boolean isMenuCollapsed = true;
    private HamburgerBasicCloseTransition transition;
    private static final MyFactory myFactory = new MyFactory();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transition = new HamburgerBasicCloseTransition(hamburgerMenu);
        transition.setRate(-1);
        drawer.toBack();

        hamburgerMenu.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            toggleMenuDrawer();
        });

        // Start with home view
        try {
            navigateToMovielist();
        } catch (DataBaseException e) {
            throw new RuntimeException(e);
        }
    }

    private void toggleHamburgerTransitionState() {
        transition.setRate(transition.getRate() * -1);
        transition.play();
    }

    private void toggleMenuDrawer() {
        toggleHamburgerTransitionState();

        if (isMenuCollapsed) {
            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), drawer);
            translateTransition.setByX(130);
            translateTransition.play();
            isMenuCollapsed = false;
            drawer.toFront();
        } else {
            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), drawer);
            translateTransition.setByX(-130);
            translateTransition.play();
            isMenuCollapsed = true;
            drawer.toBack();
        }
    }

    public void setContent(String fxmlPath){
        FXMLLoader loader = new FXMLLoader(MainController.class.getResource(fxmlPath));
        try {
            mainPane.setCenter(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(!isMenuCollapsed){
            toggleMenuDrawer();
        }
    }

    @FXML
    public void navigateToMovielist() throws DataBaseException {
        setContent("/fxml/movie-list.fxml");
    }

    @FXML
    public void navigateToWatchlist() throws DataBaseException {
        setContent("/fxml/watchlist.fxml");
    }
    
    @Override
    public void update(String message) {

        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Watchlist Update");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }
}
