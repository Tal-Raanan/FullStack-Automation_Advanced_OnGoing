package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//Class Name: LoginPage
//Description: This class captures objects which are located at the login page
public class LoginPage {
    @FindBy(how = How.NAME, using = "user")
    public WebElement txt_username;

    @FindBy(how = How.NAME, using = "password")
    public WebElement txt_password;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div[3]/div/div[2]/div/div/form/button/span")
    public WebElement btn_login;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div[3]/div/div[2]/div/form/div[3]/div[2]/button/span")
    public WebElement btn_skip;

}
