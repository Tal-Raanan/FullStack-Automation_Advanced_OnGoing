package utilities;

import com.fazecast.jSerialComm.SerialPort;
import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.asm.AsmAdvancedPage;
import pageObjects.asm.AsmAlarmPage;
import pageObjects.asm.AsmLoginPage;
import pageObjects.asm.AsmMainPage;

import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Base {
    //Abstract objects - init via CommonOps
        //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;
//    protected static Logger logger;
    protected static Socket socket;
    protected static SerialPort serialPort;

        //Web
    protected static WebDriver driver;

        //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

        //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

        //Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;


    //Page Objects - Web - init via ManagePages
    protected static pageObjects.grafana.LoginPage grafanaLogin;
    protected static pageObjects.grafana.MainPage grafanaMain;
    protected static pageObjects.grafana.LeftMenuPage grafanaLeftMenu;
    protected static pageObjects.grafana.ServerAdminMenuPage grafanaServerAdmin;
    protected static pageObjects.grafana.ServerAdminMainPage grafanaServerAdminMain;
    protected static pageObjects.grafana.AddNewUserPage grafanaAddNewUser;
    protected static pageObjects.grafana.UserInformationPage grafanaUserInformation;

    //Page Objects - Mobile - init via ManagePages
    protected static pageObjects.mortgage.MainPage mortgageMain;

    //Page Objects - Electron
    protected static pageObjects.todo.MainPage todoMain;

    //Page Objects - Desktop
    protected static AsmLoginPage asmLoginPage;
    protected static AsmMainPage asmMainPage;
    protected static AsmAdvancedPage asmAdvancedPage;
    protected static AsmAlarmPage asmAlarmPage;

    //Logger
    protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(utilities.Base.class.getName());
    protected static void fatal (String msg) {
            logger.fatal(msg);
        }
    protected static void error (String msg) {
        logger.error(msg);
    }
    protected static void warn (String msg) {
        logger.warn(msg);
    }
    protected static void info (String msg) {
            logger.info(msg);
        }
    protected static void debug (String msg) {
            logger.debug(msg);
        }
    protected static void trace (String msg) {
            logger.trace(msg);
        }
    }

