import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

public class RegressionTests extends BaseTest {

    //Current Queue | The Page Should Be Empty After Clicking On 'Clear' Button
    @Test
    public void clearQueue () {
        LoginPage loginPage = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        landingPage.playFirstSongInAllSongs();
        landingPage.clickCurrentQueue();
        landingPage.clickClear();
        landingPage.noSongsQueuedIsDisplayed();
        landingPage.shuffleSongsFromClearedQueue();
    }
}
