package pageObjects.asm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AsmAdvancedPage {

    @FindBy(how = How.NAME, using = "Advanced")
    public WebElement btn_advanced;

    //Special Functions
    @FindBy(how = How.NAME, using = "Special Functions")
    public WebElement btn_specialFunctions;

    @FindBy(how = How.NAME, using = "Reset All Alarms")
    public WebElement btn_resetAllAlarms;

    //Totalizer Data
    @FindBy(how = How.NAME, using = "Totalizer Data")
    public WebElement btn_totalizerData;

    @FindBy(how = How.NAME, using = "Reset Accumulation")
    public WebElement btn_resetAccumulation;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"TotalizerDataUserControl\"]/*[4]/*[4]")
    public WebElement txtbox_flow;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"TotalizerDataUserControl\"]/*[4]/*[8]")
    public WebElement txtbox_posVolume;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"TotalizerDataUserControl\"]/*[4]/*[12]")
    public WebElement txtbox_negVolume;
}

