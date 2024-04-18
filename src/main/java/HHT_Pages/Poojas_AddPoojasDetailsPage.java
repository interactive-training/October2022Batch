package HHT_Pages;

import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;

public class Poojas_AddPoojasDetailsPage {
    public static final Logger log = LogManager.getLogger(Poojas_AddPoojasDetailsPage.class.getName());
    WebDriver driver;

    // Constructor
    public Poojas_AddPoojasDetailsPage(WebDriver driver){
        this.driver = driver;
    }
// By variables

    public Boolean verifyAddPoojaDetailsHeader(){
        return driver.findElement(By.xpath("//div[@id='bar']/h1")).isDisplayed();
    }

    public void addPoojaDetails(String PoojaServicesSection,String PoojaTitle,DataTable dataTable){
        List<Map<String, String>> data = dataTable.asMaps();
            // Passing information to the text fields through feature
        driver.findElement(By.name("title")).sendKeys(PoojaTitle);

            // Selecting Regular(default) or Special Poojas
        //String poojaServicesSection = ;
        Actions action = new Actions(driver);
        WebElement elm = driver.findElement(By.name("pooja_categ"));
        action.moveToElement(elm).click();
        driver.findElement(By.xpath("//tr[2]/td[2]/select")).click();
        if(PoojaServicesSection.equalsIgnoreCase("Special Poojas")){
            driver.findElement(By.xpath("//tr[2]/td[2]/select/./option[2]")).click();
        }
//        else {
//            driver.findElement(By.xpath("//tr[2]/td[2]/select/./option[1]")).click();
//        }
        // Passing the Pooja Type
        driver.findElement(By.name("pooja_type")).click();
        String poojaType = data.get(0).get("PoojaType");
        if (poojaType.equalsIgnoreCase("Thoram")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[1]")).click();
        } else if (poojaType.equalsIgnoreCase("Car Puja")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[2]")).click();
        }else if (poojaType.equalsIgnoreCase("Annual Pujas")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[3]")).click();
        }else if (poojaType.equalsIgnoreCase("Pradhana Sevas")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[4]")).click();
        }else if (poojaType.equalsIgnoreCase("Vadamala Archana")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[5]")).click();
        }else if (poojaType.equalsIgnoreCase("Antharalaya Darshan")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[6]")).click();
        }else if (poojaType.equalsIgnoreCase("GENERAL SEVAS")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[7]")).click();
        }else if (poojaType.equalsIgnoreCase("NAVAGRAHA SEVAS")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[8]")).click();
        }else if (poojaType.equalsIgnoreCase("SARVA DOSHAHARA SHIVA SEVAS")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[9]")).click();
        }else if (poojaType.equalsIgnoreCase("SACHCHIDANANDA GANAPATI • SANKASHTA HARA CHATHURTHI SEVAS")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[10]")).click();
        }else if (poojaType.equalsIgnoreCase("MARAKATA SUBRAHMANYA SEVAS")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[11]")).click();
        }else if (poojaType.equalsIgnoreCase("DHANVANTARI SEVAS")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[12]")).click();
        }else if (poojaType.equalsIgnoreCase("PADMAVATHI DEVI SEVAS")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[13]")).click();
        }else if (poojaType.equalsIgnoreCase("KARYA SIDDHI HANUMAN SEVAS")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[14]")).click();
        }else if (poojaType.equalsIgnoreCase("SRI DATTA VENKATESHWARA SEVAS")) {
            driver.findElement(By.xpath("//tr[3]/td[2]/select/option[15]")).click();
        }
        // Passing the other fields
        driver.findElement(By.name("strt_date")).sendKeys(data.get(0).get("PoojaStartDate"));
        driver.findElement(By.name("end_date")).sendKeys(data.get(0).get("PoojaEndDate"));

        //Passing the Pooja Frequency
        String poojaFrequency = data.get(0).get("PoojaFrequency");
        driver.findElement(By.name("pooja_freq")).click();
        if (poojaFrequency.equalsIgnoreCase("Daily")) {
            driver.findElement(By.xpath("//tr[6]/td[2]/select/./option[1]")).click();
        } else if (poojaFrequency.equalsIgnoreCase("Weekly")) {
            driver.findElement(By.xpath("//tr[6]/td[2]/select/./option[2]")).click();
        }else if (poojaFrequency.equalsIgnoreCase("Monthly")) {
            driver.findElement(By.xpath("//tr[6]/td[2]/select/./option[3]")).click();
        }else if (poojaFrequency.equalsIgnoreCase("Yearly")) {
            driver.findElement(By.xpath("//tr[6]/td[2]/select/./option[4]")).click();
        }
        // Passing the other fields
        driver.findElement(By.name("etime")).sendKeys(data.get(0).get("PoojaTimeDuration"));
        driver.findElement(By.name("pooja_cut_off")).sendKeys(data.get(0).get("PoojaCutOffTime"));
        driver.findElement(By.name("price1")).sendKeys(data.get(0).get("PoojaAmount"));
        driver.findElement(By.name("eloc")).sendKeys(data.get(0).get("PoojaLocation"));
        driver.findElement(By.name("country")).click();

        //Country kept the default option
        driver.findElement(By.xpath("//tr[11]/td[2]/select/option[224]")).click();
        System.out.println("clicked on country");

        //Passing information to iframe
        WebElement outerframe = driver.findElement(By.id("article___Frame"));
        driver.switchTo().frame(outerframe);
        WebElement innerframe = driver.findElement(By.xpath("//td[@id='xEditingArea']/iframe"));
        driver.switchTo().frame(innerframe);
        driver.findElement(By.xpath("html/body")).sendKeys(data.get(0).get("PoojaContent"));
        System.out.println("iframe");

        driver.switchTo().defaultContent();
    }

    public void clickSubmit(){
        driver.findElement(By.name("save")).click();
        System.out.println("clicked on submit");
    }
}
