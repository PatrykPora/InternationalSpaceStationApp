package pl.patrykpora.internationalspacestation.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import pl.patrykpora.internationalspacestation.model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    public Button count_iss_speed_button;
    public Button iss_run_for_location_button;
    public Button people_in_space_button;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addListeners();
    }

    private void addListeners() {
        count_iss_speed_button.setOnAction(action -> onCountIssSpeed());
        iss_run_for_location_button.setOnAction(action -> onRunForLocation());
        people_in_space_button.setOnAction(action -> onPeopleInSpace());
    }

    private void onCountIssSpeed() {
        Model.getInstance().getViewFactory().getMain_panel().setCenter(Model.getInstance().getViewFactory().getIssSpeedView());
    }

    private void onRunForLocation() {
        Model.getInstance().getViewFactory().getMain_panel().setCenter(Model.getInstance().getViewFactory().getIssRunLocationView());
    }

    private void onPeopleInSpace() {
        Model.getInstance().getViewFactory().getMain_panel().setCenter(Model.getInstance().getViewFactory().getPeopleInSpaceView());
    }

}
