package pl.patrykpora.internationalspacestation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class InternationalSpaceStationApplication extends Application {

    public static final Logger logger = LoggerFactory.getLogger(InternationalSpaceStationApplication.class);

    @Override
    public void start(Stage stage) throws IOException {
        logger.info("starting application......");
        FXMLLoader fxmlLoader = new FXMLLoader(InternationalSpaceStationApplication.class.getResource("start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("SPACE STATION APP!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}