/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import gamybetter.Services.MyListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import gamybetter.Models.Commande;
import gamybetter.Models.Panier;
import gamybetter.Models.Produit;
import gamybetter.Services.ServiceProduit;
import gamybetter.Services.MyListener;
import gamybetter.Services.ServiceCommande;
<<<<<<< Updated upstream
=======
import gamybetter.Utils.CurrentUser;
>>>>>>> Stashed changes

/**
 * FXML Controller class
 *
 * @author Sayee
 */
public class MarketController implements Initializable {

    //@FXML
    //private VBox chosenFruitCard;
    @FXML
    private Label itemNameLable;
    @FXML
    private Label itemPriceLabel;
    //@FXML
    //private ScrollPane scroll;
    @FXML
    private GridPane grid;

    /**
     * Initializes the controller class.
     */
     
    
    //@FXML
    //private Button btnSearch;
    //@FXML
    //private Label langue;
    @FXML
    private Label desc;
    @FXML
    private Label id_product;
    @FXML
    private TextField txtFQty;
    //@FXML
    //private Button btnSearch;
    @FXML
    private Label langue;
    
   ServiceProduit sp = new ServiceProduit();
  
    List<Produit> products = new ArrayList<>();
        private Image image;
    private MyListener myListener;
    int column = 0;
        int row = 1;
    @FXML
    private Button btnSearch;
    @FXML
    private ImageView ItemImg;
    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label id_com;
    ServiceCommande sc=new ServiceCommande();
    List<Commande> Commands = new ArrayList<>();
    List<Produit> Prods = new ArrayList<>();
InputStream stream;
    @FXML
    private TextField searchedProduct;
    private void setChosenItemDefault() {
        itemNameLable.setText("Select a product");
        itemPriceLabel.setText( "Price 'DT'");
       // image = new Image(getClass().getResourceAsStream();
        //fruitImg.setImage(image);
        desc.setText("DESCRIPTION");
        txtFQty.setText("0");
    }

     private void setChosenItem(Produit produit) throws FileNotFoundException {
         id_product.setText(produit.getId());
        itemNameLable.setText(produit.getNom_produit());
        itemPriceLabel.setText(String.valueOf(produit.getPrix()) );
        stream = new FileInputStream(produit.getImage());
            image = new Image(stream);
        //Image image = new Image(getClass().getResourceAsStream(product.getImage()));
        ItemImg.setImage(image);
        desc.setText(produit.getDescription());
        
    }
     
private void Loaditems(List products){
    
    
}
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
        
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //
        setChosenItemDefault();
    if (id_com.getText().trim().isEmpty() || sc.getById(id_com.getText()) == new Commande()){
            GenerateCommandeId();
        }
        id_com.setVisible(true);
        id_product.setVisible(false);
<<<<<<< Updated upstream
         products=sp.getAll();
         
         
       if (products.size() > 0) {
            try {
                // System.out.println(products);
                setChosenItem(products.get(0));
            } catch (FileNotFoundException ex) {
                ex.getMessage();
            }
=======
        System.out.println("DATA FETCHED");
         products=sp.getAll();
         if (products.size() > 0) {
             
>>>>>>> Stashed changes
            myListener = new MyListener() {
                @Override
                public void onClickListener(Produit produit) {
                    try {
                        setChosenItem(produit);
                    } catch (FileNotFoundException ex) {
                        ex.getMessage();
                    }
                }
            };
        }
<<<<<<< Updated upstream
=======
         if(products.isEmpty()){
             System.out.println("no data ");
         }
>>>>>>> Stashed changes

        try {
            for (int i = 0; i < products.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Produit.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
<<<<<<< Updated upstream
                
                ProduitController itemController = fxmlLoader.getController();
                System.out.println(products.get(i));
                itemController.setData(products.get(i),myListener);
                                
=======

                ProduitController itemController = fxmlLoader.getController();
                itemController.setData( products.get(i),myListener);
>>>>>>> Stashed changes

                if ( column == 3) {
                    column = 0;
                    row++;
                }
<<<<<<< Updated upstream
                
=======

>>>>>>> Stashed changes
                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.getMessage();
        }
<<<<<<< Updated upstream
=======
         
       // Loaditems(products);
>>>>>>> Stashed changes
        
        
    } 
    public void setIDCom(String id){
    id_com.setText(id);
    
}
private void GenerateCommandeId() {
<<<<<<< Updated upstream

=======
System.out.println("DATA FETCHED");
>>>>>>> Stashed changes
            Commands = sc.getAll();
            int id = Commands.size();
            if (id == 0) {
                    this.id_com.setText("C001");
            }

            if (id > 0 && id <= 8) {
                this.id_com.setText("C00" + (id + 1));
            }

            if (id >= 9 && id <= 98) {
                this.id_com.setText("C0" + (id + 1));
            }

            if (id >= 99) {
                this.id_com.setText("C" + (id + 1));
            }
<<<<<<< Updated upstream
            Commande c = new Commande(id_com.getText(),"1");
=======
            int id_user=CurrentUser.getCurrentUser();

            Commande c = new Commande(id_com.getText(),id_user);
>>>>>>> Stashed changes
            sc.add(c);
        //customer Count Code
    }


    @FXML
    private void GoToChart(ActionEvent event) throws IOException {
    
    int quantite=Integer.parseInt(txtFQty.getText());
    double prix=Double.parseDouble(itemPriceLabel.getText());
    
    
    Panier panier =new Panier (id_com.getText(),id_product.getText(),quantite,prix);
        System.out.println(id_com.getText());
         Node node = (Node) event.getSource();
         Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        try {
        
            Parent root = FXMLLoader.load(getClass().getResource("Panier.fxml"));
    
        stage.setUserData(panier);
    
        Scene scene = new Scene(root);
        stage.setScene(scene);
    
        stage.show();
      } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
    }
    }
    /*       FXMLLoader loader=new FXMLLoader(getClass().getResource("Panier.fxml"));
            root=loader.load();
            System.out.println(id_product.getText()+"     "+txtFQty.getText()+"     "+itemPriceLabel.getText());
           PanierController paniercontroller = loader.getController();
            paniercontroller.setUserId(itemCode);
            paniercontroller.setQuantity(quantite);
            paniercontroller.setPrix_Unit(prix);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

    @FXML
    private void SearchOnAction(ActionEvent event) {
        Prods = sp.getAll();
        List<Produit> CollectedList;
        CollectedList = Prods.stream().filter(cmd -> searchedProduct.getText().equals(cmd.getNom_produit())).collect(Collectors.toList());
        grid.getChildren().clear();
        Loaditems(Prods);
    }
    


  
}
