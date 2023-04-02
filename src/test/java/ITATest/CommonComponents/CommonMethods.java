package ITATest.CommonComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods {

    WebDriver driver;

    public CommonMethods(WebDriver driver){
        this.driver = driver;
    }

    public String getBrowserTitle(){
        return driver.getTitle();
    }


    public void waitForElementoAppear(WebElement elmToAppear){

        //explicit wait
//        WebElement elmToAppear = driver.findElement(elm);
//        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(elmToAppear));

    }


}
