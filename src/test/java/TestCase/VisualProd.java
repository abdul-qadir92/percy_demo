package TestCase;

import Helper.DriverClass;
import Page.Browserstack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class VisualProd extends DriverClass {

    @Test
    public void snapProd() {
        Browserstack bs = PageFactory.initElements(driver, Browserstack.class);
        bs.getProdSnap();
    }




}
