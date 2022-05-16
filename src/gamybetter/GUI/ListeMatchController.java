/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

import gamybetter.Models.Match;
import gamybetter.Services.ServiceMatch;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MAG028
 */
public class ListeMatchController implements Initializable {

    @FXML
    private ImageView idi;
    private TextField tfcher;

    ServiceMatch match1 = new ServiceMatch();
    ObservableList<Match> listmatch = FXCollections.observableArrayList();
    @FXML
    private JFXListView<Match> idlistview;
    @FXML
    private JFXButton btnsupprimer;
    @FXML
    private JFXButton btnmodifier;
    @FXML
    private JFXTextField tfid;
    @FXML
    private JFXTextField tfscore;
    @FXML
    private JFXTextField tflien;
    @FXML
    private JFXTextField tfstatus;
    @FXML
    private JFXTextField tfgold;
    private JFXTextField tfduree;
    private JFXTextField tfdate;
    private JFXTextField tfhero;
    @FXML
    private JFXTextField tdeq;
    @FXML
    private JFXTextField tfeq1;
    @FXML
    private JFXComboBox<String> cbduree;
      private String [] duree ={"15minutes" ,"20minutes","25minutes", "30minutes","35minutes"};
   
    @FXML
    private JFXButton chercher;
    @FXML
    private JFXTextField tfchercher;
    @FXML
    private JFXDatePicker datepicker;
    @FXML
    private ImageView back;
    @FXML
    private JFXTextField im1;
    @FXML
    private JFXTextField im2;
    @FXML
    private JFXTextField tftemps;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        listmatch = FXCollections.observableArrayList(match1.getAll());
        idlistview.setItems(listmatch);
        tfid.setVisible(false);
        tdeq.setVisible(false);
        tfeq1.setVisible(false);
        cbduree.getItems().addAll(duree);
        
        /* Image i =new Image("/gamybetter/Ressources/valo.png");
         idi.setImage(i);*/
        /*   FilteredList<Match> filtereddate = new FilteredList<>(listmatch);

         // bind predicate based on datepicker choices
         filtereddate.predicateProperty().bind(Bindings.createObjectBinding(() -> {
         LocalDate minDate = startpicker.getValue();
         LocalDate maxDate = endpicker.getValue();

         // get final values != null
         final LocalDate finalMin = minDate == null ? LocalDate.MIN : minDate;
         final LocalDate finalMax = maxDate == null ? LocalDate.MAX : maxDate;

         // values for openDate need to be in the interval [finalMin, finalMax]
         return ti -> !finalMin.isAfter(ti.getOpenDate()) && !finalMax.isBefore(ti.getOpenDate());
         },
         startpicker.valueProperty(),
         endpicker.valueProperty()));

         tbliste.setItems(listmatch);
         */
       /* for (Match e : match1.getAll()) {
           
        }
      tfchercher.textProperty().addListener((observable, oldValue, newValue) -> {
       List <Match> listevent= match1.getAll().stream().filter(e -> (e.getDescription().toLowerCase().contains(newValue)||e.getStart_date().toString().contains(newValue)||Integer.toString(e.getFees()).contains(newValue))).collect(Collectors.toList());
       idlistview.setIt

          for (Match e : listevent) {
ObservableList<Match> SearchedMatch = FXCollections.observableArrayList(CollectedList);
       idlistview.setItems(SearchedMatch);          }    
        
       //DefaultTxtFields();
      });*/
    }
public void loadMatch(){
    idlistview.setItems(listmatch);
}
   

    @FXML
    private void supprimer(ActionEvent event) {

        int id_match = idlistview.getSelectionModel().getSelectedItem().getId_match();

        match1.deleteById(id_match);
        

        for (int i = 0; i < listmatch.size(); i++) {
            if (listmatch.get(i).getId_match() == id_match) {
                listmatch.remove(i);
            }

        }

    }

      
    
    @FXML
    private void modifier(ActionEvent event) {
LocalDate localDateDeb = datepicker.getValue();
        
Date datedeb = java.sql.Date.valueOf(localDateDeb);
     
        String image1 = im1.getText();
        String image2 = im2.getText();
        String score = tfscore.getText();
        String lien_streaming = tflien.getText();
        String status = tfstatus.getText();
        String gold = tfgold.getText();
        String duree = cbduree.getValue();
        Date date= datedeb;
        String temps= tftemps.getText();
      //  int id_equipe = Integer.parseInt(tdeq.getText());
      //  int id_equipe1 = Integer.parseInt(tfeq1.getText());

        Match ma = new Match(image1,image2,score, lien_streaming, status, gold, duree, date,temps);
        match1.modifier(ma);
        idlistview.getItems().set(idlistview.getSelectionModel().getSelectedIndex(), ma);
        ma.setId_equipe1(1);
        ma.setId_equipe2(2);
    }

    @FXML
    private void OnSelect(javafx.scene.input.MouseEvent event) {
 
        Match cmatch = idlistview.getSelectionModel().getSelectedItem();
      /*  idlistview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Match>() {

            @Override
            public void changed(ObservableValue<? extends Match> observable, Match oldValue, Match newValue) {
                Match cmatch = idlistview.getSelectionModel().getSelectedItem();*/
                //tfid.setText(Integer.toString(cmatch.getId_match()));
               im1.setText(cmatch.getImage1());
               im2.setText(cmatch.getImage2());
                tfscore.setText(cmatch.getScore());
                tflien.setText(cmatch.getLien_streaming());
                tfstatus.setText(cmatch.getStatus());
                tfgold.setText(cmatch.getGold());
                tfduree.setText(cmatch.getDuree());
                tfdate.setText(cmatch.getDate().toString());
                
                tdeq.setText(Integer.toString(cmatch.getId_equipe1()));
                tfeq1.setText(Integer.toString(cmatch.getId_equipe2()));
            }
/*
    public void loadAndGet(Match match) {
       // FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Item2.fxml"));
        Node root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        idlistview.getItems().add(match);  
    }
    */
    @FXML
    private void chercher(ActionEvent event) {
        
    
        //Double price = Double.parseDouble(txtTotalPrice.getText());
        
        List<Match> CollectedList = listmatch.stream()
        .filter(cmd -> tfchercher.getText().equals(String.valueOf(cmd.getScore()))||
                      tfchercher.getText().equals(cmd.getDate())
        )
                       /* txtFirstName.getText().equals(cmd.getNom_personne())||
                        ttLastname.getText().equals(cmd.getPrenom_personne())||
                        txtAdresse.getText().equals(cmd.getAddresse_personne())||
                        txtEmail.getText().equals(cmd.getEmail_personne())
                        //price.equals(cmd.getPrix_totale())
                )*/
        .collect(Collectors.toList());
        
        ObservableList<Match> SearchedMatch = FXCollections.observableArrayList(CollectedList);
       idlistview.setItems(SearchedMatch);
        if 
            (tfchercher.getText().isEmpty() ){
            loadMatch();
        }
        } 
            
    
    

    
       
    /*  FilteredList<Match> fl =new FilteredList<>(listmatch);
     tfchercher.textProperty().addListener((observable, oldValue, newValue) -> {
     fl.setPredicate(Match -> {
    
     if(newValue.isEmpty() || newValue==null){
     return true;
     }
     String inputsearch = newValue.toLowerCase();
     if (String.valueOf(Match.getScore()).toLowerCase().indexOf(inputsearch) > -1){
     return  true;

     }/*if (String.valueOf(product.getCategory()).toLowerCase().indexOf(inputsearch) > -1){
     return  true;

     
     return  false;
     });
     });
    }   
    }
    */
     
       
                  
  
    @FXML
    private void back(MouseEvent event) throws IOException {
        Parent dashboard ;
                dashboard = FXMLLoader.load(getClass().getResource("Match.fxml"));


                Scene dashboardScene = new Scene(dashboard);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(dashboardScene);
             //   window.setTitle("Gestion Produit");
                window.show();
    }
    
    
   /* public ObservableList<Event> getByStartDate(LocalDate startDate) {
        ObservableList <Event> x= FXCollections.observableArrayList();
        ObservableList <Event> ol= eventDao.getAll();
       ol.stream().filter(e->e.getStart_date().isEqual(startDate)).forEach(e->x.add(e));
      return x;
    
    public ObservableList<Match> getByStartDate(LocalDate startDate) {
            
        ObservableList <Match> x= FXCollections.observableArrayList();
        ObservableList <Match> ol= ServiceMatch.getAll();
       ol.stream().filter(e->e.getDate().isEqual(startDate)).forEach(e->x.add(e));
      return x;
    */

   @FXML
    private void im1(ActionEvent event) {
          FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(.jpg)", ".jpg");
            FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("JPEG files(.jpeg)", ".jpeg");
            FileChooser.ExtensionFilter ext3 = new FileChooser.ExtensionFilter("PNG files(.png)", ".png");
          File file= fc.showOpenDialog(null);
          if(file != null){
              im1.appendText(file.getAbsolutePath()+ "\n");
              
          } else{
              System.out.println("not valid");
                  }
    }

    @FXML
    private void im2(ActionEvent event) {
          FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(.jpg)", ".jpg");
            FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("JPEG files(.jpeg)", ".jpeg");
            FileChooser.ExtensionFilter ext3 = new FileChooser.ExtensionFilter("PNG files(.png)", ".png");
          File file= fc.showOpenDialog(null);
          if(file != null){
              im2.appendText(file.getAbsolutePath()+ "\n");
              
          } else{
              System.out.println("not valid");
                  }
    }
   

    
    }


        

     
 
           

