package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;
import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    @Step("Click On Element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Update Text Element As Human")
    public static void updateTextHuman(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        for (char ch: text.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch + "");
        }
    }

    @Step("Insert Key")
    public static void insertKey(WebElement elem, Keys value){
        elem.sendKeys(value);
    }

    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("Mouse Hover Element, For Two Elements")
    public static void mouseHover(WebElement elem1, WebElement elem2){
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("Mouse Hover Element, For A Single Element")
    public static void mouseHover(WebElement elem1){
        action.moveToElement(elem1).click().build().perform();
    }


    @Step("Mouse Hover Element, By Coordinates")
    public static void mouseHoverByCoordinates(int x_offset, int y_offset){
//        Actions actionProvider = new Actions(driver);
//        actionProvider.moveByOffset(x_offset, y_offset).click().build().perform();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@LocalizedControlType='title bar']")),0,0);
        actions.moveByOffset(x_offset, y_offset).click().build().perform();
    }


    @Step("Refresh Page")
    public static void refreshPage (){
        driver.navigate().refresh();
    }
}
