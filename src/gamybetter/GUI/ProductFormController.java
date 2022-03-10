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
    /*private TableView<Produit> tblProduit;
    private TableColumn<Produit, String> colItemCode;
    private TableColumn<Produit, String> colImage;
    private TableColumn<Produit, String> ColProdName;
    private TableColumn<Produit, String>colDescription;
    private TableColumn<Produit, String> colCategorie;
    private TableColumn<Produit, Integer> colStock;
    private TableColumn<Produit, Double> colUnitPrice;
*/
    /**
     * Initializes the controller class.
     */
     final FileChooser fileChooser = new FileChooser();
    ServiceProduit sp=new ServiceProduit();
     List<Produit> produit = new ArrayList<>(sp.getAll());
    
    
     
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
      
    @FXML
    
    private void addOnAction(ActionEvent event) {
       // if ((txtStock.getText() != null || !txtStock.getText().trim().isEmpty()) || (!txtUnitPrice.getText() == null || !txtUnitPrice.getText().trim().isEmpty())) {
            GenerateItemCode();
        //}
        int disc = Integer.parseInt(discount.getText());
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
        sp.add(p);
        ListView.getItems().add(p);
            ObservableList<Produit> UpdatedListView = ListView.getItems();
            ListView.setItems(UpdatedListView);
        GenerateItemCode();
    }

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
        
        ObservableList<Produit> SearchedProducts = FXCollections.observableArrayList(CollectedList);
       ListView.setItems(SearchedProducts);
        
    }
    
 @FXML
    private void UpdateOnAction(ActionEvent event) { 
        
      
        
        Produit p =new Produit();
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
         
        sp.update(p);
        
        // update the item in the model
        ListView.getItems().set( ListView.getSelectionModel().getSelectedIndex(), p );
        DefaultTxtFields();
        
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
        
        sp.delete(p);
       
        ListView.getItems().remove(ListView.getSelectionModel().getSelectedItem());
            ObservableList<Produit> UpdatedListView = ListView.getItems();
            ListView.setItems(UpdatedListView);
        DefaultTxtFields();
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
            
            txtItemCode.setText(p.getId());
            txtName.setText(p.getNom_produit());
            txtDesc.setText(p.getDescription());
            txtCategory.setText(p.getCategorie());
            txtUnitPrice.setText(price);
            txtStock.setText(stock);

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

    
