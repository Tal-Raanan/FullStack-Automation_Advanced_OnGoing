package pageObjects.aradSmart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//Class Name: MainPage
//Description: This class captures objects which are located at the main page
public class AradLoginPage {

    //Main Elements
    @FindBy(how = How.CLASS_NAME, using = "PasswordBox")
    public WebElement txtbox_password;

    @FindBy(how = How.XPATH, using = "//*[@ClassName=\"LoginUserControl\"]/*[8]")
    public WebElement btn_login;

    @FindBy(how = How.NAME, using = "Please Login")
    public WebElement hdr_pleaseLogin;
}



