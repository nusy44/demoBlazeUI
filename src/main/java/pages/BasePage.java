package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class BasePage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver wd) {
        driver = wd;
    }


    public static void pause(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickWait(WebElement element, int time){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.elementToBeClickable(element)).click();
        }catch (TimeoutException e){
            e.printStackTrace();
        }
    }

    public static boolean textTobePresentElement(WebElement element, String text, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            return wait.until(ExpectedConditions.textToBePresentInElement(element, text));

        }catch (TimeoutException e){
            return false;
        }
    }
}
