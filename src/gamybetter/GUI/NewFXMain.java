/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;
import animatefx.animation.*;
import static javafx.scene.paint.Color.TRANSPARENT;
import java.util.Objects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NewFXMain extends Application {
    double x,y = 0;Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.show();
            new FadeInDownBig(root).play();
            scene.setFill(TRANSPARENT);
       /* Parent root = FXMLLoader.load(getClass().getResource("ProductForm.fxml"));//CommandForm ------ ProductForm
        primaryStage.initStyle(StageStyle.UNDECORATED);
*/
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}