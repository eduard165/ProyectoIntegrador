/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteescritoriocuponsmart.Vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lizet
 */
public class FXMLRegistroEmpresaController implements Initializable {

    @FXML
    private TextField tfRepLegal;
    @FXML
    private TextField tfRFC;
    @FXML
    private TextField tfNombreEmpresa;
    @FXML
    private TextField tfNombreComercial;
    @FXML
    private TextField tfColonia;
    @FXML
    private TextField tfCalle;
    @FXML
    private TextField tfCodigoPostal;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPaginaWeb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnGuardarEmpresa(ActionEvent event) {
    }

    @FXML
    private void btnCancelar(ActionEvent event) {
    }
    
}
