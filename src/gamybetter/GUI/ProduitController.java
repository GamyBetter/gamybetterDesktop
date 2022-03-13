/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import gamybetter.Models.Produit;
import gamybetter.Services.MyListener;
/**
 * FXML Controller class
 *
 * @author Sayee
 */
public class ProduitController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;
    
    public static final String CURRENCY = "DT";
    
     private Produit produit;
     private MyListener myListener;
    @FXML
    private Label discount;
    Image image;
     InputStream stream;
    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(produit);
    }
    
    /**
     * Initializes the controller class.
     * @param product
     * @param myListener
     * @throws java.io.FileNotFoundException
     */
    public void setData(Produit product, MyListener myListener) throws FileNotFoundException {
        this.produit = product;
        this.myListener = myListener;
        nameLabel.setText(product.getNom_produit());
        priceLable.setText(product.getPrix()+CURRENCY);
        stream = new FileInputStream(product.getImage());
            image = new Image(stream);
        //Image image = new Image(getClass().getResourceAsStream(product.getImage()));
        img.setImage(image);
        discount.setText(String.valueOf(product.getDiscount()));

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    

   
    
}
