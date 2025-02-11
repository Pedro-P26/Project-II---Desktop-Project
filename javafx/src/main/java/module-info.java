module org.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.persistence;
    requires com.dlsc.formsfx;
    requires projeto2java.basedados;
    //requires projeto2java;


    opens org.example.javafx to javafx.fxml;
    exports org.example.javafx;

    exports org.example.javafx.EncomendasController;
    opens org.example.javafx.EncomendasController to javafx.fxml;

    exports org.example.javafx.RececionistaController;
    opens org.example.javafx.RececionistaController to javafx.fxml;

    exports org.example.javafx.ProducaoController;
    opens org.example.javafx.ProducaoController to javafx.fxml;
}