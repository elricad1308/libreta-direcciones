package mx.uacam.fi.its.pa.addressbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LibretaDirecciones extends Application {

    @Override
    public void start (Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/LibretaDirecciones.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Libreta de direcciones");
        stage.setScene(scene);
        stage.show();
    }

    public static void main (String[] args) {
        Application.launch(args);
    }
}
