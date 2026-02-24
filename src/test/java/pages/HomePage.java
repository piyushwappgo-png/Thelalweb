package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    private By menuIcon = By.xpath("//img[contains(@src,'navbar-menu')]");
    private By loginBtn = By.xpath("//button[normalize-space()='Login / Signup']");

    public void openWebsite() {
        driver.get("https://thelal.co/");
    }

    public void clickMenu() {
        WebElement icon = wait.until(ExpectedConditions.elementToBeClickable(menuIcon));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", icon);
        System.out.println("✅ 4 Dot Clicked");
    }

    public SignInPage clickLogin() throws InterruptedException {

        Thread.sleep(1500);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loginBtn));
        List<WebElement> buttons = driver.findElements(loginBtn);

        for (WebElement btn : buttons) {
            if (btn.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
                System.out.println("✅ Visible Login Button Clicked");
                break;
            }
        }

        wait.until(ExpectedConditions.urlContains("sign-in"));
        System.out.println("✅ Navigated to Sign-In Page");

        return new SignInPage(driver);
    }
}