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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author lizet
 */
public class FXMLAdminPromocionesController implements Initializable {

    @FXML
    private Label lbUsuarioSesion;
    @FXML
    private TableView<?> tvEmpresas;
    @FXML
    private TableColumn<?, ?> tcNombre;
    @FXML
    private TableColumn<?, ?> tcCodigo;
    @FXML
    private TableColumn<?, ?> tcCuponesDisp;
    @FXML
    private TableColumn<?, ?> tcSucursal;
    @FXML
    private TableColumn<?, ?> tcCategoria;
    @FXML
    private TableColumn<?, ?> tcFechaCaducidad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnMenuPrincipal(ActionEvent event) {
    }

    @FXML
    private void btnRegistroPromo(ActionEvent event) {
    }

    @FXML
    private void btnEdicionPromo(ActionEvent event) {
    }

    @FXML
    private void btnEliminarPromo(ActionEvent event) {
    }
    
}
