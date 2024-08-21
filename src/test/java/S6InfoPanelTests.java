import io.cucumber.java.jv.Lan;
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
        infoPanelPage.albumNameIsDisplayed();
    }

    @Test
    public void albumCoverDisplaysWhileSongPlaying() {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        landingPage.playFirstSongInAllSongs();
        infoPanelPage.clickAlbumTab();
        infoPanelPage.albumCoverIsDisplayed();
    }

    @Test
    public void lyricsDisplayWhileSongPlaying() {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        landingPage.playFirstSongInAllSongs();
        //lyrics tab is the default tab already opened in info panel
        infoPanelPage.lyricsAreDisplayed();
    }

    @Test
    public void artistNameDisplaysWhileSongPlaying() {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        landingPage.playFirstSongInAllSongs();
        infoPanelPage.clickArtistTab();
        infoPanelPage.artistNameIsDisplayed();
    }

    @Test
    public void hideInfoPanel() {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        infoPanelPage.clickInfoToHidePanel();
        infoPanelPage.infoPanelIsHidden();
    }

    @Test
    public void unhideInfoPanel() {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        infoPanelPage.clickInfoToHidePanel();
        infoPanelPage.clickInfoToUnhidePanel();
        infoPanelPage.infoPanelIsUnHidden();
    }

    @Test
    public void shuffleByAlbum() {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        landingPage.playFirstSongInAllSongs();
        infoPanelPage.clickAlbumTab();
        infoPanelPage.clickShuffleAlbums();
        landingPage.songIsPlaying();
    }

    @Test
    public void shuffleByArtist() {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        landingPage.playFirstSongInAllSongs();
        infoPanelPage.clickArtistTab();
        infoPanelPage.clickShuffleArtists();
        landingPage.songIsPlaying();
        landingPage.songsAreShuffledByArtist();
    }


}
