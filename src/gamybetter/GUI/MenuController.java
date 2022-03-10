/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import animatefx.animation.FadeIn;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

    public void setUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().
                getResource(location + ".fxml")));
    };
        
    @FXML
    public void ShopOnAction() throws IOException {
        setUi("Shop");
        new FadeIn(context).play();

    };
    @FXML
    public void HomeOnAction() throws IOException {
        setUi("slider");
        new FadeIn(context).play();

    };

     public void btnLogOut() {
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
            ShopOnAction();
            new FadeIn(context).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }    
    
}
