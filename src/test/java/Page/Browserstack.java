package Page;

import io.percy.selenium.Percy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browserstack {
    public WebDriver driver;
    public WebDriverWait wait;
    public Percy percy;

    public Browserstack(WebDriver ldriver, Percy lpercy){
        this.driver = ldriver;
        wait = new WebDriverWait(driver,30);
        this.percy = lpercy;
    }

    public void getProdSnap(){
        driver.get("https://www.browserstack.com/");
        percy.snapshot("prodSnap1");
    }

}
