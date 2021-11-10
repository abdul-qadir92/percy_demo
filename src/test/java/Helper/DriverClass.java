package Helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.percy.selenium.Percy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class DriverClass {
    public WebDriver driver;
    public Properties config;
    BufferedReader reader;
    String browser;
    public static Percy percy;


    @BeforeMethod
    public void launch() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader("./config/config.properties"));
        config = new Properties();
        try {
            config.load(reader);
            reader.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        browser = config.getProperty("browser");

        if(browser.contains("Chrome")){
            //For Chrome Browser
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.contains("Firefox")){
            //For Firefox Browser
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browser.contains("Safari")){
            //For Safari Browser
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        //WebDriverWait wait = new WebDriverWait(driver,30);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        percy = new Percy(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        System.out.println("tearDown : "+driver);
    }
}
