package sanity;

import extensions.ClientServerActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ClientServerFlows;

@Listeners(utilities.Listeners.class)
public class ClientServer extends CommonOps {

    @Test(description = "Test01 - Verify the Possibility to Send Output Messages")
    @Description("Verify the Possibility to Send Output Messages")
    public void test01_verifyOutputMessages() {
        ClientServerFlows.sendMessage(getData("SocketIP"), getData("SocketPort"), "One Two, One Two Is, Just. A. test!");
    }
}
