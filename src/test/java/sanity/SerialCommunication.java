package sanity;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ClientServerFlows;
import workflows.SerialFlows;

@Listeners(utilities.Listeners.class)
public class SerialCommunication extends CommonOps {

    @Test(description = "Test01 - Sending Data Bytes to \"Arduino Uno\"")
    @Description("Verify the Possibility to Send Data Bytes Using Serial COM")
    public void test01_verifyOutputMessages() {
        SerialFlows.sendBytes(Integer.parseInt(getData("NumberOfBytes")));
    }
}

