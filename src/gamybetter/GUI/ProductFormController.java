/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SpinnerValueFactory;

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.TablePosition;
import javafx.scene.image.Image;


import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import gamybetter.Models.Commande;
import gamybetter.Models.Produit;
import gamybetter.Services.ServiceProduit;
<<<<<<< Updated upstream
=======
import java.util.Optional;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
>>>>>>> Stashed changes

/**
 * FXML Controller class
 *
 * @author Sayee
 */
public class ProductFormController implements Initializable {

    @FXML
    private JFXTextField txtItemCode;
    @FXML
    private JFXTextField txtDesc;
    @FXML
    private JFXTextField txtUnitPrice;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtStock;
    @FXML
    private JFXButton setOnAction;
    @FXML
    private JFXTextField txtCategory;
    @FXML
    private ListView<Produit> ListView;
<<<<<<< Updated upstream
    /*private TableView<Produit> tblProduit;
    private TableColumn<Produit, String> colItemCode;
    private TableColumn<Produit, String> colImage;
    private TableColumn<Produit, String> ColProdName;
    private TableColumn<Produit, String>colDescription;
    private TableColumn<Produit, String> colCategorie;
    private TableColumn<Produit, Integer> colStock;
    private TableColumn<Produit, Double> colUnitPrice;
*/
=======
    
   Alert alertinfo = new Alert(Alert.AlertType.INFORMATION);
Alert alert = new Alert(Alert.AlertType.WARNING);
 Alert alertconfirm = new Alert(Alert.AlertType.CONFIRMATION);

 
>>>>>>> Stashed changes
    /**
     * Initializes the controller class.
     */
     final FileChooser fileChooser = new FileChooser();
    ServiceProduit sp=new ServiceProduit();
     List<Produit> produit = new ArrayList<>(sp.getAll());
    
<<<<<<< Updated upstream
    
=======

>>>>>>> Stashed changes
     
     ObservableList<Produit> listProduit = FXCollections.observableArrayList(sp.getAll());
    @FXML
    private JFXTextField imageURL;
    @FXML
    private JFXTextField discount;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       txtItemCode.setVisible(false);
        loadAllProducts();
    }    
    
    private void DefaultTxtFields(){
       
        txtItemCode.clear();
        txtCategory.clear();
        txtDesc.clear();
        txtName.clear();
         txtStock.clear();
         txtUnitPrice.clear();
        
    }
    
    private void GenerateItemCode() {

            produit = sp.getAll();
            int id = produit.size();
            
            if (id == 0) {
                this.txtItemCode.setText("P001");
            }

            if (id > 0 && id <= 8) {
                this.txtItemCode.setText("P00" + (id + 1));
            }

            if (id >= 9 && id <= 98) {
                this.txtItemCode.setText("P0" + (id + 1));
            }

            if (id >= 99) {
                this.txtItemCode.setText("P" + (id + 1));
            }

        //customer Count Code
    }
    

    
    private void loadAllProducts() {
        
           
           ListView.setItems(listProduit);
           ListView.setPadding(new Insets(10));
            GenerateItemCode();

    }
      
<<<<<<< Updated upstream
    @FXML
    
    private void addOnAction(ActionEvent event) {
       // if ((txtStock.getText() != null || !txtStock.getText().trim().isEmpty()) || (!txtUnitPrice.getText() == null || !txtUnitPrice.getText().trim().isEmpty())) {
            GenerateItemCode();
        //}
        int disc = Integer.parseInt(discount.getText());
=======
    private boolean CheckFields(){
        Boolean Okay =true;
        if(imageURL.getText().isEmpty()){
            Okay=false;
		alert.setTitle(" IMAGE EMPTY FIELD ");
		//alert.setHeaderText("Results:");
		alert.setContentText("ADD PRODUCT IMAGE !");
		alert.showAndWait();
        }
        Pattern pattern = Pattern.compile("^[A-Za-z_0-9- ]++$");
            if(txtName.getText().isEmpty() || !pattern.matcher(txtName.getText()).matches()){
                Okay=false;
            alert.setTitle("CHECK NAME FIELD ");
		//alert.setHeaderText("Results:");
		alert.setContentText("Name is empty or incorrect input (Numbers no allowed )!");
		alert.showAndWait();
            }
            if(txtDesc.getText().isEmpty() ){
                Okay=false;
                alert.setTitle("CHECK DESCRIPTION FIELD ");
		//alert.setHeaderText("Results:");
		alert.setContentText("DESCRIPTION is empty or incorrect input !");
		alert.showAndWait();
            }
             Pattern patternCategory = Pattern.compile("^[A-Za-z ]++$");
            if(txtCategory.getText().isEmpty() || !patternCategory.matcher(txtCategory.getText()).matches()){
                Okay=false;
            alert.setTitle("CHECK CATEGORY FIELD ");
		//alert.setHeaderText("Results:");
		alert.setContentText("Category is empty or incorrect input !");
		alert.showAndWait();
            } 
            try{
              Pattern  patternDiscount =Pattern.compile("[0-9]++$");
            if(discount.getText().isEmpty() || !patternDiscount.matcher(discount.getText()).matches()){
                Okay=false;
            alert.setTitle("CHECK CATEGORY FIELD ");
		//alert.setHeaderText("Results:");
		alert.setContentText("Category is empty or incorrect input !");
		alert.showAndWait();
            }
            }catch(NumberFormatException ex){
                ex.getMessage();
            }
            try{
                Pattern  patternPrice =Pattern.compile("[0-9]++$");
            if(txtUnitPrice.getText().isEmpty() || !patternPrice.matcher(txtUnitPrice.getText()).matches()){ 
                Okay=false;
           
		alert.setTitle("CHECK PRICE FIELD");
		//alert.setHeaderText("Results:");
		alert.setContentText("PRICE is  Empty or incorrect input !");

		alert.showAndWait();
        }
            }catch(NumberFormatException ex){
                ex.getMessage();
            }
            
        return Okay;
    }
    
    @FXML
    
    private void addOnAction(ActionEvent event) {

            GenerateItemCode();
        //}
        
            if(CheckFields()){
                int disc = Integer.parseInt(discount.getText());
>>>>>>> Stashed changes
        int stock = Integer.parseInt(txtStock.getText());
            double price = Double.parseDouble(txtUnitPrice.getText());
        Produit p=new Produit(txtItemCode.getText(),
                            imageURL.getText(),
                            txtName.getText(),
                            txtDesc.getText(),
                            txtCategory.getText(),
                            stock,
                            price,
                            disc
                             );
<<<<<<< Updated upstream
        sp.add(p);
        ListView.getItems().add(p);
            ObservableList<Produit> UpdatedListView = ListView.getItems();
            ListView.setItems(UpdatedListView);
        GenerateItemCode();
    }

=======
        if(!sp.getById(txtItemCode.getText()).equals(p)){
            
            if(sp.add(p)){
                alertinfo.setTitle("ADDED SUCCESSFULY ");
		
		alertinfo.setContentText("Product has been succelfuly added !");
		alertinfo.showAndWait();
                
                ListView.getItems().add(p);
                ObservableList<Produit> UpdatedListView = ListView.getItems();
                ListView.setItems(UpdatedListView);
                 GenerateItemCode();
  
            }else{
            alert.setTitle("ADD ERROR ");
		
		alert.setContentText("ADD operation error !");
		alert.showAndWait();
            }
           
        
       
            }else{
                alert.setTitle("THIS PRODUCT already EXISTs !");
		//alert.setHeaderText("Results:");
		alert.setContentText("this product exist , change inserted informations !");

		alert.showAndWait();
            }
    }
    }
>>>>>>> Stashed changes
    @FXML
    private void searchOnAction(ActionEvent event) {
       
        List<Produit> CollectedList = listProduit.stream()
        .filter(cmd -> txtItemCode.getText().equals(cmd.getId())||
                        txtName.getText().equals(cmd.getNom_produit())||
                        txtDesc.getText().equals(cmd.getDescription())||
                        txtCategory.getText().equals(cmd.getCategorie())||
                        txtUnitPrice.getText().equals(cmd.getPrix())
                        //price.equals(cmd.getPrix_totale())
                )
        .collect(Collectors.toList());
        
<<<<<<< Updated upstream
        ObservableList<Produit> SearchedProducts = FXCollections.observableArrayList(CollectedList);
       ListView.setItems(SearchedProducts);
        
=======
        DefaultTxtFields();
        
        ObservableList<Produit> SearchedProducts = FXCollections.observableArrayList(CollectedList);
       ListView.setItems(SearchedProducts);
        if(txtName.getText().isEmpty() && txtDesc.getText().isEmpty()&& txtCategory.getText().isEmpty()&& txtUnitPrice.getText().isEmpty()){
            loadAllProducts();
        }
>>>>>>> Stashed changes
    }
    
 @FXML
    private void UpdateOnAction(ActionEvent event) { 
        
      
<<<<<<< Updated upstream
        
        Produit p =new Produit();
=======
        if(CheckFields()){
            System.out.println(CheckFields());
            Produit p =new Produit();
>>>>>>> Stashed changes
        int disc = Integer.parseInt(discount.getText());
        Double price = Double.parseDouble(txtUnitPrice.getText());
        int stock = Integer.parseInt(txtStock.getText());
        
        p.setId(txtItemCode.getText());
        p.setNom_produit(txtName.getText());
        p.setDescription(txtDesc.getText());
        p.setCategorie(txtCategory.getText()); 
        p.setPrix(price);
        p.setImage(imageURL.getText());
        p.setQuantiteStock(stock);
         p.setDiscount(disc);
<<<<<<< Updated upstream
         
        sp.update(p);
        
        // update the item in the model
        ListView.getItems().set( ListView.getSelectionModel().getSelectedIndex(), p );
        DefaultTxtFields();
=======
         System.out.println("update "+sp.update(p));
       if( sp.update(p)){
            
            alertinfo.setTitle("UPDATE SUCCESSFULY ");
		
		alertinfo.setContentText("An existing Product has been succesfuly UPDATED !");
		alertinfo.showAndWait();
                
               ListView.getItems().set( ListView.getSelectionModel().getSelectedIndex(), p );
                DefaultTxtFields();
  
            }else{
            alert.setTitle("UPDATE UNSUCCESSFULY ");
		
		alert.setContentText("UPDATE operation error !");
		alert.showAndWait();
            }
        
        // update the item in the model
        
        }
        
>>>>>>> Stashed changes
        
    }
 @FXML
    private void DeleteOnAction(ActionEvent event) {
        
        Produit p =new Produit();
        
        Double price = Double.parseDouble(txtUnitPrice.getText());
        int stock = Integer.parseInt(txtStock.getText());
        
        p.setId(txtItemCode.getText());
        p.setNom_produit(txtName.getText());
        p.setDescription(txtDesc.getText());
        p.setCategorie(txtCategory.getText()); 
        p.setPrix(price);
        p.setQuantiteStock(stock);
        
<<<<<<< Updated upstream
        sp.delete(p);
       
        ListView.getItems().remove(ListView.getSelectionModel().getSelectedItem());
            ObservableList<Produit> UpdatedListView = ListView.getItems();
            ListView.setItems(UpdatedListView);
        DefaultTxtFields();
=======
         Optional<ButtonType> confirm = alertconfirm.showAndWait();
        alertconfirm.setTitle("DELETE PRODUCT ");
      alertconfirm.setHeaderText("Are you sure want to delte this Product ?");
      alertconfirm.setContentText("Name :"+txtName.getText());
      
      if(confirm.get() == ButtonType.OK){
            if(sp.delete(p)){
            
                alertinfo.setTitle("DELETED SUCCESSFULY ");
		
		alertinfo.setContentText("An existing command has been succesfuly deleted !");
		alertinfo.showAndWait();
                
                 ListView.getItems().remove(ListView.getSelectionModel().getSelectedItem());
                    ObservableList<Produit> UpdatedListView = ListView.getItems();
                    ListView.setItems(UpdatedListView);
                 DefaultTxtFields();
            }else{
                alert.setTitle("DELETED UNSUCCESSFULY ");
		
		alert.setContentText("Delete operation error !");
		alert.showAndWait();
            }
        }
        
       
        
>>>>>>> Stashed changes
    }

    @FXML
    private void setOnAction(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      File file = fileChooser.showOpenDialog(stage);
      //Image image1 = new Image(file.toURI().toString());
      String URL = file.toURI().toString();
      imageURL.setText(URL.substring(6, URL.length()));
    }
    
    
	
@FXML
    private void OnSelect(MouseEvent event) {
    ListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Produit>() {
	@Override

	public void changed(ObservableValue<? extends Produit> arg0, Produit arg1, Produit arg2) {

	Produit p = ListView.getSelectionModel().getSelectedItem();
                                  
               String price = String.valueOf(p.getPrix());
               String stock = String.valueOf(p.getQuantiteStock());
<<<<<<< Updated upstream
            
=======
               String discot = String.valueOf(p.getDiscount());
>>>>>>> Stashed changes
            txtItemCode.setText(p.getId());
            txtName.setText(p.getNom_produit());
            txtDesc.setText(p.getDescription());
            txtCategory.setText(p.getCategorie());
            txtUnitPrice.setText(price);
            txtStock.setText(stock);
<<<<<<< Updated upstream

=======
               discount.setText(discot);
>>>>>>> Stashed changes
	}	

    });
             
}

    
    
    
@FXML
    private void BackToCRUDPage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Services.fxml"));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();

    }

    
}

    
