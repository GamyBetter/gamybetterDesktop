/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import gamybetter.Models.Personne;
import gamybetter.Services.ServicePersonne;
import gamybetter.Utils.Encryption;
import gamybetter.Utils.SendMail;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ResetPasswordController implements Initializable {

    @FXML
    private JFXTextField resetMail;
    @FXML
    private JFXButton send;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    public int gen() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 1000000 + r.nextInt(1000000));
    }

    @FXML
    private void recupererMotDePasse(ActionEvent event) throws MessagingException {
        int generatedPassword = gen();
        ServicePersonne sp = new ServicePersonne();
        Personne p = sp.getByMail(resetMail.getText());
        p.setMot_de_passe(Encryption.crypt(Integer.toString(generatedPassword)));
        SendMail.sendMail(resetMail.getText(), "resetPassword", "generated Password : "+ generatedPassword);
        sp.modifier(p);
        Stage stage = (Stage) send.getScene().getWindow();
            stage.close();
        
        
        
    }
    
}
