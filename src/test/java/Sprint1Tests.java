import Pages.LandingPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class Sprint1Tests extends BaseTest {
    //Story: Create a new playlist

    @Test
    public void createANewPlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "KoelQ@!!");
        //loginPage.isUserLoggedIn();
        System.out.println("Logged In Successfully");
        landingPage.clickAddPlaylistPlusButton();
    }
}


