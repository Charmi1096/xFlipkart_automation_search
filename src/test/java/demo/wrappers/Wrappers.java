package demo.wrappers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
     public static boolean clickOnElement(WebElement element, WebDriver driver){
        if(element.isDisplayed()){
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true)", element);
                element.click();
                Thread.sleep(3000);
                return  true;
                
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
