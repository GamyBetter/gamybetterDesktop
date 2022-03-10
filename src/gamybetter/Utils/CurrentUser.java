/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Utils;

/**
 *
 * @author skon1
 */
public final class CurrentUser {

    private static int current_user;

    public static int getCurrentUser() {
        return current_user;
    }

    public static void setCurrentUser(int id) {
        current_user = id;
    }

}
