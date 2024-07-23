package pl.patrykpora.internationalspacestation.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.patrykpora.internationalspacestation.model.IssSpeed;
import pl.patrykpora.internationalspacestation.repository.IssSpeedDao;
import pl.patrykpora.internationalspacestation.services.IssSpeedService;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class IssSpeedController implements Initializable {
    public Label current_speed_label;
    public Button get_data_button;
    public Label information_label;
    private final IssSpeedService issSpeedService;
    private final IssSpeedDao issSpeedDao;
    public static final Logger logger = LoggerFactory.getLogger(IssSpeedController.class);

    public IssSpeedController() {
        this.issSpeedDao = new IssSpeedDao();
        this.issSpeedService = new IssSpeedService();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adListeners();
    }

    private void adListeners() {
        get_data_button.setOnAction(action -> {
            information_label.setText("getting data from api it may take up to 10 seconds");
            information_label.setVisible(true);
            onGetDataButton();
            information_label.setVisible(false);
        });
    }


    private void onGetDataButton() {
        try {
            double speed = issSpeedService.calculateIssSpeed();
            String formattedSpeed = String.format("%.2f", speed);
            current_speed_label.setText(formattedSpeed + "KM/H");
            IssSpeed issSpeed = new IssSpeed(speed, LocalDate.now());
            issSpeedDao.save(issSpeed);
        } catch (Exception e) {
            logger.error("error when trying to calculate speed of iss", e);
            information_label.setText("error occurred when truing to get data from api");
        }

    }
}
