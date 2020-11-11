package goweather;

import java.io.IOException;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class mainn extends Application {

    private static Stage primaryStage;
    private Scene scene;
    private static BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("GoWeather!");

        showMainView();

    }

    public void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(mainn.class.getResource("tablet1.fxml"));
        mainLayout = loader.load();
        scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

        //Delay logo screen for 3 seconds and move onto next page
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        Parent root = FXMLLoader.load(getClass().getResource("tabletlocation.fxml"));
        Scene scene2 = new Scene(root);
        delay.setOnFinished(event -> primaryStage.setScene(scene2));
        delay.play();

    }

    public static void getMainScreen() throws IOException {
        primaryStage.hide();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
