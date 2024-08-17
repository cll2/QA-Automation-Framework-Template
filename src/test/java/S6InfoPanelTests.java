import io.cucumber.java.sl.In;
import org.testng.annotations.Test;
import pages.InfoPanelPage;
import pages.LandingPage;
import pages.LoginPage;

public class S6InfoPanelTests extends BaseTest {
    /*
    Album name and cover should be displayed for a playing song
    Lyrics should be displayed for a playing song
    Artist name should be displayed for a playing song
    Info panel should appear after clicking on 'INFO' button on the music player
    Info panel should hide after clicking on 'INFO'  button on the music player
    User should be able to shuffle order of playing songs on the info panel by album and artist
     */
    @Test
    public void albumNameDisplaysWhileSongPlaying() {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        landingPage.playFirstSongInAllSongs();
        infoPanelPage.clickAlbumTab();
        //infoPanelPage.albumNameIsDisplayed();
    }


}
