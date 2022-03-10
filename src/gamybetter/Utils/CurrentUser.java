/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Utils;

/**
 *
 * @author Admin
 */
public class CurrentUser {

    static int currentUser = 0;

    public CurrentUser() {
    }

    public static int getCurrentUser() {
        if (currentUser!=0) {
            return currentUser;
        }
        return 0;
    }
    public static void setCurrentUser(int id){
        currentUser = id;
    }

}
