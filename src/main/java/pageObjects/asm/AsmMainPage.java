package pageObjects.asm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AsmMainPage {
    @FindBy(how = How.NAME, using = "Meter Logs")
    public WebElement btn_meterLogs;

    @FindBy(how = How.NAME, using = "Clear")
    public WebElement btn_clearLogs;

    @FindBy(how = How.NAME, using = "Yes")
    public WebElement btn_yes;

    @FindBy(how = How.NAME, using = "OK")
    public WebElement btn_OK;

    @FindBy(how = How.NAME, using = "Save")
    public WebElement btn_save;

    @FindBy(how = How.NAME, using = "Disconnect")
    public WebElement btn_disconnect;

//    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"LogsUserControl\"]/*[1]/*[3]")
//    public WebElement txtbox_logPath;

    @FindBy(how = How.NAME, using = "Download")
    public WebElement btn_download;

    @FindBy(how = How.NAME, using = "Browse")
    public WebElement btn_browse;

    @FindBy(how = How.NAME, using = "Desktop")
    public WebElement btn_desktop;

//    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"This PC\"]/*[2]/*[1]")
//    public WebElement btn_desktop;

//    @FindBy(how = How.NAME, using = "Logs")
//    public WebElement btn_Logs;

}
