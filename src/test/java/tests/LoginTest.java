package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;

public class LoginTest extends BaseTest {

    @Test
    public void completeLoginFlowTest() throws InterruptedException {

        System.out.println("===== Login Test Started =====");

        HomePage home = new HomePage(driver);
        home.openWebsite();
        home.clickMenu();

        SignInPage signIn = home.clickLogin();

        // Enter mobile & click sign in
        signIn.enterMobile("9876543210");
        signIn.clickSignIn();

        // Wait for OTP input + enter OTP (10 sec wait)
        signIn.enterOtp("123456");  // Replace with real OTP if needed
        signIn.clickVerifyOtp();

        Thread.sleep(5000); // just to observe
    }
}