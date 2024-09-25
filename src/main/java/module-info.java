module com.groupproject.javachess {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.groupproject.javachess to javafx.fxml;
    exports com.groupproject.javachess;
}