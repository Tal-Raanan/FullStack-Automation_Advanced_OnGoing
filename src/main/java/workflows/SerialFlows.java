package workflows;

import extensions.ClientServerActions;
import extensions.SerialConnectionActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.io.IOException;

public class SerialFlows extends CommonOps {

    @Step("Sending Bytes to Device")
    public static void sendBytes(int x){
        try {
            SerialConnectionActions.sendDataBytes(x);
        } catch (Exception e) {
            System.out.println("Failed to send message: "+ x);
            logger.error("Failed to send message: "+ x);
        }
    }

    @Step("Receiving Data from Device")
    public static void receiveData(String ReadTimeout, String WriteTimeout){
        SerialConnectionActions.receiveData(ReadTimeout, WriteTimeout);
    }
}
