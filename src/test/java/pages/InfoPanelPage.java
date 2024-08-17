package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class InfoPanelPage extends BasePage {

    public InfoPanelPage (WebDriver givenDriver) {
        super (givenDriver);
    }

    @FindBy(css = ".album-info .name")
    WebElement albumName;
    @FindBy(css = "main >.cover")
    WebElement albumCover;

    @FindBy (css = "button#extraTabAlbum")
    WebElement albumsTab;
    //@FindBy (css = "#extraPanelAlbum>article> h1>span")
    //WebElement albumNameSpan;
    //@FindBy (css = "p.none.text-secondary>span")
    //WebElement lyrics;

    @FindBy (css = "button#extraTabArtist")
    WebElement artistTab;


    public void clickAlbumTab() {
        albumsTab.click();
    }

    public void clickArtistTab() {
        artistTab.click();
    }

    public void albumNameIsDisplayed() {
        WebElement albumNameSpan = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#extraPanelAlbum>article> h1>span")));
        String albumNameSpanText = albumNameSpan.getText();
        Assert.assertFalse(albumNameSpanText.trim().isEmpty());
    }

    public void albumCoverIsDisplayed() {
        Assert.assertTrue(albumCover.isDisplayed());
    }

    public void lyricsAreDisplayed() {
        WebElement lyrics = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.none.text-secondary>span")));
        String lyricsSpanText = lyrics.getText();
        Assert.assertFalse(lyricsSpanText.trim().isEmpty());
    }

    public void artistNameIsDisplayed() {
        WebElement artistName = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#extraPanelArtist > article > h1 > span")));
        String artistNameSpanText = artistName.getText();
        Assert.assertFalse(artistNameSpanText.trim().isEmpty());
    }

    @FindBy (css = "button.control.text-uppercase.active")
    WebElement infoButtonPanelDisplayed;
    @FindBy (css = "button.control.text-uppercase")
    WebElement infoButtonPanelHidden;

    public void clickInfoToHidePanel() {
        infoButtonPanelDisplayed.click();
    }

    public void clickInfoToUnhidePanel() {
        infoButtonPanelHidden.click();
    }

    //@FindBy (css = "#extra.text-secondary")
    //WebElement hiddenInfoPanel;
    //@FindBy (css = ".text-secondary.showing")
    //WebElement unhiddenInfoPanel;
    public void infoPanelIsHidden() {
        Boolean infoPanelIsInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#extra.text-secondary.showing")));
        Assert.assertTrue(infoPanelIsInvisible);
    }

    public void infoPanelIsUnHidden() {
        WebElement unhiddenInfoPanel = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#extra.text-secondary.showing")));
        Assert.assertTrue(unhiddenInfoPanel.isDisplayed());
    }



}
