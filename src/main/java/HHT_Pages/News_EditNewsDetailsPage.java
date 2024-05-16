package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class News_EditNewsDetailsPage {
    public static final Logger log = LogManager.getLogger(News_EditNewsDetailsPage.class.getName());
    WebDriver driver;

    public News_EditNewsDetailsPage(WebDriver driver){
        this.driver = driver;
    }
// By variables

// Methods
    public String verifyEditNewsDetailsHeader(){
        return driver.findElement(By.xpath("(//div[@id='bar'])")).getText();
    }

    public void editNews(String Editfield, String EditInfo){
        //driver.findElement(By.xpath("((//table/tbody/tr[1]/td[2])[1]/input[@name='title'])")).clear();

        if (Editfield.equals("News Title")) {
            driver.findElement(By.xpath("((//table/tbody/tr[1]/td[2])[1]/input[@name='title'])")).clear();
            driver.findElement(By.xpath("((//table/tbody/tr[1]/td[2])[1]/input[@name='title'])")).sendKeys(EditInfo);
        } else if (Editfield.equals("News Artile/Content")) {
            WebElement Frame1 = driver.findElement(By.xpath("//iframe[@id='article___Frame']"));
            driver.switchTo().frame(Frame1);
            int size1 = driver.findElements(By.tagName("iframe")).size();
            System.out.println("total frames are:" + size1);
            WebElement Frame2 = driver.findElement(By.xpath("//td[@id='xEditingArea']//iframe"));
            driver.switchTo().frame(Frame2);
            driver.findElement(By.xpath("/html/body/p")).clear();
            driver.findElement(By.xpath("/html/body/p")).sendKeys(EditInfo);
            driver.switchTo().defaultContent();
        }
    }

    public void clickSubmitButton(){
        //driver.findElement(By.xpath("//input[@type='submit']")).click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;// Login Button
        jse.executeScript("document.querySelector(\"input[value='Submit']\").click();");
        System.out.println("Clicked Submit");
        log.info("Clicked Submit");

    }
}
