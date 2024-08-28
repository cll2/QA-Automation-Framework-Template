package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class LandingPage extends BasePage {

    Actions actions = new Actions(driver);
    public LandingPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css = "#userBadge.profile")
    WebElement userBadge;
    //By userBadge = By.cssSelector("#userBadge.profile");
    @FindBy (css = "i.fa.fa-plus-circle.create")
    WebElement playListPlusBtn;
    //By playListPlusBtn = By.cssSelector("i.fa.fa-plus-circle.create");
    @FindBy (css = "[data-testid='playlist-context-menu-create-simple']")
            //failed
            // li[data-testid='playlist-context-menu-create-simple']
    WebElement newPlayListBtn;
    @FindBy (css = "input[name=name]")
    WebElement newPlayListField;
    //@FindBy (css = "section#playlists > ul:last-child")
    //WebElement newPlayListName;
    @FindBy (css = "section[id='playlists']>ul>li")
    List<WebElement> playListChildren;
    @FindBy (css = "section[id='playlists']>ul")
    WebElement parentOfPlayLists;

    @FindBy (css = ".recent li:nth-child(1) .favorite")
    WebElement favoriteBtnFirstRecentlyPlayedSongOnHomePage;
    @FindBy (css = "[href='#!/songs']")
    WebElement allSongsBtn;
    @FindBy (css = "tr.song-item:nth-child(1) td.favorite")
    WebElement firstSongInAllSongsHeartBtn;


    @FindBy (css = "tr.song-item:nth-child(2) td.favorite")
    WebElement secondSongInAllSongs;
    @FindBy (css = "[href='#!/favorites']")
    WebElement favoritesbtn;

    @FindBy (css = " .virtual-scroller.scroller .item-container table.items tr:nth-child(1)")
    WebElement firstSongInFavoritesList;
    @FindBy (css = "input[type = 'search']")
    WebElement searchBar;
    @FindBy (css = "a[href='#!/home']")
    WebElement homeButton;

    public LandingPage clickAddPlaylistPlusButton() {
        wait.until(ExpectedConditions.elementToBeClickable(playListPlusBtn));
        playListPlusBtn.click();
        return this;
    }

    public LandingPage nameNewPlayList(String playListName) {
        wait.until(ExpectedConditions.elementToBeClickable(newPlayListField));
        newPlayListField.sendKeys(playListName);
        newPlayListField.sendKeys(Keys.RETURN);
        return this;
    }
    //for By method
    /*public LandingPage clickAddPlaylistPlusButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(playListPlusBtn));
    }*/

    public LandingPage clickAddNewPlaylistButton() {
        wait.until(ExpectedConditions.elementToBeClickable(newPlayListBtn));
        newPlayListBtn.click();
        return this;
    }

    public LandingPage getFavoritesPlayListListSize() {
        playListChildren.size();
        return this;
    }

    public LandingPage clickHeartFirstRecentlyPlayedSongHomePage() {
        wait.until(ExpectedConditions.elementToBeClickable(favoriteBtnFirstRecentlyPlayedSongOnHomePage));
        favoriteBtnFirstRecentlyPlayedSongOnHomePage.click();
        return this;
    }

    public LandingPage clickAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(allSongsBtn));
        allSongsBtn.click();
        return this;
    }

    public LandingPage likeFirstSongInAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(firstSongInAllSongsHeartBtn));
        firstSongInAllSongsHeartBtn.click();
        return this;
    }

    public LandingPage likeSecondSongInAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(secondSongInAllSongs));
        secondSongInAllSongs.click();
        return this;
    }

    public LandingPage clickFavoritesBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(favoritesbtn));
        favoritesbtn.click();
        return this;
    }

    public boolean firstSongInFavoritesIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(firstSongInAllSongs));
        return firstSongInAllSongs.isDisplayed();
    }

    public LandingPage searchForArtist(String artist) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBar.sendKeys(artist);
        return this;
    }

    public void clickHomeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeButton.click();
    }
    public void selectAnArtistFromHomePage() {
        //not sure how to make this work consistently without knowing what artist will be displayed
        //in a given child element?
    }

    //info panel helper methods
    @FindBy (css = "tr.song-item:nth-child(3)")
    WebElement firstSongInAllSongs;

    public void playFirstSongInAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(allSongsBtn));
        allSongsBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(firstSongInAllSongs));
        actions.doubleClick(firstSongInAllSongs).perform();
    }

    @FindBy (css = ".bars>img")
    WebElement playingSongBars;
    public void songIsPlaying() {
        wait.until(ExpectedConditions.visibilityOf(playingSongBars));
        Assert.assertTrue(playingSongBars.isDisplayed());
    }

    @FindBy (css = "")
    List<WebElement> songsAlbum;

    //get artist of currently playing song
    @FindBy (css = "#queueWrapper > div > div > div.item-container > table > tr.song-item.playing > td.artist")
    WebElement currentlyPlayingSongArtist;

    //get artist of all children in song list
    @FindBy (css = "#queueWrapper > div > div > div.item-container > table > tr > td.artist")
    List<WebElement> artistsOfSongsShuffledByArtist;
    public void songsAreShuffledByArtist() {
        String currentArtist = currentlyPlayingSongArtist.getText().trim();

        for (WebElement artistInList: artistsOfSongsShuffledByArtist) {
            String artistElement = artistInList.getText().trim();
            Assert.assertEquals(currentArtist, artistElement);
        }

    }

    //current queue
    @FindBy (css = "a[href='#!/queue']")
    WebElement currentQueueBtn;
    @FindBy (css = ".btn-clear-queue")
    WebElement clearBtn;
    @FindBy (xpath = "//*[@id='queueWrapper']/div/div/div")
    WebElement noSongsQueuedMessage;
    @FindBy (css = ".start")
    WebElement clearedQueueShuffleSongs;
    @FindBy (css = "tr.song-item:nth-child(10)")
    WebElement tenthSongInShuffleList;

    public void clickCurrentQueue() {
        wait.until(ExpectedConditions.elementToBeClickable(currentQueueBtn));
        currentQueueBtn.click();
    }
    public void clickClear() {
        wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
        clearBtn.click();
    }
    String expectedNoSongsQueuedMessage = "No songs queued. How about shuffling all songs?";
    public void noSongsQueuedIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(noSongsQueuedMessage));
        String noSongsQueuedMessageString = noSongsQueuedMessage.getText().replaceAll("\\s+", " ").trim();
        Assert.assertEquals(noSongsQueuedMessageString, expectedNoSongsQueuedMessage);
    }

    public void shuffleSongsFromClearedQueue() {
        wait.until(ExpectedConditions.elementToBeClickable(clearedQueueShuffleSongs));
        clearedQueueShuffleSongs.click();
        wait.until(ExpectedConditions.elementToBeClickable(tenthSongInShuffleList));
        Assert.assertTrue(tenthSongInShuffleList.isDisplayed());
    }








    //cannot use this with By
    // public WebElement getUserAvatar() {
       // return userBadge;
   // }


}
