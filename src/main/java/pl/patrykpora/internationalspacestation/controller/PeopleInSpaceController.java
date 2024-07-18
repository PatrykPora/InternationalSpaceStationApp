package pl.patrykpora.internationalspacestation.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import pl.patrykpora.internationalspacestation.database.DBConnectionProvider;
import pl.patrykpora.internationalspacestation.services.PeopleInSpaceService;

import java.net.URL;
import java.util.ResourceBundle;

public class PeopleInSpaceController implements Initializable {
    public ListView people_in_space_listView;
    public Label number_of_people_in_space_label;
    public Button get_data_button;

    private final PeopleInSpaceService peopleInSpaceService;
    private final DBConnectionProvider dbConnectionProvider;

    public PeopleInSpaceController() {
        this.peopleInSpaceService = new PeopleInSpaceService();
        this.dbConnectionProvider = DBConnectionProvider.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        get_data_button.setOnAction(action -> onGetDataButton());
    }

    private void onGetDataButton() {
        long number = peopleInSpaceService.getNumberOfPeopleInSpace();
        number_of_people_in_space_label.setText(String.valueOf(number));
        peopleInSpaceService.getAstronautList().forEach(System.out::println);
    }

}
