import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WikipediaPage;
import utils.Driver;

import java.net.MalformedURLException;

/**
 * Created by carlosvera on 5/11/17.
 */
public class WikipediaTest {

    @Test
    public void wikipediaTest() throws MalformedURLException {
        Driver browser = new Driver();
        WebDriver webDriver = browser.start(Driver.Browser.FIREFOX); //Using Firefox as Browser
        WikipediaPage wikipediaPage = new WikipediaPage(); //Setting title and url domain
        try {
            webDriver.get(wikipediaPage.getURL());
            wikipediaPage.changeToEnglishLanguage(webDriver);
            Assert.assertTrue(wikipediaPage.itsInEnglishVersion(webDriver), "FAIL: Wrong title, the page is not in English.\n");
        } catch (Exception e) { //if test fails print the exception & keep open
            e.printStackTrace();
        } finally {
            webDriver.quit(); //Close the browser at the end of the test  //webDriver.close(); --> doesn't work in firefox
        }
    }

}
