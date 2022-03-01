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
public class Create_table_session {
    String query = "CREATE TABLE `pidev`.`session` ( `id` INT NOT NULL AUTO_INCREMENT , `id_coach` INT NOT NULL , `email_coach` VARCHAR(50) NOT NULL , `email_joueur` VARCHAR(50) NOT NULL , `duree` INT NOT NULL , `date` DATE NOT NULL , `jeu` VARCHAR(50) NOT NULL , `categorie` VARCHAR(50) NOT NULL , `prix` FLOAT NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
}
