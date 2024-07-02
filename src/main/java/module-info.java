module pl.patrykpora.internationalspacestation {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires eu.hansolo.fx.countries;
    requires eu.hansolo.toolbox;
    requires eu.hansolo.toolboxfx;
    requires com.almasb.fxgl.all;
    requires org.slf4j;

    opens pl.patrykpora.internationalspacestation to javafx.fxml;
    exports pl.patrykpora.internationalspacestation;
    exports pl.patrykpora.internationalspacestation.controller;
    opens pl.patrykpora.internationalspacestation.controller to javafx.fxml;
}