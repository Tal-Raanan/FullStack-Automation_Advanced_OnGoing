package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import groovy.transform.ToString;
import io.qameta.allure.Step;
import org.joda.time.Minutes;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.aradSmart.AradLoginPage;
import pageObjects.aradSmart.AradMainPage;
import utilities.CommonOps;

import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;

public class DesktopFlows extends CommonOps {

    @Step("Business Flow: Login")
    public static void ASMlogin(String pass) {
        try {
            if (aradLoginPage.btn_login.isDisplayed()); {
                UIActions.updateText(aradLoginPage.txtbox_password, pass);
                UIActions.click(aradLoginPage.btn_login);
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
        UIActions.click(aradMainPage.btn_meterLogs);
        UIActions.click(aradMainPage.btn_clearLogs);
        UIActions.click(aradMainPage.btn_yes);
        UIActions.click(aradMainPage.btn_OK);
        System.out.println("Logs been deleted successfully");
    }

    @Step("Business Flow: Get Device Log")
    public static void getDeviceLog() {
        UIActions.click(aradMainPage.btn_meterLogs);
        UIActions.click(aradMainPage.btn_browse);
        UIActions.click(aradMainPage.btn_desktop);
//        UIActions.click(aradMainPage.btn_Logs);
        UIActions.click(aradMainPage.btn_OK);
        UIActions.click(aradMainPage.btn_download);
        UIActions.click(aradMainPage.btn_OK);
    }

    @Step("Business Flow: Resetting Alarms")
    public static void resettingAlarms() {
        UIActions.click(aradAdvancedPage.btn_advanced);
        UIActions.click(aradAdvancedPage.btn_specialFunctions);
        UIActions.click(aradAdvancedPage.btn_resetAllAlarms);
        UIActions.click(aradMainPage.btn_save);
        System.out.println("Alarms have been successfully reset");
    }

    @Step("Business Flow: Setting Flow Rate Alarm")
    public static void setting_actQuantity(String quantity) {
        UIActions.click(aradAlarmPage.btn_alarmThresholds);
        UIActions.updateText(aradAlarmPage.txtbox_actQuantity, quantity);
        UIActions.click(aradMainPage.btn_save);
    }

    @Step("Business Flow: Setting Flow Rate Alarm")
    public static void setting_FlowRateAlarm(String flowRatevalue, String startDuration, String endDuration) {
        UIActions.click(aradAlarmPage.btn_alarmThresholds);
        UIActions.updateText(aradAlarmPage.txtbox_FRAThershold, flowRatevalue);
        UIActions.updateText(aradAlarmPage.txtbox_FRAstartDuration, startDuration);
        UIActions.updateText(aradAlarmPage.txtbox_FRAendDuration, endDuration);
        UIActions.click(aradMainPage.btn_save);
    }

    @Step("Business Flow: Setting Leakage Alarm")
    public static void setting_LeakageAlarm(String flowRatevalue, String AFT, String startDuration) {
        UIActions.click(aradAlarmPage.btn_alarmThresholds);
        UIActions.updateText(aradAlarmPage.txtbox_LAThershold, flowRatevalue);
        UIActions.updateText(aradAlarmPage.txtbox_LAAvaregeFT, AFT);
        UIActions.updateText(aradAlarmPage.txtbox_LAStartduration, startDuration);
        UIActions.click(aradAlarmPage.drpDown_LAEndDuration);
        UIActions.click(aradAlarmPage.drpDown_LA15Minutes);
        UIActions.click(aradMainPage.btn_save);
    }

    @Step("Business Flow: Setting Pipe Burst Alarm")
    public static void setting_PipeBurstAlarm(String flowRatevalue, String AFT) {
        UIActions.click(aradAlarmPage.btn_alarmThresholds);
        UIActions.updateText(aradAlarmPage.txtbox_PBThershold, flowRatevalue);
        UIActions.updateText(aradAlarmPage.txtbox_PBAvaregeFT, AFT);
        UIActions.click(aradAlarmPage.drpDown_PBStartduration);
        UIActions.click(aradAlarmPage.drpDown_PBStart10Minutes);
        UIActions.click(aradAlarmPage.drpDown_PBEndDuration);
        UIActions.click(aradAlarmPage.drpDown_PBEnd10Minutes);
        UIActions.click(aradMainPage.btn_save);
    }

    @Step("Business Flow: Setting Reverse Flow Alarm")
    public static void setting_ReverseFlowAlarm(String startAlarm, String AFT) {
        UIActions.click(aradAlarmPage.btn_alarmThresholds);
        UIActions.updateText(aradAlarmPage.txtbox_RFstartAlarm, startAlarm);
        UIActions.updateText(aradAlarmPage.txtbox_RFAvaregeFT, AFT);
        UIActions.click(aradMainPage.btn_save);
    }

    @Step("Business Flow: Setting Dry Pipe Alarm")
    public static void setting_DryPipeAlarm(String startDuration, String endDuration) {
        UIActions.click(aradAlarmPage.btn_alarmThresholds);
        UIActions.updateText(aradAlarmPage.txtbox_DPStartDuration, startDuration);
        UIActions.updateText(aradAlarmPage.txtbox_DPEndDuration, endDuration);
        UIActions.click(aradMainPage.btn_save);
    }

    @Step("Business Flow: Run Simulation")
    public static void runSimulation(String flowRate, String posVolume, String negVolume, int runningTime) {
        UIActions.click(aradAdvancedPage.btn_advanced);
        UIActions.click(aradAdvancedPage.btn_totalizerData);
        UIActions.click(aradAdvancedPage.btn_resetAccumulation);
        UIActions.updateText(aradAdvancedPage.txtbox_flow, flowRate);
        UIActions.updateText(aradAdvancedPage.txtbox_posVolume, posVolume);
        UIActions.updateText(aradAdvancedPage.txtbox_negVolume, negVolume);
        UIActions.click(aradMainPage.btn_save);
        Uninterruptibles.sleepUninterruptibly(2000, TimeUnit.MILLISECONDS);
        UIActions.click(aradMainPage.btn_disconnect);
//        UIActions.click(aradAlarmPage.btn_alarmThresholds);
//        try {
//            if (aradMainPage.btn_yes.isDisplayed()); {
//                UIActions.click(aradMainPage.btn_yes);
//            }
//        }
//        catch (NoSuchElementException e){
//            System.out.println("Pop-Up window was not displayed");
//        }
        System.out.println("Simulator is running for " + getData("RunningTime") + " Minutes, " + "In FlowRate(m3/h) =" +" " + getData("FlowRate"));
        logger.info("Simulator is running for " + getData("RunningTime") + " Minutes, " + "In FlowRate(m3/h) =" +" " + getData("FlowRate"));
        Uninterruptibles.sleepUninterruptibly(runningTime, TimeUnit.MINUTES);
        System.out.println("Running time is over - Simulator stopped");
        logger.info("Running time is over - Simulator stopped");
    }
}
