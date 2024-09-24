module LibretaDirecciones {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mariadb.jdbc;

    opens mx.uacam.fi.its.pa.addressbook to javafx.fxml, javafx.graphics;
}