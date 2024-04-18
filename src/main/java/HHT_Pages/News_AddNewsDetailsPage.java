package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class News_AddNewsDetailsPage {
    public static final Logger log = LogManager.getLogger(News_AddNewsDetailsPage.class.getName());

    WebDriver driver;
    public News_AddNewsDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    // By Variables
    public Boolean verifyAddNewsDetailsHeader(){
        return driver.findElement(By.xpath("//h1[text()='Add News Details']")).isDisplayed();
    }
    public void addNews(String NewsTitle, String NewsContent){
        WebElement NT = driver.findElement(By.name("title"));
        NT.sendKeys(NewsTitle);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("the no.of iframes are:" + size);
        WebElement Frame1 = driver.findElement(By.xpath("//iframe[@id='article___Frame']"));
        driver.switchTo().frame(Frame1);
        int size1 = driver.findElements(By.tagName("iframe")).size();
        System.out.println("total frames are:" + size1);
        WebElement Frame2 = driver.findElement(By.xpath("//td[@id='xEditingArea']//iframe"));
        driver.switchTo().frame(Frame2);
        driver.findElement(By.xpath("/html/body")).sendKeys(NewsContent);
        driver.switchTo().defaultContent();
        System.out.println("Entered news information.");
    }
    public void clickSubmitButton(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;// Login Button
        jse.executeScript("document.querySelector(\"input[value='Submit']\").click();");
        System.out.println("Clicked Submit");
    }


}
