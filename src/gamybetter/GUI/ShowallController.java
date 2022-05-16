/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import gamybetter.Models.Actualite;
import gamybetter.Services.ServiceActualite;
import gamybetter.Services.ServiceMatch;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MAG028
 */
public class ShowallController implements Initializable {
   
 @FXML
    private JFXListView<Actualite> listactualite;
    /**
     * Initializes the controller class.
     */
    
ServiceActualite actu = new ServiceActualite();
ObservableList<Actualite> listactu =FXCollections.observableArrayList();
    @FXML
    private JFXTextField tfid;
    @FXML
    private JFXTextField tfimage;
    @FXML
    private JFXTextField tfvideo;
    @FXML
    private JFXTextField tfmatch;
    @FXML
    private JFXTextField tfpersonne;
    
     @FXML
    private JFXTextField tftitre;

    @FXML
    private JFXComboBox<String> combojeu;
    private String [] duree ={"Valorant" ,"FIFA","LOL"};

    @FXML
    private JFXTextArea tadescription;

    @FXML
    private JFXDatePicker datepicker;
    
    
     private JFXTextField tfjeu;
    private JFXTextField tfdate;
    
   
    //@Override
    public void initialize(URL url, ResourceBundle rb) {
        listactu = FXCollections.observableArrayList(actu.getAll());
        listactualite.setItems(listactu);
        tfid.setVisible(false);
        tfmatch.setVisible(false);
        tfpersonne.setVisible(false);
        
        combojeu.getItems().addAll(duree);
        // TODO
    /*  ServiceActualite actu = new ServiceActualite();
        listactu = FXCollections.observableArrayList(actu.getAll());

        climage.setCellValueFactory(new PropertyValueFactory<String, Actualite>("image"));
        clvideo.setCellValueFactory(new PropertyValueFactory<String, Actualite>("video"));
        clidmatch.setCellValueFactory(new PropertyValueFactory<Integer, Actualite>("id_match"));
        tbactualite.setItems(listactu);*/
     
      //  InputStream stream = new FileInputStream("C:\\\\Users\\\\MAG028\\\\OneDrive\\\\Bureau\\\\GamyBetter\\\\src\\\\gamybetter\\\\Ressources\\\\440px-JavaFX_Logo.png");
     // Image img =new Image(stream);
     
       // idimage.setImage(img);
        
        
        
        /* FilteredList<Actualite> fl =new FilteredList<>(listprd,b-> true);
        idsearch.textProperty().addListener((observable, oldValue, newValue) -> {
fl.setPredicate(product -> {
    if(newValue.isEmpty() || newValue==null){
return true;
    }
    String inputsearch = newValue.toLowerCase();
    if (String.valueOf(product.getPrice()).toLowerCase().indexOf(inputsearch) > -1){
return  true;

    }if (String.valueOf(product.getCategory()).toLowerCase().indexOf(inputsearch) > -1){
return  true;

    }
    
    
    
    else if (product.getName().toLowerCase().indexOf(inputsearch)> -1){
        return  true;
        

    }else
        return  false;
});
        });
     */
           
    }    

            

    @FXML
    private void modifact(ActionEvent event) {
        
        LocalDate localDateDeb = datepicker.getValue();
        
Date datedeb = java.sql.Date.valueOf(localDateDeb);
       // int id_actualie = Integer.parseInt(tfid.getText());
        String image = tfimage.getText();
        String video = tfvideo.getText();
        String jeu = combojeu.getValue();
        String titre = tftitre.getText();
        String description = tadescription.getText();
        
         Date date= datedeb;
//         int id_match = Integer.parseInt(tfid.getText());
 //       int id_personne = Integer.parseInt(tfpersonne.getText());
       
        
        Actualite ac = new Actualite (image, video,jeu,titre,description,date);
        ServiceActualite sm = new ServiceActualite();
        actu.modifier(ac);
        listactualite.getItems().set(listactualite.getSelectionModel().getSelectedIndex(), ac);
    ac.setId_match(1);
        ac.setId_personne(1);
    }

    
    
    
    
    @FXML
    private void suppactu(ActionEvent event) {
        
         int id_actualite = listactualite.getSelectionModel().getSelectedItem().getId_actualite();
       
        actu.deleteById(id_actualite);

        for (int i = 0; i < listactu.size(); i++) {
            if ( listactu.get(i).getId_actualite() == id_actualite){
                listactu.remove(i);
            }
        
            }
    } 
    
   @FXML
   
    private void OnSelect(javafx.scene.input.MouseEvent event) {
        
         Actualite ctable = listactualite.getSelectionModel().getSelectedItem();
        /*this.tfidpub.setText(Integer.toString(ctable.getId_Publication()));
        System.out.println("!id pub "+tfidpub.getText());*/
       tfimage.setText(ctable.getImage());
       tfvideo.setText(ctable.getVideo());
       tfjeu.setText(ctable.getJeu());
       tftitre.setText(ctable.getTitre());
        tadescription.setText(ctable.getDescription());
        tfdate.setText(ctable.getDate().toString());
        
                
       tfmatch.setText(Integer.toString(ctable.getId_match()));
       tfpersonne.setText(Integer.toString(ctable.getId_personne()));
        
        
        
        
    }

      /*  listactualite.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Actualite>() {

            @Override
            public void changed(ObservableValue<? extends Actualite> observable, Actualite oldValue, Actualite newValue) {
                Actualite cmatch = listactualite.getSelectionModel().getSelectedItem();
                //tfid.setText(Integer.toString(cmatch.getId_match()));
                tfimage.setText(cmatch.getImage());
                tfvideo.setText(cmatch.getVideo());
                
                tfmatch.setText(Integer.toString(cmatch.getId_match()));
                tfpersonne.setText(Integer.toString(cmatch.getId_personne()));
            }

        });

    }
*/

    @FXML
    private void ajoutimg(ActionEvent event) {
         FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(.jpg)", ".jpg");
            FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("JPEG files(.jpeg)", ".jpeg");
            FileChooser.ExtensionFilter ext3 = new FileChooser.ExtensionFilter("PNG files(.png)", ".png");
          File file= fc.showOpenDialog(null);
          if(file != null){
              tfimage.appendText(file.getAbsolutePath()+ "\n");
              
          } else{
              System.out.println("not valid");
                  }
    }

    @FXML
    private void ajoutervid(ActionEvent event) {
         FileChooser fc = new FileChooser();
       
          File file= fc.showOpenDialog(null);
          if(file != null){
              tfvideo.appendText(file.getAbsolutePath()+ "\n");
              
          } else{
              System.out.println("not valid");
                  }
    }

    @FXML
    private void back(javafx.scene.input.MouseEvent event) throws IOException {
        Parent dashboard ;
                dashboard = FXMLLoader.load(getClass().getResource("Actualite.fxml"));


                Scene dashboardScene = new Scene(dashboard);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(dashboardScene);
             //   window.setTitle("Gestion Produit");
                window.show();
    }
    
    
    } 
    
    
