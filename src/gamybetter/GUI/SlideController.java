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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sayee
 */
public class SlideController implements Initializable {

    @FXML
    private Label menu;
    @FXML
    private Button exit;
    @FXML
    private Label menuClosed;
    @FXML

    private Button home;
    @FXML
    private Button profile;
    @FXML
    private Button blog;
    @FXML
    private Button tounoi;
    @FXML
    private Pane content;
    @FXML
    private AnchorPane slider;
    @FXML
    private Pane slide;
    @FXML
    private VBox slid;

    // Render in contxt pane 
        public void setUi(String location) throws IOException {
        content.getChildren().clear();
        content.getChildren().add(FXMLLoader.load(this.getClass().
                getResource(location + ".fxml")));
    };
        
    public void ShopOnAction() throws IOException {
        setUi("Shop");
        new FadeIn(content).play();

    };

    @FXML
     public void btnLogOut() {
        Stage stage = (Stage) content.getScene().getWindow();
        stage.close();
    }
     
    /**
     * Initializes the controller class.
     */
    @Override
       public void initialize(URL location, ResourceBundle resources) {
// exit button 
        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });
        
        //--------------- Slider fonction
        slider.setTranslateX(-200);
        menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-200);

            slide.setOnFinished((ActionEvent e)-> {
                menu.setVisible(false);
                menuClosed.setVisible(true);
            });
        });

        menuClosed.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-200);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                menu.setVisible(true);
                menuClosed.setVisible(false);
            });
        });
        
        //-------------------- initialise view default ------------------------
        
        try {
            ShopOnAction();
            new FadeIn(content).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

   

   
}