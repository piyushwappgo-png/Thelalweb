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

        signIn.enterMobile("9876543210");
        signIn.clickSignIn();

        Thread.sleep(5000);
    }
}