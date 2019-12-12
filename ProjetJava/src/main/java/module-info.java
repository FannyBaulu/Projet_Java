module net.ProjetJava {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;

    opens net.ProjetJava to javafx.fxml;
    exports net.ProjetJava;
}