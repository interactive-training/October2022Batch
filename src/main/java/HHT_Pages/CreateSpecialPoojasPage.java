package HHT_Pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class CreateSpecialPoojasPage{
  // public static final Logger log = LogManager.getLogger(CreateSpecialPoojasPage.class.getName());
    WebDriver driver;
    public CreateSpecialPoojasPage(WebDriver driver){
        this.driver=driver;
    }

    // By Variables
  By PoojaTitle =   (By.xpath("//tr[2]/td[2]/select"));
    By PoojaServiceSection =(By.xpath("//tr[2]/td[2]/select/./option[2]"));
        By PoojaType = (By.name("pooja_type"));
       By SelectPoojaOptions = (By.xpath("//tr[3]/td[2]/select/option/."));
        By PoojaStartDate = (By.name("strt_date"));
        By PoojaEndDate = (By.name("end_date"));
         By PoojaFrequency = (By.name("pooja_freq"));
        By SelectPoojaFrequency =  (By.xpath("//tr[6]/td[2]/select/./option/."));
        By PoojaTimeDuration = (By.name("etime"));
        By PoojaCutOffTime = (By.name("pooja_cut_off"));
         By PoojaAmountIn£ = (By.name("price1"));
        By PoojaLocation  = (By.name("eloc"));
        By PoojaCountry = (By.name("country"));
        By SelectPoojaCountryOptions = (By.xpath("//tr[11]/td[2]/select/option[224]"));
        By outerframe = (By.id("article___Frame"));
       By innerframe = (By.xpath("//td[@id='xEditingArea']/iframe"));
       By TextInFrame = (By.xpath("html/body"));

//       ************* Create poojas at backend *************
public void CreateSpecialPoojasPage(DataTable dataTable) {
    List<Map<String, String>> data = dataTable.asMaps();
    // Passing information to the text fields through feature
    driver.findElement(PoojaTitle).sendKeys(data.get(0).get("PoojaTitle"));
    driver.findElement(PoojaServiceSection).sendKeys(data.get(0).get("PoojaServiceSection"));
    driver.findElement(PoojaType).sendKeys(data.get(0).get("PoojaType"));
    driver.findElement(SelectPoojaOptions).sendKeys(data.get(0).get("SelectPoojaOptions"));
    driver.findElement(PoojaStartDate).sendKeys(data.get(0).get("PoojaStartdate"));
    driver.findElement(PoojaEndDate).sendKeys(data.get(0).get("PoojaEnddate"));
    driver.findElement(PoojaFrequency).sendKeys(data.get(0).get("PoojaFrequency"));
    driver.findElement(SelectPoojaFrequency).sendKeys(data.get(0).get("SelectPoojaFerquency"));
    driver.findElement(PoojaTimeDuration).sendKeys(data.get(0).get("PoojaTimeDuration"));
    driver.findElement(PoojaCutOffTime).sendKeys(data.get(0).get("PoojaCutOffTime"));
    driver.findElement(PoojaAmountIn£).sendKeys(data.get(0).get("PoojaAmountIn"));
    driver.findElement(PoojaLocation).sendKeys(data.get(0).get("PoojaLocation"));
    driver.findElement(PoojaCountry).sendKeys(data.get(0).get("PoojaCountry"));
    driver.findElement(SelectPoojaCountryOptions).sendKeys(data.get(0).get("SelectPoojaCountryOptions"));

    // Passing information to the iframe
    WebElement outerIframe = driver.findElement(outerframe);
    driver.switchTo().frame(outerIframe);
    WebElement innerIframe = driver.findElement(innerframe);
    driver.switchTo().frame(innerIframe);
    driver.findElement(TextInFrame).sendKeys(data.get(0).get("TextInFrame"));
    driver.switchTo().defaultContent();

}
    public void clicksOnSubmitButton() {
        driver.findElement(By.name("save")).click();
       // log.info("clicked on submit button");
        System.out.println("clicked on submit");
    }
}
