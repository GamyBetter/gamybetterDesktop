/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Utils;

/**
 *
 * @author Sayee
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSsender {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = System.getenv("AC7975df3a9b093a762d7a1ff4b02a54ab");
    public static final String AUTH_TOKEN = System.getenv("c97235bd540a94d89bceff98b215619d");

    public static void sms(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21694226708"),
                new com.twilio.type.PhoneNumber("+21629132266"),
                "Hi there")
            .create();

        System.out.println(message.getSid());
    }
}