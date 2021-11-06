package Page;

import Helper.DriverClass;
import io.percy.selenium.Percy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import javax.imageio.stream.IIOByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Browserstack {
    public WebDriver driver;
    public WebDriverWait wait;
    //public Percy percy;
    JavascriptExecutor jse;

    public Browserstack(WebDriver ldriver){
        this.driver = ldriver;
        wait = new WebDriverWait(driver,30);
        jse = (JavascriptExecutor) driver;
    }

    public void getProdSnap(String url) throws InterruptedException {
        driver.get(url);//img[@alt='Integration of Browserstack']
        WebElement srcload = driver.findElement(By.xpath("//*[starts-with(text(),'Just played around')]"));
        jse.executeScript("arguments[0].scrollIntoView();",srcload);
        Thread.sleep(2000);
        WebElement lazyui = driver.findElement(By.xpath("//p[@class='integration-section__description']"));
        jse.executeScript("arguments[0].scrollIntoView();",lazyui);
        Thread.sleep(2000);
        /*List<Integer> widhts = new ArrayList<Integer>();
        widhts.add(375);widhts.add(480);widhts.add(720);widhts.add(1280);widhts.add(1440);widhts.add(1920);
        DriverClass.percy.snapshot("snap_home",widhts,1024,false,"div#testimonials-slider img.b-lazy.b-lazy-loaded");
        */DriverClass.percy.snapshot("snap_home");
        driver.get(url+"pricing");
        DriverClass.percy.snapshot("snap_price");
        driver.get(url+"integrations/automate");
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        DriverClass.percy.snapshot("snap_automate");
        driver.get(url+"docs");
        DriverClass.percy.snapshot("snap_docs");
    }

}
