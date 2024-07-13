package pl.patrykpora.internationalspacestation.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ViewFactory {

    private static final Logger logger = LoggerFactory.getLogger(ViewFactory.class);
    private AnchorPane dashboardView;

    public ViewFactory() {
    }


    public AnchorPane getDashboardView() {
        if (dashboardView == null) {
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/fxml/dashboard.fxml")).load();
            } catch (IOException e) {
                logger.error("error during creating dashboard view", e);
            }
        }
        return dashboardView;
    }

    public void showDashboardWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dashboard.fxml"));
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            logger.error("error while creating scene ", e);
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setTitle("Space Station Monitoring");
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/images/nasa.png"))));
        stage.show();
    }


}
