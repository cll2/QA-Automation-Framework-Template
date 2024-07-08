import pages.LandingPage;
import pages.LoginPage;
import org.testng.annotations.Test;

public class PlayListTests extends BaseTest {

    @Test
    public void createANewPlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        //loginPage.isUserLoggedIn();
        System.out.println("Logged In Successfully");
        landingPage.clickAddPlaylistPlusButton();
        landingPage.clickAddNewPlaylistButton();
        landingPage.nameNewPlayList("Sprint2test");

    }
}
