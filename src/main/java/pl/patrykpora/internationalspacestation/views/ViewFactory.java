package pl.patrykpora.internationalspacestation.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ViewFactory {

    private static final Logger logger = LoggerFactory.getLogger(ViewFactory.class);
    private AnchorPane dashboardView;
    private AnchorPane menuPanelView;
    private AnchorPane issSpeedView;
    private AnchorPane issRunLocationView;
    private AnchorPane peopleInSpaceView;

    private BorderPane main_panel;
    private final String NASA_ICON_PATH = "/images/nasa.png";

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


    public AnchorPane getMenuPanelView() {
        if (menuPanelView == null) {
            try {
                menuPanelView = new FXMLLoader(getClass().getResource("/fxml/menu_panel.fxml")).load();
            } catch (IOException e) {
                logger.error("error during creating menu view", e);
            }

        }
        return menuPanelView;
    }

    public BorderPane getMain_panel() {
        if (main_panel == null) {
            try {
                main_panel = new FXMLLoader(getClass().getResource("/fxml/main_panel.fxml")).load();
            } catch (IOException e) {
                logger.error("error during creating main panel view", e);
            }
        }
        return main_panel;
    }

    public AnchorPane getIssSpeedView() {
        if (issSpeedView == null) {
            try {
                issSpeedView = new FXMLLoader(getClass().getResource("/fxml/iss_speed.fxml")).load();
            } catch (IOException e) {
                logger.error("error during creating iss speed view", e);
            }
        }
        return issSpeedView;
    }

    public AnchorPane getIssRunLocationView() {
        if (issRunLocationView == null) {
            try {
                issRunLocationView = new FXMLLoader(getClass().getResource("/fxml/iss_run_for_location.fxml")).load();
            } catch (IOException e) {
                logger.error("error during creating iss run for location view", e);
            }
        }
        return issRunLocationView;
    }

    public AnchorPane getPeopleInSpaceView() {
        if (peopleInSpaceView == null) {
            try {
                peopleInSpaceView = new FXMLLoader(getClass().getResource("/fxml/people_in_space.fxml")).load();
            } catch (IOException e) {
                logger.error("error during creating people in space view", e);
            }
        }
        return peopleInSpaceView;
    }

    public void showDashboardWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dashboard.fxml"));
        createStage(loader);
    }

    public void showMainWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main_panel.fxml"));
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            main_panel = loader.load();
            scene = new Scene(main_panel);
        } catch (Exception e) {
            logger.error("error while creating scene ", e);
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setTitle("Space Station Monitoring");
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource(NASA_ICON_PATH))));
        stage.show();
    }


}
