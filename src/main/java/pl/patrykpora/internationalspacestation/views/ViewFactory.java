package pl.patrykpora.internationalspacestation.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.patrykpora.internationalspacestation.model.Model;

import java.io.IOException;

public class ViewFactory {

    private static final Logger logger = LoggerFactory.getLogger(ViewFactory.class);
    private AnchorPane dashboardView;
    private AnchorPane menuPanelView;
    private BorderPane mainPanelView;
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

    public BorderPane getMainPanelView() {
        if (mainPanelView == null) {
            try {
                mainPanelView = new FXMLLoader(getClass().getResource("/fxml/main_panel.fxml")).load();
            } catch (IOException e) {
                logger.error("error during creating main panel view", e);
            }
        }
        mainPanelView.setCenter(Model.getInstance().getViewFactory().getDashboardView());
        return mainPanelView;
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
            scene = new Scene(loader.load());
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
