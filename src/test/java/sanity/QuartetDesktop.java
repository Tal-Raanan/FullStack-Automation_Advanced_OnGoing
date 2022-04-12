package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class QuartetDesktop extends CommonOps {

    @Test(description = "Test01 - Connecting SonataEU using BLE")
    @Description("This test verifies successful connectivity of Sonata EU with BLE")
    public void test01_verifyAdditionCommand() {
        DesktopFlows.BLEConnectivity();
        Verifications.elementIsVisible(quartetMain.btn_Disconnect);
    }

    @Test(description = "Test02 - Verify FW Version (GET_FW_VERSION ID=02)")
    @Description("This test verifies the correctness of the FW version")
    public void test02_getFWVersion() {
        DesktopFlows.getFWVersion();
        Verifications.elementIsVisible(quartetMain.txtbox_buffer);
        Verifications.verifyTextInElement(quartetMain.txtbox_buffer, "02 00 00 00\r\n" +
                "02 00 06 00 00 3D 00 01 00 05 00");
    }
}
