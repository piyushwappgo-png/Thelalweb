package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SignInPage {

    WebDriver driver;
    WebDriverWait wait;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    private By mobileInput = By.xpath("//input[@maxlength='10']");
    private By signInBtn = By.xpath("//button[normalize-space(text())='Sign in']");

    public void enterMobile(String number) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileInput));
        field.clear();
        field.sendKeys(number);
        System.out.println("✅ Mobile Entered");
    }

    public void clickSignIn() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
        btn.click();
        System.out.println("✅ Sign In Clicked");
    }
}