package pl.patrykpora.internationalspacestation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import pl.patrykpora.internationalspacestation.database.DBConnectionProvider;
import pl.patrykpora.internationalspacestation.model.Astronaut;
import pl.patrykpora.internationalspacestation.repository.AstronautDao;
import pl.patrykpora.internationalspacestation.services.PeopleInSpaceService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PeopleInSpaceController implements Initializable {
    public ListView<Astronaut> people_in_space_listView;
    public Label number_of_people_in_space_label;
    public Button get_data_button;

    private final PeopleInSpaceService peopleInSpaceService;
    private final AstronautDao astronautDao;

    public PeopleInSpaceController() {
        this.peopleInSpaceService = new PeopleInSpaceService();
        this.astronautDao = new AstronautDao();
        this.people_in_space_listView = new ListView<>();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        get_data_button.setOnAction(action -> {
            onGetDataButtonGetNumber();
            onGetDataButtonGetListOfAstronauts();
        });
    }

    private void onGetDataButtonGetNumber() {
        long number = peopleInSpaceService.getNumberOfPeopleInSpace();
        number_of_people_in_space_label.setText(String.valueOf(number));
    }

    private void onGetDataButtonGetListOfAstronauts() {
        people_in_space_listView.getItems().clear();
        people_in_space_listView.getSelectionModel().clearSelection();
        List<Astronaut> list = peopleInSpaceService.getAstronautList();
        ObservableList<Astronaut> observableList = FXCollections.observableArrayList();
        observableList.clear();
        observableList.addAll(list);
        list.forEach(astronautDao::save);
        list.clear();
        people_in_space_listView.setItems(observableList);
        people_in_space_listView.refresh();

    }

}
