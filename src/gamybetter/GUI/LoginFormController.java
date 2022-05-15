/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;
import animatefx.animation.BounceIn;
import animatefx.animation.FadeInDownBig;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sayee
 */
public class LoginFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXButton btnSignIn;
    @FXML
    private JFXButton btnCLose;
    @FXML
    private ImageView logomini;
    @FXML
    private ImageView logobig;
    @FXML
    private ImageView close;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image imabak=new Image("/gamybetter/Ressources/logo-2.png");
       logobig.setImage(imabak);
       Image avatar= new Image("/gamybetter/Ressources/favicon.png");
       logomini.setImage(avatar);
       Image icon=new Image("/gamybetter/Ressources/close.png");
       close.setImage(icon);
    }    

    @FXML
    private void LoginOnAction(ActionEvent event) throws IOException {
        String userName = txtUserName.getText().trim();
        String password = txtPassword.getText().trim();
        if (userName.length() > 0 && password.length() > 0) {
            if (userName.equalsIgnoreCase("admin")
                    && password.equals("admin")) {
               // System.out.println("HEREEEEEEEE");
                Stage window = (Stage) this.root.getScene().getWindow();
                Parent par = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                Scene scene = new Scene(par);
                window.setScene(scene);
                window.centerOnScreen();
                new BounceIn(par).play();
                 //window.show();
                 
            } else {
                Stage window = (Stage) this.root.getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("../GUI/Menu.fxml"));
                        Parent parent =  fxmlLoader.load();
                        window.setScene(new Scene(parent));
                        window.centerOnScreen();
                        window.show();
                    
            }
        }
    }

    @FXML
    private void btnCloaseOnAction(ActionEvent event) throws IOException {
    Stage stage = (Stage) root.getScene().getWindow();
       stage.close();
    }

    @FXML
    private void signupp(MouseEvent event) {
        Node node = (Node) event.getSource();
         Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        try {
        
            Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
    
        
    
        Scene scene = new Scene(root);
        stage.setScene(scene);
    
        stage.show();
      } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
    }
    }
    
}
