package sanity;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ClientServerFlows;
import workflows.SerialFlows;

@Listeners(utilities.Listeners.class)
public class SerialCommunication extends CommonOps {

    //Should be verified with TTL or Screen
    @Test(description = "Test01 - Sending Data Bytes to \"Arduino Uno\"")
    @Description("Verify the Possibility to Send Data Bytes Using Serial COM")
    public void test01_verifyOutputMessages() {
        SerialFlows.sendBytes(Integer.parseInt(getData("NumberOfBytes")));
    }

//    @Test(description = "Test02 - Receiving Data from \"Arduino Uno\"")
//    @Description("Verify the Possibility to Receive Data Using Serial COM")
//    public void test02_verifyInputMessages() { SerialFlows.receiveData(getData("ReadTimeout"), getData("WriteTimeout"));
//    }

}

