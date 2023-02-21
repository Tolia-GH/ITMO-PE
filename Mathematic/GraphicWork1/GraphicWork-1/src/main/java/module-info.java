module com.example.graphicwork {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.graphicwork to javafx.fxml;
    exports com.example.graphicwork;
}