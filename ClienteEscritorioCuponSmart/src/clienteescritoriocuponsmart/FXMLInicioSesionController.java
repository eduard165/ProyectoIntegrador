/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteescritoriocuponsmart;

import clienteescritoriocuponsmart.Vistas.FXMLMenuPrincipalController;
import clienteescritoriocuponsmart.modelo.dao.InicioSesionDAO;
import clienteescritoriocuponsmart.modelo.pojo.RespuestaLoginEscritorio;
import clienteescritoriocuponsmart.modelo.pojo.Usuario;
import clienteescritoriocuponsmart.utils.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author lizet
 */
public class FXMLInicioSesionController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField tfUsuario;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Label lbErrorUsername;
    @FXML
    private Label lbErrorPassword;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnInicioSesion(ActionEvent event) {
        lbErrorUsername.setText("");
        lbErrorPassword.setText("");
        
        String username = tfUsuario.getText();
        String password = tfPassword.getText();
        
       boolean isValido = true;
       
       if(username.isEmpty()){
                   lbErrorUsername.setText("Nombre de usuario obligatorio.");

       }
       if(password.isEmpty()){
           lbErrorPassword.setText("Contraseña es obligatoria.");
       }
       
       if(isValido){
       verificarSesion(username, password);
       }
                
        
        
        
    }
    
     private void verificarSesion(String username, String password){ 
        RespuestaLoginEscritorio respuestaValidacionLogin = InicioSesionDAO.validarSesionUsuario(username, password);
        if(!respuestaValidacionLogin.getError()){
            Utilidades.mostrarAlertaSimple("Credenciales correctas", respuestaValidacionLogin.getContenido(), 
                    Alert.AlertType.INFORMATION);
            irPantallaPrincipal(respuestaValidacionLogin.getUsuarioSesion());
        }else{
            Utilidades.mostrarAlertaSimple("Error", respuestaValidacionLogin.getContenido(), 
                    Alert.AlertType.ERROR);
        
        }
    }
     private void irPantallaPrincipal(Usuario usuario){
       
        try {
             Stage stagePrincipal = (Stage)tfUsuario.getScene().getWindow();
            FXMLLoader loadVista = new FXMLLoader(getClass().getResource("FXMLMenuPrincipal.fxml"));
            Parent vista = loadVista.load();
            
           FXMLMenuPrincipalController controladorMenu = loadVista.getController();
           controladorMenu.inicializarMenu(usuario);
            
            Scene scene = new Scene(vista);
            stagePrincipal.setScene(scene);
            stagePrincipal.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
