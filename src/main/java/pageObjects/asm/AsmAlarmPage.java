package pageObjects.asm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AsmAlarmPage {

    @FindBy(how = How.NAME, using = "Alarm Thresholds")
    public WebElement btn_alarmThresholds;

    //Configuration
    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[1]/*[3]")
    public WebElement txtbox_actQuantity;

    //FlowRate Alarm
    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[2]/*[3]")
    public WebElement txtbox_FRAThershold;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[2]/*[8]")
    public WebElement txtbox_FRAstartDuration;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[2]/*[12]")
    public WebElement txtbox_FRAendDuration;

    //Leakage
    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[3]/*[3]")
    public WebElement txtbox_LAThershold;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[3]/*[7]")
    public WebElement txtbox_LAAvaregeFT;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[3]/*[11]")
    public WebElement txtbox_LAStartduration;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[3]/*[18]")
    public WebElement drpDown_LAEndDuration;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[3]/*[18]/*[1]")
    public WebElement drpDown_LA15Minutes;


    //Pipe Burst
    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[4]/*[3]")
    public WebElement txtbox_PBThershold;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[4]/*[7]")
    public WebElement txtbox_PBAvaregeFT;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[4]/*[14]")
    public WebElement drpDown_PBStartduration;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[4]/*[14]/*[1]")
    public WebElement drpDown_PBStart10Minutes;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[4]/*[19]")
    public WebElement drpDown_PBEndDuration;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[4]/*[19]/*[5]")
    public WebElement drpDown_PBEnd10Minutes;

    //Reverse Flow
    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[5]/*[7]")
    public WebElement txtbox_RFstartAlarm;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[5]/*[11]")
    public WebElement txtbox_RFAvaregeFT;

    //Dry Pipe
    //Reverse Flow
    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[6]/*[7]")
    public WebElement txtbox_DPStartDuration;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"AlarmThresholdsUserControl\"]/*[6]/*[11]")
    public WebElement txtbox_DPEndDuration;
}
