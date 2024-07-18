package pl.patrykpora.internationalspacestation;

import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.patrykpora.internationalspacestation.database.DBConnectionProvider;
import pl.patrykpora.internationalspacestation.model.Model;

import java.io.IOException;

public class InternationalSpaceStationApplication extends Application {

    public static final Logger logger = LoggerFactory.getLogger(InternationalSpaceStationApplication.class);

    @Override
    public void start(Stage stage) throws IOException {
        logger.info("starting application .....");
       Model.getInstance().getViewFactory().showMainWindow();
    }

}