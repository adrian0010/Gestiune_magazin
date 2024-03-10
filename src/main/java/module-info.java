module ro.oxide.gestiune_magazin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens ro.oxide.gestiune_magazin to javafx.fxml;
    exports ro.oxide.gestiune_magazin;
}