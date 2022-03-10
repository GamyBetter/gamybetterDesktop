/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author snoussi amine
 */
public class GestionTournois extends Application {

    private Stage primaryStage;
    private static BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setTitle("Gestion Des Tournois");
        showMainView();
        showMainItems();
    }

    private void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GestionTournois.class.getResource("GestionTournois.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void showMainItems() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GestionTournois.class.getResource("Items.fxml"));
        BorderPane mainItems = loader.load();
        mainLayout.setCenter(mainItems);
    }

    public static void showEvenementScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GestionTournois.class.getResource("EvenementForm.fxml"));
        BorderPane evenement = loader.load();
        mainLayout.setCenter(evenement);

    }

    public static void showEquipeScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GestionTournois.class.getResource("EquipeForm.fxml"));
        BorderPane equipe = loader.load();
        mainLayout.setCenter(equipe);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
