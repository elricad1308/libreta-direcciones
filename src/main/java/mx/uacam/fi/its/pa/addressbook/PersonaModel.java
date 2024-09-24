package mx.uacam.fi.its.pa.addressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaModel {

    private static final String HOST = "jdbc:mariadb://localhost:3306/db_libros";
    private static final String USER = "its";
    private static final String PASS = "Fdi_its_5a";

    private Connection conexion;
    private PreparedStatement selectAll;
    private PreparedStatement selectByApellido;

    private PreparedStatement insert;

    public PersonaModel () {
        try {
            conexion = DriverManager.getConnection(HOST, USER, PASS);

            // Crea la consulta que selecciona a todos los registros
            selectAll = conexion.prepareStatement(
                    "SELECT * FROM Direcciones ORDER BY apellido, nombre");

            // Crea la consulta que filtra registros por apellido
            selectByApellido = conexion.prepareStatement(
                    "SELECT * " +
                            "FROM Direcciones " +
                            "WHERE apellido LIKE ? " +
                            "ORDER BY apellido, nombre");

            // Crea la consulta que inserta un nuevo registro
            insert = conexion.prepareStatement(
                    "INSERT INTO Direcciones " +
                            "(nombre, apellido, email, telefono)" +
                            " VALUES (?, ?, ?, ?)");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Persona> obtenerTodos () {
        try (ResultSet resultado = selectAll.executeQuery()) {
            List<Persona> personas = new ArrayList<>();

            while (resultado.next()) {
                personas.add(new Persona(
                        resultado.getInt("IdDireccion"),
                        resultado.getString("Nombre"),
                        resultado.getString("Apellido"),
                        resultado.getString("Email"),
                        resultado.getString("Telefono")
                ));
            }

            return personas;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Filtra personas por apellido
    public List<Persona> obtenerPorApellido (String apellido) {
        try {
            selectByApellido.setString(1, apellido);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        try (ResultSet resultado = selectByApellido.executeQuery()) {
            List<Persona> personas = new ArrayList<>();

            while (resultado.next()) {
                personas.add(new Persona(
                        resultado.getInt("IdDireccione"),
                        resultado.getString("Nombre"),
                        resultado.getString("Apellido"),
                        resultado.getString("Email"),
                        resultado.getString("Telefono")
                ));
            }

            return personas;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    // Agrega una nueva persona
    public int agregarPersona (Persona p) {
        try {
            insert.setString(1, p.getNombre());
            insert.setString(2, p.getApellido());
            insert.setString(3, p.getEmail());
            insert.setString(4, p.getTelefono());

            return insert.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    // Cierra la conexión
    public void desconectar () {
        try {
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
