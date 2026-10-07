module com.mycompany.ra1_inscripcionactividadesextraescolares_danieldr {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.ra1_inscripcionactividadesextraescolares_danieldr to javafx.fxml;
    exports com.mycompany.ra1_inscripcionactividadesextraescolares_danieldr;
}
