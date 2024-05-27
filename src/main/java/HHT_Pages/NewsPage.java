package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewsPage {
    public static final Logger log = LogManager.getLogger(NewsPage.class.getName());
    WebDriver driver;

    public NewsPage(WebDriver driver){
        this.driver = driver;
    }
    // By variables

    public String verifyNewsTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='news_main'])[1]/p/a"))).getText();
        return message;
        //return driver.findElement(By.xpath("(//div[@class='news_main'])[1]/p/a")).getText();
    }
}
//div[@class='news_main']/p/a