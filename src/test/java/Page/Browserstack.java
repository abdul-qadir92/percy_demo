package Page;

import Helper.DriverClass;
import io.percy.selenium.Percy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browserstack {
    public WebDriver driver;
    public WebDriverWait wait;
    //public Percy percy;

    public Browserstack(WebDriver ldriver){
        this.driver = ldriver;
        wait = new WebDriverWait(driver,30);
    }

    public void getProdSnap(String url){
        driver.get(url);
        DriverClass.percy.snapshot("snap_home");
        driver.navigate().to(url+"pricing");
        DriverClass.percy.snapshot("snap_price");
        driver.navigate().to(url+"integrations/automate");
        DriverClass.percy.snapshot("snap_automate");
        driver.navigate().to(url+"docs");
        DriverClass.percy.snapshot("snap_docs");
    }

}
