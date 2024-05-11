package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PoojaServicesPage {
    public static final Logger log = LogManager.getLogger(PoojaServicesPage.class.getName());
    WebDriver driver;

    // Constructor
    public PoojaServicesPage(WebDriver driver){
        this.driver = driver;
    }
// By variables

    public Boolean verifyPoojaServicesHeader(){
        return driver.findElement(By.xpath("//div[@class='container']/h2")).isDisplayed();
    }

    public void clickPoojaServicesButton(String PoojaServicesSection ) {
        if (PoojaServicesSection.equalsIgnoreCase("Regular Poojas")) {
            driver.findElement(By.linkText("Regular Poojas")).click();
            System.out.println("Clicked on Regular Poojas");
            log.info("Clicked on Regular Poojas");
        }
        else if (PoojaServicesSection.equalsIgnoreCase("Special Poojas")) {
            driver.findElement(By.linkText("Special Poojas")).click();
            System.out.println("Clicked on Special Poojas");
            log.info("Clicked on Special Poojas");

        }
    }
    // In Regular and Special Poojas the first titles are the same so keeping it here to avoid dulpication of code
    public String verifyPoojaTitle(){
        return driver.findElement(By.xpath("//div[@id='headingTwo']/h4[1]")).getText();
    }

    public boolean verifySponsorLinkOnPoojaPage(){
        return driver.findElement(By.xpath("//a[text()='Sponsor']")).isDisplayed();
    }

}
