/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;


<<<<<<< Updated upstream
=======
import com.jfoenix.controls.JFXButton;
>>>>>>> Stashed changes
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import gamybetter.Models.Commande;
import gamybetter.Services.ServiceCommande;
import gamybetter.Models.Panier;
import gamybetter.Services.ServicePanier;
<<<<<<< Updated upstream
=======
import gamybetter.Utils.CurrentUser;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
>>>>>>> Stashed changes

/**
 * FXML Controller class
 *
 * @author Sayee
 */
public class PanierController implements Initializable {

    @FXML
<<<<<<< Updated upstream
    private Label user_id;
    @FXML
=======
>>>>>>> Stashed changes
    private Label id_com;
    private Label ItemCode;
    
   
    private Label qty;
    
<<<<<<< Updated upstream
    
    
=======
    Alert alertinfo = new Alert(Alert.AlertType.INFORMATION);
Alert alert = new Alert(Alert.AlertType.WARNING);
     Alert alertconfirm = new Alert(Alert.AlertType.CONFIRMATION);
    
     
>>>>>>> Stashed changes
    ServicePanier sp=new ServicePanier();
    ServiceCommande sc=new ServiceCommande();
    List<Commande> Commands = new ArrayList<>();
    
    double total_price=0f;
    List<Panier> itemOrdered = new ArrayList<>();
    
   //int number = Integer.parseInt(user_id.getText());
    
    ObservableList<Panier> obListPanier =FXCollections.observableArrayList();
    @FXML
    private JFXListView<Panier> Chart;
    @FXML
    private Label Labelprix_unit;
    @FXML
    private Label totalprice;
<<<<<<< Updated upstream
=======
    @FXML
    private Label user_id;
>>>>>>> Stashed changes
    
    
    private void GenerateCommandeId() {

            Commands = sc.getAll();
            int id = Commands.size();
            if (id == 0) {
                this.id_com.setText("C001");
            }

            if (id > 0 && id <= 8) {
                this.id_com.setText("C00" + (id));
            }

            if (id >= 9 && id <= 98) {
                this.id_com.setText("C0" + (id));
            }

            if (id >= 99) {
                this.id_com.setText("C" + (id));
            }

        //customer Count Code
    }
    
    
    public void setQuantity(String q) {
             qty.setText(q);
    }
    
     public void addOnAction() {
         
                sp.add(new Panier(
                 id_com.getText(),       
                 ItemCode.getText(),
                 qty.getText()));

    }
     
         public void setUserId(String itemCode) {
<<<<<<< Updated upstream
             ItemCode.setVisible(true);
=======
             ItemCode.setVisible(false);
>>>>>>> Stashed changes
        ItemCode.setText(itemCode);
             
    }
         
        
	public void setPrix_Unit(String p) {
<<<<<<< Updated upstream
             Labelprix_unit.setVisible(true);
=======
             Labelprix_unit.setVisible(false);
>>>>>>> Stashed changes
        ItemCode.setText(p);
             
    }
                 
         public void loadTableView() {
	obListPanier =FXCollections.observableArrayList(sp.getItems(id_com.getText()));
        Chart.setItems(obListPanier);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //addOnAction();

       
        loadTableView();
        
    }

    @FXML
    private void receiveData(ActionEvent event) {
        // Step 1
  Node node = (Node) event.getSource();
  Stage stage = (Stage) node.getScene().getWindow();
  // Step 2
  Panier panier = (Panier) stage.getUserData();
  // Step 3
<<<<<<< Updated upstream
  id_com.setVisible(true);
  id_com.setText(panier.getId_commande());
sp.add(panier);
=======
  id_com.setVisible(false);
  id_com.setText(panier.getId_commande());

  if(sp.add(panier)){
            
            alertinfo.setTitle("ADDED SUCCESSFULY ");
		
		alertinfo.setContentText("Your ORDER has BEEN ADDED!");
		alertinfo.showAndWait();
        }else{
            alert.setTitle("ADDED UNSUCCESSFULY ");
		
		alert.setContentText("YOUR ORDER CANNOT BE ADDED !");
		alert.showAndWait();
        }
>>>>>>> Stashed changes
loadTableView();
obListPanier.forEach((i) -> {
           total_price=total_price + i.getPrix_produit_totale();
        });
        
        totalprice.setText(String.valueOf(total_price));
    }

    @FXML
    private void GobackToShop(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("market.fxml"));
           Parent  root=loader.load();
           
           MarketController market= loader.getController();
           market.setIDCom(id_com.getText());
       Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Remove(ActionEvent event) {
         
        
        Panier p = Chart.getSelectionModel().getSelectedItem();
<<<<<<< Updated upstream
        sp.delete(p);
       
        Chart.getItems().remove(Chart.getSelectionModel().getSelectedItem());
            ObservableList<Panier> UpdatedListView = Chart.getItems();
            Chart.setItems(UpdatedListView);
        //DefaultTxtFields();
    }

    @FXML
    private void update(ActionEvent event) {

    }

    @FXML
    private void Buy(ActionEvent event) {
       Commande c=new Commande(id_com.getText(),"3");
=======
        
         Optional<ButtonType> confirm = alertconfirm.showAndWait();
        alertconfirm.setTitle("DELETE PRODUCT ");
      alertconfirm.setHeaderText("Are you sure want to delte this Product ?");
      alertconfirm.setContentText("Name :"+p.getNom_produit());
      
      if(confirm.get() == ButtonType.OK){
            if(sp.delete(p)){
            
            alertinfo.setTitle("ORDER DELETED SUCCESSFULY ");
		
		alertinfo.setContentText("YOUR ORDER has been succesfuly deleted !");
		alertinfo.showAndWait();
                Chart.getItems().remove(Chart.getSelectionModel().getSelectedItem());
            ObservableList<Panier> UpdatedListView = Chart.getItems();
            Chart.setItems(UpdatedListView);
        }else{
            alert.setTitle("ORDER DELETE ERROR ");
		
		alert.setContentText("DELETE ORDER operation error !");
		alert.showAndWait();
        }
        }
        
       
        
        //DefaultTxtFields();
    }


    @FXML
    private void Buy(ActionEvent event) {
       Commande c=new Commande(id_com.getText(),CurrentUser.getCurrentUser());
>>>>>>> Stashed changes
       double prix=Double.parseDouble(totalprice.getText());
       sc.SetCommandPrice(c,prix );
        
    }


<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
}

