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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import gamybetter.Models.Commande;
import gamybetter.Models.Produit;
import gamybetter.Services.ServiceCommande;
import gamybetter.Utils.DataSource;
import com.twilio.type.PhoneNumber;
import java.util.Properties;    
import javafx.stage.Modality;
import javax.mail.*;    
import javax.mail.internet.*;    
import gamybetter.Utils.Mailer;
import gamybetter.Utils.SMSsender;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtIcomCode.setVisible(false);
        txtDate.setText(strDate);
        loadAllCommands();
        
    }    
    
     private void DefaultTxtFields(){
       
        txtIcomCode.clear();
        txtFirstName.clear();
        ttLastname.clear();
        txtAdresse.clear();
         txtEmail.clear();
         txtTotalPrice.clear();
         Discount.clear();
        
    }

    private void loadAllCommands() {
        
           ListView.setItems(listCommands);

    }

    @FXML
    private void searchItemOnAction(ActionEvent event) {
        
        //Double price = Double.parseDouble(txtTotalPrice.getText());
        
        List<Commande> CollectedList = listCommands.stream()
        .filter(cmd -> txtIcomCode.getText().equals(cmd.getId_commande())||
                        txtFirstName.getText().equals(cmd.getNom_personne())||
                        ttLastname.getText().equals(cmd.getPrenom_personne())||
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
        c.setNom_personne(ttLastname.getText());
        c.setAddresse_personne(txtAdresse.getText()); 
        c.setPrix_totale(price);
        c.setEmail_personne(txtEmail.getText());    
        
        sc.delete(c);
        
        ListView.getItems().remove(ListView.getSelectionModel().getSelectedItem());
            ObservableList<Commande> UpdatedListView = ListView.getItems();
            ListView.setItems(UpdatedListView);
            DefaultTxtFields();
    }

    @FXML
    private void UpdateCartOnAction(ActionEvent event) {
        Commande c =new Commande();
        
        Double price = Double.parseDouble(txtTotalPrice.getText());
        int disc = Integer.parseInt(Discount.getText());
        
        c.setId_commande(txtIcomCode.getText());
        c.setNom_personne(txtFirstName.getText());
        c.setPrenom_personne(ttLastname.getText());
        c.setAddresse_personne(txtAdresse.getText()); 
        c.setPrix_totale(price);
        c.setDiscount(disc);
        c.setEmail_personne(txtEmail.getText());

        
        sc.update(c);
        ListView.getItems().set( ListView.getSelectionModel().getSelectedIndex(), c);
        
            DefaultTxtFields();
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
            
        String price = String.valueOf(c .getPrix_totale());
        String discount = String.valueOf(c .getDiscount());
        
            txtIcomCode.setText(c.getId_commande());
            txtFirstName.setText(c.getNom_personne());
            ttLastname.setText(c.getPrenom_personne());
            txtAdresse.setText(c.getAddresse_personne());
            Discount.setText(discount);
            txtTotalPrice.setText(price);
            txtEmail.setText(c.getEmail_personne());
            txtTotal.setText(price);
            
            
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
                    + "\t\t\t LAST NAME = "+ttLastname.getText()+"\n"
                    + "------------------------------------------------------------------------------------------------------------------------------\n"
                    + "\t PRODUCT NAME \t\t\t QUANTITY \t Discount on item \t TOTAL PRICE  \n";
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
       int DISCOUNT=Integer.parseInt(Discount.getText());
       Double price = Double.parseDouble(txtTotalPrice.getText());
            prix_discounted =price-((price*DISCOUNT)/100);
            String discounted_price = String.valueOf(prix_discounted);
            DiscountTotal.setText(discounted_price);
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
