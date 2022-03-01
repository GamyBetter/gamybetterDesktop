/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

/**
 *
 * @author skon1
 */
public class Create_table_cours {

    String query = "CREATE TABLE `pidev`. ( `id` INT NOT NULL AUTO_INCREMENT , `id_coach` INT NOT NULL , `email_coach` VARCHAR(50) NOT NULL , `categorie` VARCHAR(50) NOT NULL , `jeu` VARCHAR(50) NOT NULL , `prix` FLOAT NOT NULL , `lien_session` VARCHAR(200) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
}
