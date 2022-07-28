package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sun.security.krb5.internal.crypto.Des;
import utilities.CommonOps;
import workflows.DesktopFlows;

import java.util.concurrent.TimeUnit;

@Listeners(utilities.Listeners.class)
public class AradSmartDesktop extends CommonOps {

    @Test(description = "Test01 - Verify Login")
    @Description("This test verifies successful login to Arad Smart")
    public void test01_verifyLogin() {
        DesktopFlows.ASMlogin(getData("AradPassword"));
        Verifications.elementIsVisible(aradMainPage.btn_disconnect);
    }

//    @Test(description = "Test02 - Clear Logs")
//    @Description("This test verifies the possibility to clear the main logs")
//    public void test02_clearLogs() {
//        DesktopFlows.clearLogs();
//    }
//
//    @Test(description = "Test03 - Resetting Alarms")
//    @Description("This test verifies the possibility to reset the alarms")
//    public void test03_resetAlarms() {
//        DesktopFlows.resettingAlarms();
//    }
//
//    @Test(description = "Test04 - Set Alarm Configurations")
//    @Description("This test verifies the possibility to set alarm configurations")
//    public void test04_setAlarmConfigurations() {
//        DesktopFlows.setting_actQuantity(getData("ActQuantity"));
//        DesktopFlows.setting_FlowRateAlarm(getData("UnreachedThresholdValue"), getData("StartDurationMin"), getData("EndDurationMin"));
//        DesktopFlows.setting_LeakageAlarm(getData("UnreachedThresholdValue"), getData("AFT"), getData("StartDurationHrs"));
//        DesktopFlows.setting_PipeBurstAlarm(getData("UnreachedThresholdValue"), getData("AFT"));
//        DesktopFlows.setting_ReverseFlowAlarm(getData("StartAlarm"), getData("AFT"));
//        DesktopFlows.setting_DryPipeAlarm(getData("StartDurationMin"), getData("EndDurationMin"));
//    }

    @Test(description = "Test05 - Run Simulation with no alarms")
    @Description("This test verifies the possibility to set alarm configurations")
    public void test05_runningSimulationWithNoAlarms() {
        DesktopFlows.runSimulation(getData("FlowRate"), getData("PosVolume"), getData("NegVolume"), (Integer.parseInt(getData("RunningTime"))));
    }

    @Test(description = "Test06 - Simulating Flow Rate Alarm")
    @Description("This test simulates flow rate alarm")
    public void test06_flowRateAlarm() {
        DesktopFlows.ASMlogin(getData("AradPassword"));
        DesktopFlows.getDeviceLog();
        DesktopFlows.setting_FlowRateAlarm(getData("ReachedThresholdValue"), getData("StartDurationMin"), getData("EndDurationMin"));
        DesktopFlows.runSimulation(getData("FlowRate"), getData("PosVolume"), getData("NegVolume"), (Integer.parseInt(getData("RunningTime"))));
        DesktopFlows.ASMlogin(getData("AradPassword"));
        DesktopFlows.setting_FlowRateAlarm(getData("UnreachedThresholdValue"), getData("StartDurationMin"), getData("EndDurationMin"));
    }

//    @Test(description = "Test07 - Simulating Leakage Alarm")
//    @Description("This test simulates leakage alarm")
//    public void test07_leakageAlarm() {
//        DesktopFlows.ASMlogin(getData("AradPassword"));
//        DesktopFlows.getDeviceLog();
//        DesktopFlows.setting_LeakageAlarm(getData("ReachedThresholdValue"), getData("StartDurationMin"), getData("EndDurationMin"));
//        DesktopFlows.runSimulation(getData("FlowRate"), getData("PosVolume"), getData("NegVolume"), (Integer.parseInt(getData("RunningTime"))));
//        DesktopFlows.ASMlogin(getData("AradPassword"));
//        DesktopFlows.setting_LeakageAlarm(getData("UnreachedThresholdValue"), getData("AFT"), getData("StartDurationHrs"));
//    }
//
//    @Test(description = "Test08 - Simulating Reverse Flow")
//    @Description("This test simulates reverse flow alarm")
//    public void test08_reverseFlowAlarm() {
//        DesktopFlows.ASMlogin(getData("AradPassword"));
//        DesktopFlows.getDeviceLog();
//        DesktopFlows.setting_ReverseFlowAlarm(getData("StartAlarm"), getData("AFT"));
//        DesktopFlows.runSimulation(getData("ReverseFlow"), getData("PosVolume"), getData("NegVolume"), (Integer.parseInt(getData("RunningTime"))));
//        DesktopFlows.ASMlogin(getData("AradPassword"));
//        DesktopFlows.runSimulation(getData("FlowRate"), getData("PosVolume"), getData("NegVolume"), (Integer.parseInt(getData("RunningTime"))));
//    }
//
//    @Test(description = "Test09 - Simulating Pipe Burst Alarm")
//    @Description("This test simulates pipe burst alarm")
//    public void test09_pipeBurstAlarm() {
//        DesktopFlows.ASMlogin(getData("AradPassword"));
//        DesktopFlows.getDeviceLog();
//        DesktopFlows.setting_PipeBurstAlarm(getData("ReachedThresholdValue"), getData("AFT"));
//        DesktopFlows.runSimulation(getData("FlowRate"), getData("PosVolume"), getData("NegVolume"), (Integer.parseInt(getData("RunningTime"))));
//        DesktopFlows.ASMlogin(getData("AradPassword"));
//        DesktopFlows.setting_PipeBurstAlarm(getData("UnreachedThresholdValue"), getData("AFT"));
//    }
}
