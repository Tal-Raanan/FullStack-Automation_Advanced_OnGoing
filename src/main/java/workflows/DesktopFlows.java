package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class DesktopFlows extends CommonOps {

    @Step("Business Flow: Sonata EU BLE Connectivity")
    public static void BLEConnectivity() {
        UIActions.mouseHoverByCoordinates(140, 128);
        UIActions.click(quartetMain.dropdown_BLE);
        UIActions.mouseHoverByCoordinates(300, 130);
        UIActions.click(quartetMain.dropdown_SonataEU);
        UIActions.mouseHoverByCoordinates(505, 130);
        UIActions.click(quartetMain.dropdown_Mac);
        UIActions.click(quartetMain.btn_Connect);
    }

    @Step("Business Flow: GET_FW_VERSION (ID=02)")
    public static void getFWVersion() {
        UIActions.click(quartetMain.btn_ID02getFWVersion);
        UIActions.click(quartetMain.btn_send);
        System.out.println(quartetMain.txtbox_buffer.getAttribute("Value.Value"));
    }
}
