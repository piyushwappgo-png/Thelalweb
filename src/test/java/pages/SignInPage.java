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
    private By signInBtn = By.xpath("//button[contains(text(),'Sign')]"); // Sign In button
    private By otpInput = By.xpath("//input[@type='text' and @maxlength='6']"); // OTP input field
    private By verifyOtpBtn = By.xpath("//button[normalize-space()='Verify OTP']"); // Verify OTP button

    // Step 1: Enter Mobile
    public void enterMobile(String number) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileInput));
        field.clear();
        field.sendKeys(number);
        System.out.println("✅ Mobile Entered");
    }

    // Step 2: Click Sign In
    public void clickSignIn() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
        btn.click();
        System.out.println("✅ Sign In Clicked");
    }

    // Step 3: Enter OTP
    public void enterOtp(String otp) {
        // Wait max 10 seconds for OTP input to appear
        WebElement otpField = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(otpInput));
        otpField.clear();
        otpField.sendKeys(otp);
        System.out.println("✅ OTP Entered");
    }

    // Step 4: Click Verify OTP
    public void clickVerifyOtp() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(verifyOtpBtn));
        btn.click();
        System.out.println("✅ Verify OTP Clicked");
    }
}