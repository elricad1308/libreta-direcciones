package mx.uacam.fi.its.pa.addressbook;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class LibretaDireccionesController {
    @FXML private TextField apellidoTextField;
    @FXML private TextField emailTextField;
    @FXML private TextField findTextField;
    @FXML private ListView<Persona> listView;
    @FXML private TextField nombreTextField;
    @FXML private TextField telefonoTextField;

    // Interactúa con la base de datos
    private final PersonaModel modelo = new PersonaModel();

    // Almacena una lista de objetos Persona retornados
    // por las consultas a la base de datos
    private final ObservableList<Persona> contactos = FXCollections.observableArrayList();

    // Llena la listView y configura el manejador de eventos para selección
    public void initialize () {
        listView.setItems(contactos);
        obtenerTodos();

        // Cuando cambia la selección en la listView, despliega los datos de la persona
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> { mostrarContacto(newValue); }
        );
    }

    private void obtenerTodos () {
        contactos.setAll(modelo.obtenerTodos());
        seleccionarPrimero();
    }

    private void seleccionarPrimero () {
        listView.getSelectionModel().selectFirst();
    }

    private void mostrarContacto (Persona p) {
        if (p != null) {
            nombreTextField.setText(p.getNombre());
            apellidoTextField.setText(p.getApellido());
            emailTextField.setText(p.getEmail());
            telefonoTextField.setText(p.getTelefono());
        } else {
            nombreTextField.clear();
            apellidoTextField.clear();
            emailTextField.clear();
            telefonoTextField.clear();
        }
    }

    // Agrega una nueva entrada
    @FXML void agregarRegistroButtonPressed(ActionEvent event) {
        Persona p = new Persona();
        p.setNombre(nombreTextField.getText());
        p.setApellido(apellidoTextField.getText());
        p.setEmail(emailTextField.getText());
        p.setTelefono(telefonoTextField.getText());

        int resultado = modelo.agregarPersona(p);
        if (resultado == 1) {
            mostrarAlerta(AlertType.INFORMATION,
                    "Registro agregado",
                    "El registro fue agregado exitosamente");
        } else {
            mostrarAlerta(AlertType.ERROR,
                    "Error al agregar",
                    "Ocurrió un error al intentar agregar el registro");
        }

        obtenerTodos();
    }

    // Encuentra una entrada por apellido
    @FXML void buscarButtonPressed(ActionEvent event) {
        List<Persona> personas = modelo.obtenerPorApellido(findTextField.getText() + "%");

        if (personas.size() > 0) {
            contactos.setAll(personas);
            seleccionarPrimero();
        } else {
            mostrarAlerta(AlertType.INFORMATION,
                    "No encontrado",
                    "No se encontraron registros con ese apellido");
        }
    }

    @FXML
    void verTodosButtonPressed(ActionEvent event) {
        obtenerTodos();
    }

    private void mostrarAlerta (AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
