package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class DesktopFlows extends CommonOps {

    @Step("Business Flow: Login")
    public static void ASMlogin(String pass) {
        try {
            if (asmLoginPage.btn_login.isDisplayed()); {
                UIActions.updateText(asmLoginPage.txtbox_password, pass);
                UIActions.click(asmLoginPage.btn_login);
                Uninterruptibles.sleepUninterruptibly(20, TimeUnit.SECONDS);
                System.out.println("Waiting is over");
            }
        }
        catch (NoSuchElementException e) {
            System.out.println("Already logged-in");
            }
    }

    @Step("Business Flow:Clear Logs")
    public static void clearLogs() {
        UIActions.click(asmMainPage.btn_meterLogs);
        UIActions.click(asmMainPage.btn_clearLogs);
        UIActions.click(asmMainPage.btn_yes);
        UIActions.click(asmMainPage.btn_OK);
        System.out.println("Logs been deleted successfully");
    }

    @Step("Business Flow: Get Device Log")
    public static void getDeviceLog() {
        UIActions.click(asmMainPage.btn_meterLogs);
        UIActions.click(asmMainPage.btn_browse);
        UIActions.click(asmMainPage.btn_desktop);
//        UIActions.click(aradMainPage.btn_Logs);
        UIActions.click(asmMainPage.btn_OK);
        UIActions.click(asmMainPage.btn_download);
        UIActions.click(asmMainPage.btn_OK);
    }

    @Step("Business Flow: Resetting Alarms")
    public static void resettingAlarms() {
        UIActions.click(asmAdvancedPage.btn_advanced);
        UIActions.click(asmAdvancedPage.btn_specialFunctions);
        UIActions.click(asmAdvancedPage.btn_resetAllAlarms);
        UIActions.click(asmMainPage.btn_save);
        System.out.println("Alarms have been successfully reset");
    }

    @Step("Business Flow: Setting Flow Rate Alarm")
    public static void setting_actQuantity(String quantity) {
        UIActions.click(asmAlarmPage.btn_alarmThresholds);
        UIActions.updateText(asmAlarmPage.txtbox_actQuantity, quantity);
        UIActions.click(asmMainPage.btn_save);
    }

    @Step("Business Flow: Setting Flow Rate Alarm")
    public static void setting_FlowRateAlarm(String flowRatevalue, String startDuration, String endDuration) {
        UIActions.click(asmAlarmPage.btn_alarmThresholds);
        UIActions.updateText(asmAlarmPage.txtbox_FRAThershold, flowRatevalue);
        UIActions.updateText(asmAlarmPage.txtbox_FRAstartDuration, startDuration);
        UIActions.updateText(asmAlarmPage.txtbox_FRAendDuration, endDuration);
        UIActions.click(asmMainPage.btn_save);
    }

    @Step("Business Flow: Setting Leakage Alarm")
    public static void setting_LeakageAlarm(String flowRatevalue, String AFT, String startDuration) {
        UIActions.click(asmAlarmPage.btn_alarmThresholds);
        UIActions.updateText(asmAlarmPage.txtbox_LAThershold, flowRatevalue);
        UIActions.updateText(asmAlarmPage.txtbox_LAAvaregeFT, AFT);
        UIActions.updateText(asmAlarmPage.txtbox_LAStartduration, startDuration);
        UIActions.click(asmAlarmPage.drpDown_LAEndDuration);
        UIActions.click(asmAlarmPage.drpDown_LA15Minutes);
        UIActions.click(asmMainPage.btn_save);
    }

    @Step("Business Flow: Setting Pipe Burst Alarm")
    public static void setting_PipeBurstAlarm(String flowRatevalue, String AFT) {
        UIActions.click(asmAlarmPage.btn_alarmThresholds);
        UIActions.updateText(asmAlarmPage.txtbox_PBThershold, flowRatevalue);
        UIActions.updateText(asmAlarmPage.txtbox_PBAvaregeFT, AFT);
        UIActions.click(asmAlarmPage.drpDown_PBStartduration);
        UIActions.click(asmAlarmPage.drpDown_PBStart10Minutes);
        UIActions.click(asmAlarmPage.drpDown_PBEndDuration);
        UIActions.click(asmAlarmPage.drpDown_PBEnd10Minutes);
        UIActions.click(asmMainPage.btn_save);
    }

    @Step("Business Flow: Setting Reverse Flow Alarm")
    public static void setting_ReverseFlowAlarm(String startAlarm, String AFT) {
        UIActions.click(asmAlarmPage.btn_alarmThresholds);
        UIActions.updateText(asmAlarmPage.txtbox_RFstartAlarm, startAlarm);
        UIActions.updateText(asmAlarmPage.txtbox_RFAvaregeFT, AFT);
        UIActions.click(asmMainPage.btn_save);
    }

    @Step("Business Flow: Setting Dry Pipe Alarm")
    public static void setting_DryPipeAlarm(String startDuration, String endDuration) {
        UIActions.click(asmAlarmPage.btn_alarmThresholds);
        UIActions.updateText(asmAlarmPage.txtbox_DPStartDuration, startDuration);
        UIActions.updateText(asmAlarmPage.txtbox_DPEndDuration, endDuration);
        UIActions.click(asmMainPage.btn_save);
    }

    @Step("Business Flow: Run Simulation")
    public static void runSimulation(String flowRate, String posVolume, String negVolume, int runningTime) {
        UIActions.click(asmAdvancedPage.btn_advanced);
        UIActions.click(asmAdvancedPage.btn_totalizerData);
        UIActions.click(asmAdvancedPage.btn_resetAccumulation);
        UIActions.updateText(asmAdvancedPage.txtbox_flow, flowRate);
        UIActions.updateText(asmAdvancedPage.txtbox_posVolume, posVolume);
        UIActions.updateText(asmAdvancedPage.txtbox_negVolume, negVolume);
        UIActions.click(asmMainPage.btn_save);
        Uninterruptibles.sleepUninterruptibly(2000, TimeUnit.MILLISECONDS);
        UIActions.click(asmMainPage.btn_disconnect);
        System.out.println("Simulator is running for " + getData("RunningTime") + " Minutes, " + "In FlowRate(m3/h) =" +" " + getData("FlowRate"));
        logger.info("Simulator is running for " + getData("RunningTime") + " Minutes, " + "In FlowRate(m3/h) =" +" " + getData("FlowRate"));
        Uninterruptibles.sleepUninterruptibly(runningTime, TimeUnit.MINUTES);
        System.out.println("Running time is over - Simulator stopped");
        logger.info("Running time is over - Simulator stopped");
    }
}
