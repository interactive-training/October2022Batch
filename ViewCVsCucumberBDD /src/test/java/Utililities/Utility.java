package Utililities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

public class Utility {
    WebDriver driver;

    public Utility(WebDriver driver){
        this.driver=driver;
    }

    public static String getScreenShotFilePath(WebDriver driver, String testName) throws IOException {

        TakesScreenshot sc = (TakesScreenshot) driver;
        File source = sc.getScreenshotAs(OutputType.FILE);
        String sourcePath;
        testName = testName.replace(" ","_");
        testName = testName + getCurrentDateTime();

        sourcePath = System.getProperty("user.dir") + "/target/Reports/Screenshots/" + testName + ".png";
        File target = new File(sourcePath);
        FileUtils.copyFile(source,target);
        return sourcePath;
    }

    // getting Base64 attachment
    public static String getScreenShotAsBase64(WebDriver driver, String testName) throws IOException {

        TakesScreenshot sc = (TakesScreenshot) driver;
        return sc.getScreenshotAs(OutputType.BASE64);
    }
    public static String getCurrentDateTime(){
        return LocalDateTime.now().getYear()+"_"+
                LocalDateTime.now().getMonth()+"_"+
                LocalDateTime.now().getDayOfMonth()+"_"+
                LocalDateTime.now().getDayOfWeek()+"_"+
                LocalDateTime.now().getHour()+"_"+
                LocalDateTime.now().getMinute()+"_"+
                LocalDateTime.now().getSecond();
    }

    public static void showMessageDialog(String infoMessage)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: Title", JOptionPane.INFORMATION_MESSAGE);
    }

    public void SwitchWindowToChild(){                     //?
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
    }

}
