module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.schema to javafx.fxml;
    exports com.example.schema;
    exports com.example.inlogg;  // Gör paketet tillgängligt för andra moduler
    opens com.example.inlogg to javafx.fxml;
    opens com.example.CreateUser to javafx.fxml;
    exports com.example.CreateUser;
    opens com.example.hello to javafx.fxml;
    exports com.example.hello;
    opens com.example.Events to javafx.fxml;
    exports com.example.Events;

}
