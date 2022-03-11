/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.twilio.Twilio;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import gamybetter.Models.Commande;

import gamybetter.Services.ServiceCommande;

import gamybetter.Utils.DataSource;

import gamybetter.Utils.CurrentUser;
 
import gamybetter.Utils.Mailer;
import java.util.Optional;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author Sayee
 */
public class CommandFormController implements Initializable {

    @FXML
    private Label txtDate;
    @FXML
    private JFXTextField txtIcomCode;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField Discount;
    @FXML
    private JFXTextField ttLastname;
    @FXML
    private JFXTextField txtAdresse;
    @FXML
    private JFXTextField txtTotalPrice;
    @FXML
    private JFXListView<Commande> ListView;
    @FXML
    private JFXTextField txtFirstName;
    
    ServiceCommande sc=new ServiceCommande();
    
     List<Commande> commandes = new ArrayList<>();
     
     ObservableList<Commande> listCommands = FXCollections.observableArrayList(sc.getAll());
     
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
    Date date = new Date();
    String strDate = formatter.format(date); 
    
    @FXML
    private JFXButton Email;
    private JFXButton EmailSent;
    @FXML
    private Label txtAdminName;
    @FXML
    private Pane discount;
    @FXML
    private Label txtTotal;
    @FXML
    private Label DiscountTotal;
    @FXML
    private JFXButton SMS;
double prix_discounted =0;

Alert alertinfo = new Alert(Alert.AlertType.INFORMATION);
Alert alert = new Alert(Alert.AlertType.WARNING);
 Alert alertconfirm = new Alert(Alert.AlertType.CONFIRMATION);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtAdminName.setText(sc.getAdmin(CurrentUser.getCurrentUser()));
        System.out.println(txtAdminName.getText());
        txtIcomCode.setVisible(false);
        txtDate.setText(strDate);
        loadAllCommands();
        
    }    
    
     private void DefaultTxtFields(){
       
        txtIcomCode.clear();
        txtFirstName.clear();
        txtAdresse.clear();
         txtEmail.clear();
         txtTotalPrice.clear();
         Discount.clear();
        
    }

    private void loadAllCommands() {
        
           ListView.setItems(listCommands);

    }

    private boolean CheckFields(){
        Boolean Okay =true;
        
        Pattern patternName = Pattern.compile("^[A-Za-z ]++$");
        if(txtFirstName.getText().isEmpty() || !patternName.matcher(txtFirstName.getText()).matches()){
            Okay=false;
		alert.setTitle(" NAME FIELD EMPTY ");
		//alert.setHeaderText("Results:");
		alert.setContentText("Name is empty OR incorrect input (Numbers not allowed )!");
		alert.showAndWait();
        }
        Pattern pattern = Pattern.compile("^[A-Za-z_0-9 ,]++$");
            if(txtAdresse.getText().isEmpty() || !pattern.matcher(txtAdresse.getText()).matches()){
                Okay=false;
            alert.setTitle("CHECK ADDRESS FIELD ");
		//alert.setHeaderText("Results:");
		alert.setContentText("ADDRESS is empty or incorrect input !");
		alert.showAndWait();
            }
            Pattern patternEmail = Pattern.compile("^(.+)@(\\S+)$");
            if(txtEmail.getText().isEmpty() || !patternEmail.matcher(txtAdresse.getText()).matches()){
                Okay=false;
                alert.setTitle("CHECK EMAIL FIELD ");
		//alert.setHeaderText("Results:");
		alert.setContentText("EMAIL is empty or incorrect input !");
		alert.showAndWait();
            }
             
            try{
              Pattern  patternDiscount =Pattern.compile("[0-9]++$");
            if(Discount.getText().isEmpty() || !patternDiscount.matcher(Discount.getText()).matches()){
                Okay=false;
            alert.setTitle("CHECK DISCOUNT FIELD ");
		//alert.setHeaderText("Results:");
		alert.setContentText("Discount is empty or incorrect input !");
		alert.showAndWait();
            }
            }catch(NumberFormatException ex){
                ex.getMessage();
            }
            try{
                Pattern  patternPrice =Pattern.compile("[0-9.]++$");
            if(DiscountTotal.getText().isEmpty() || !patternPrice.matcher(DiscountTotal.getText()).matches()){ 
                Okay=false;
           
		alert.setTitle("CHECK PRICE FIELD");
		//alert.setHeaderText("Results:");
		alert.setContentText("PRICE is  Empty or incorrect input !");

		alert.showAndWait();
        }
            }catch(NumberFormatException ex){
                ex.getMessage();
            }
            try{
                Pattern  patternPrice =Pattern.compile("[0-9.]++$");
            if(txtTotalPrice.getText().isEmpty() || !patternPrice.matcher(txtTotalPrice.getText()).matches()){ 
                Okay=false;
           
		alert.setTitle("CHECK PRICE FIELD");
		//alert.setHeaderText("Results:");
		alert.setContentText("PRICE is  Empty or incorrect input !");

		alert.showAndWait();
        }
            }catch(NumberFormatException ex){
                ex.getMessage();
            }
            System.out.println(Okay);
        return Okay;
    }
    
    @FXML
    private void searchItemOnAction(ActionEvent event) {
        
        //Double price = Double.parseDouble(txtTotalPrice.getText());
        
        List<Commande> CollectedList = listCommands.stream()
        .filter(cmd -> txtIcomCode.getText().equals(cmd.getId_commande())||
                        txtFirstName.getText().equals(cmd.getNom_personne())||
                        txtAdresse.getText().equals(cmd.getAddresse_personne())||
                        txtEmail.getText().equals(cmd.getEmail_personne())
                        //price.equals(cmd.getPrix_totale())
                )
        .collect(Collectors.toList());
        
        ObservableList<Commande> SearchedCommands = FXCollections.observableArrayList(CollectedList);
       ListView.setItems(SearchedCommands);
        DefaultTxtFields();
    }





    @FXML
    private void RemoveOnAction(ActionEvent event) {
        
        Commande c = new Commande();
        
        Double price = Double.parseDouble(txtTotalPrice.getText());
        
        c.setId_commande(txtIcomCode.getText());
        c.setNom_personne(txtFirstName.getText());
        c.setAddresse_personne(txtAdresse.getText()); 
        c.setPrix_totale(price);
        c.setEmail_personne(txtEmail.getText());    
        
         Optional<ButtonType> confirm = alertconfirm.showAndWait();
        alertconfirm.setTitle("DELETE COMMAND ");
      alertconfirm.setHeaderText("Are you sure want to delte this client's Command ?");
      alertconfirm.setContentText("Name :"+txtFirstName.getText());
      
        if(confirm.get() == ButtonType.OK){
            if(sc.delete(c)){
            
                alertinfo.setTitle("DELETED SUCCESSFULY ");
		
		alertinfo.setContentText("An existing command has been succesfuly deleted !");
		alertinfo.showAndWait();
                
                ListView.getItems().remove(ListView.getSelectionModel().getSelectedItem());
               ObservableList<Commande> UpdatedListView = ListView.getItems();
                ListView.setItems(UpdatedListView);
                DefaultTxtFields();
            }else{
                alert.setTitle("DELETED UNSUCCESSFULY ");
		
		alert.setContentText("Delete operation error !");
		alert.showAndWait();
            }
        }
        
    }

    @FXML
    private void UpdateCartOnAction(ActionEvent event) {
        
        if(CheckFields()){
            Commande c =new Commande();
        
        Double price = Double.parseDouble(txtTotalPrice.getText());
        int disc = Integer.parseInt(Discount.getText());
        
        c.setId_commande(txtIcomCode.getText());
        c.setNom_personne(txtFirstName.getText());
        c.setAddresse_personne(txtAdresse.getText()); 
        c.setDate(date);
        c.setPrix_totale(price);
        c.setDiscount(disc);
        c.setEmail_personne(txtEmail.getText());
        
        
            if(sc.update(c)){
            
            alertinfo.setTitle("UPDATE SUCCESSFULY ");
		
		alertinfo.setContentText("An existing command has been succesfuly UPDATED !");
		alertinfo.showAndWait();
                
                ListView.getItems().set( ListView.getSelectionModel().getSelectedIndex(), c);
        
            DefaultTxtFields();
            }else{
            alert.setTitle("UPDATE UNSUCCESSFULY ");
		
		alert.setContentText("UPDATE operation error !");
		alert.showAndWait();
            }
        

        }
        
    }

    @FXML
    private void GoBackToServices(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Services.fxml"));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();

        
    }
    


    @FXML
    private void OnSelect(MouseEvent event) {
        ListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Commande>() {
	@Override

	public void changed(ObservableValue<? extends Commande> arg0, Commande arg1, Commande arg2) {

	Commande c = ListView.getSelectionModel().getSelectedItem();
            
        String price = String.valueOf(c.getPrix_totale());
        String discount = String.valueOf(c.getDiscount());
        
            txtIcomCode.setText(c.getId_commande());
            txtFirstName.setText(c.getNom_personne());
            txtAdresse.setText(c.getAddresse_personne());
            Discount.setText(discount);
            txtTotal.setText(txtTotalPrice.getText());
            txtEmail.setText(c.getEmail_personne());
               try{
                   Discount.setText(discount);
            txtTotalPrice.setText(price);
               }catch(NumberFormatException ex){
                   ex.getMessage();
               }
            
            
            
            
	}	

    });
    }

    
    
@FXML
    private void ReloadAll(ActionEvent event) {
        ListView.setItems(listCommands);
    }
   

    @FXML
    private void EmailBill(ActionEvent event) throws IOException {
        
                            Connection cnx = DataSource.getInstance().getCnx();
                            
                            
                            
        String Message="#######################################################################################################################\n"
                    + " \t\t\t\t\t\t\t\t\t\t  GAMYBETTER \t\t\t\t \n"
                    + "#########################################################################################################################\n"
                    + "\t\t PURCHACE BILL   \n"
                    + "\t\t\t FIRST NAME = "+txtFirstName.getText()+"\n"
                    + "------------------------------------------------------------------------------------------------------------------------------\n"
                    + "\t PRODUCT NAME \t\t\t QUANTITY \t Discount on item \t TOTAL PRICE  \n"
                    + "------------------------------------------------------------------------------------------------------------------------------\n";
                            String query = "select itemCode,quanite_order,prix_unitaire  from `panier` where id_commande = '"+ txtIcomCode.getText()+"'";
                            
                            try {
                                    Statement st = cnx.createStatement();
                                    ResultSet rs = st.executeQuery(query);
                                    
                                    if (rs.next()) {
                                        System.out.println(rs.getObject(1));
                                        String sql ="Select nom_produit From produit  Where itemCode ='"+rs.getObject(1)+"'";
                                            Statement stsql = cnx.createStatement();
                                            ResultSet rssql = stsql.executeQuery(sql);
                                            rssql.next();
                                        Message=Message+ "\n \t \t"+rssql.getObject(1);
                                        Message=Message+ "\t\t\t"+rs.getObject(2);
                                        Message=Message+ "\t "+rs.getObject(4);
                                        double prix_totale=(rs.getInt(2)*rs.getDouble(3));
                                        Message=Message+ "\t"+((prix_totale * rs.getInt(4))/100)+"\n";
                                    } 


                                } catch (SQLException ex) {
                                    System.out.println(ex.getMessage());
                                }
                    
                        
                    Message = Message + "\t\t\t################################################################\n"
                    + "\t\t\t TOTAL PRICE \t\t"+txtTotal.getText() + " DT \n"
                    + "\t\t\t DISCOUNT \t\t"+Discount.getText()+ " DT \n"
                    + "\t\t\t PRICE AFTER DISCOUNT \t\t"+DiscountTotal.getText()+" DT\n"
                    + "####################################################################################################################\n"
                    + "\t\t\t\t THANK YOU FR YOU BUSINESS   \n"
                    + "\t\t\t\t SOFTWARE DEVELOPENT : OTOM   \n"
                    + "\t\t\t\t CONTACT US ON : +(216) 94 226 708  \n"
                             + "####################################################################################################################\n";
                    
        Mailer.send("gamybetter22@gmail.com","gamybetter123","Sayeessun@gmail.com","Purshace Bill",Message);
    }
    

    @FXML
    private void addDiscount(MouseEvent event) {
       try{
        int DISCOUNT=Integer.parseInt(Discount.getText());
       Double price = Double.parseDouble(txtTotalPrice.getText());
       prix_discounted =price-((price*DISCOUNT)/100);
            String discounted_price = String.valueOf(prix_discounted);
            DiscountTotal.setText(discounted_price);
       }catch(NumberFormatException ex){
           ex.getMessage();
       }
            
    }

    @FXML
    private void SMSBill(ActionEvent event) {

        Twilio.init(System.getenv("AC7975df3a9b093a762d7a1ff4b02a54ab"),System.getenv("c97235bd540a94d89bceff98b215619d"));
        com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message.creator(
                new com.twilio.type.PhoneNumber("+21694226708"),
                new com.twilio.type.PhoneNumber("+21629132266"),
                "Hi there")
            .create();

        System.out.println(message.getSid());
    
 }

    @FXML
    private void printBillOnAction(ActionEvent event) {
    }
    

}
