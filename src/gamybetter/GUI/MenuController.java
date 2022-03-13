/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import animatefx.animation.FadeIn;
import gamybetter.Utils.CurrentUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sayee
 */
public class MenuController implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private Button btnProfile;
    @FXML
    private Button btnShop;
    @FXML
    private Pane context;
    @FXML
    private Button btnEvent;
    @FXML
    private Button btnServies;
    @FXML
    private Button btnSessions;
    @FXML
    private Label exit;
    @FXML
    private Button btnSessions1;
    @FXML
    private Button btnSessions2;

    public void setUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().
                getResource(location + ".fxml")));
    };
        
    @FXML
    public void ShopOnAction() throws IOException {
        setUi("market");
        new FadeIn(context).play();

    };
    @FXML
    public void HomeOnAction() throws IOException {
        setUi("Home");
        new FadeIn(context).play();

    };

     public void btnLogOut() {
         CurrentUser.setCurrentUser(-1);
        Stage stage = (Stage) context.getScene().getWindow();
        stage.close();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });
        
        try {
            HomeOnAction();
            new FadeIn(context).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }    

    @FXML
    private void Events(ActionEvent event) throws IOException {
        setUi("Items");
        new FadeIn(context).play();
    }

    @FXML
    private void Blog(ActionEvent event) throws IOException {
        setUi("Publication");
        new FadeIn(context).play();
    }

    @FXML
    private void Session(ActionEvent event) throws IOException {
        setUi("SessionFXML");
        new FadeIn(context).play();
    }

    @FXML
    private void Cours(ActionEvent event) throws IOException {
        setUi("CoursFXML");
        new FadeIn(context).play();
    }

    @FXML
    private void Profile(ActionEvent event) throws IOException {
          setUi("Profile");
        new FadeIn(context).play();
    }
    
}
