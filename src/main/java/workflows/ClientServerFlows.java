package workflows;

import extensions.ClientServerActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.io.IOException;

public class ClientServerFlows extends CommonOps {

    @Step("Sending Message to Server")
    public static void sendMessage(String ip, String port, String msg){
        try {
            ClientServerActions.clientOutputMessage(ip, port, msg);
            System.out.println("Message sent: "+ msg);
            logger.info("Message sent: "+ msg);
        } catch (IOException e) {
            System.out.println("Failed to send message: "+ msg);
            logger.error("Failed to send message: "+ msg);
        }
    }
}
