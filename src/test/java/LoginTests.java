import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "KoelQ@!!");
        //loginPage.isUserLoggedIn();
        System.out.println("Logged In Successfully");

    }
}
