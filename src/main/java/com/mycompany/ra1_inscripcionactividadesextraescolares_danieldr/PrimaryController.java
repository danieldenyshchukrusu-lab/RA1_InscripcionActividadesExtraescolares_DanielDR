package com.mycompany.ra1_inscripcionactividadesextraescolares_danieldr;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {

    int contador = 0;
    
    @FXML
    private TextField nombre;
    
    @FXML
    private TextField apellidos;
    
    @FXML
    private TextField email;
    
    @FXML
    private PasswordField codfamilia;
    
    @FXML 
    private ComboBox<String> actividad = new ComboBox<>();
    
    @FXML 
    private CheckBox check;
    
    @FXML
    private Alert alertaInfo = new Alert(Alert.AlertType.INFORMATION);
    
    @FXML
    private Alert alertaError = new Alert(Alert.AlertType.ERROR);
    
    @FXML
    private void initialize() {
        
        check.setSelected(false);
        
        if (contador==0) {
            actividad.getItems().addAll("Robótica","Ajedrez","Pintura","Idiomas");
            contador++;
        }
            actividad.setValue(null);
    }
    
    @FXML
    private void inscribirse() {
        if (nombre.getText().length()!=0) {
            if (apellidos.getText().length()!=0) {
                if (email.getText().contains("@") && email.getText().contains(".") && 
                   (email.getText()).indexOf("@") < (email.getText().indexOf("."))) {
                    if (codfamilia.getText().length()==0 || codfamilia.getText().length()>=4) {
                        if (actividad.getValue()!=null) {
                            if (check.isSelected()==true) {
                                alertaInfo.setHeaderText("SOLICITUD INSCRITA");
                                alertaInfo.setContentText("Nombre: " +nombre.getText()+ " Apellidos: " +apellidos.getText()
                                                         +" Actividad elegida: " +actividad.getValue());
                                alertaInfo.showAndWait();
                            } else {
                                alertaError.setHeaderText("CONDICIONES");
                                alertaError.setContentText("Debe de aceptar las condiciones de inscripción.");
                                alertaError.showAndWait();
                            }
                        } else {
                            alertaError.setHeaderText("CAMPO DE ACTIVIDADES");
                            alertaError.setContentText("Debe de elegir una actividad.");
                            alertaError.showAndWait();
                        }
                    } else {
                        alertaError.setHeaderText("CAMPO CODIGO FAMILIA");
                        alertaError.setContentText("Codigo familia incorrecto. Tiene que estar vacio o tener un codigo de 4 o más caracteres.");
                        alertaError.showAndWait();
                    }
                } else {
                    alertaError.setHeaderText("CAMPO EMAIL");
                    alertaError.setContentText("Email erroneo. Vuelva a introducirlo.");
                    alertaError.showAndWait();
                }
            } else {
                alertaError.setHeaderText("CAMPO APELLIDO");
                alertaError.setContentText("El apellido esta vacio.");
                alertaError.showAndWait();
            }
        } else {
            alertaError.setHeaderText("CAMPO NOMBRE");
            alertaError.setContentText("El nombre esta vacio.");
            alertaError.showAndWait();
        }
            
    }
    
    @FXML 
    private void vaciartodo() {
        nombre.setText("");
        apellidos.setText("");
        email.setText("");
        codfamilia.setText("");
        
        initialize();
    }
    
}
