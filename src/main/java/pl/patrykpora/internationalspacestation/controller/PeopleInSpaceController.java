package pl.patrykpora.internationalspacestation.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import pl.patrykpora.internationalspacestation.model.Astronaut;
import pl.patrykpora.internationalspacestation.repository.AstronautDao;

import java.net.URL;
import java.util.ResourceBundle;

public class PeopleInSpaceController implements Initializable {
    public ListView people_in_space_listView;
    public Label number_of_people_in_space_label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
