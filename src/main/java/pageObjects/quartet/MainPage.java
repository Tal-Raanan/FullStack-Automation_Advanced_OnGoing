package pageObjects.quartet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//Class Name: MainPage
//Description: This class captures objects which are located at the main page
public class MainPage {

    //Main Elements
    @FindBy(how = How.NAME, using = "BLE")
    public WebElement dropdown_BLE;

    @FindBy(how = How.NAME, using = "Serial")
    public WebElement dropdown_Serial;

    @FindBy(how = How.NAME, using = "Sonata EU")
    public WebElement dropdown_SonataEU;

    @FindBy(how = How.NAME, using = "80:E1:26:1B:25:75")
    public WebElement dropdown_Mac;

    @FindBy(how = How.NAME, using = "Connect")
    public WebElement btn_Connect;

    @FindBy(how = How.NAME, using = "Disconnect")
    public WebElement btn_Disconnect;

    @FindBy(how = How.NAME, using = "Send")
    public WebElement btn_send;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='_bufferTextBox']")
    public WebElement txtbox_buffer;


    //Commands section
    @FindBy(how = How.NAME, using = "HWTP_SI_GET_FW_VERSION")
    public WebElement btn_ID02getFWVersion;

    @FindBy(how = How.NAME, using = "HWTP_SI_GET_HW_VERSION")
    public WebElement btn_ID03getHWVersion;

    @FindBy(how = How.NAME, using = "MSI_GETIDINFO")
    public WebElement btn_ID04getIdInfo;

}
