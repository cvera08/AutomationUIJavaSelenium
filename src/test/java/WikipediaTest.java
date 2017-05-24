import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.WikipediaPage;
import utils.CommonValidations;
import utils.Driver;

import java.net.MalformedURLException;

/**
 * Created by carlosvera on 5/11/17.
 */
public class WikipediaTest {

    WebDriver webDriver;

    @BeforeTest
    public void setup() {
        Driver browser = new Driver();
        webDriver = browser.start(Driver.Browser.FIREFOX); //Using Firefox as Browser
    }

    @Test
    public void wikipediaTest() throws MalformedURLException {
        WikipediaPage wikipediaPage = new WikipediaPage(); //Setting title and url domain

        try {
            webDriver.get(wikipediaPage.getURL());
            wikipediaPage.changeToEnglishLanguage(webDriver);

            CommonValidations.verifyTitleOfThePage(webDriver, "Wikipedia, the free encyclopedia");
        } catch (Exception e) { //if test fails print the exception & keep open
            e.printStackTrace();
        } finally {
            webDriver.quit(); //Close the browser at the end of the test  //webDriver.close(); --> doesn't work in firefox
        }

    }


}
