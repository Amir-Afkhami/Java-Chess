module com.groupproject.javachess {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens com.groupproject.javachess to javafx.fxml;
    exports com.groupproject.javachess;
}