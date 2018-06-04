/*
 * HSR Hochschule fuer Technik Rapperswil
 * Master of Advanced Studies in Software Engineering
 * Module Software Testing
 *
 * Thomas Briner, thomas.briner@gmail.com
 */
package ch.testing.selenium.weekenddiscount.tests;

import ch.testing.selenium.weekenddiscount.Constants;
import ch.testing.selenium.weekenddiscount.extension.ScreenshotOnFailureExtension;
import ch.testing.selenium.weekenddiscount.extension.WebDriverKeeper;
import ch.testing.selenium.weekenddiscount.pageobjects.CartPage;
import ch.testing.selenium.weekenddiscount.pageobjects.HomePage;
import ch.testing.selenium.weekenddiscount.pageobjects.HotSaucesPage;
import ch.testing.selenium.weekenddiscount.pageobjects.SauceDetailPage;
import ch.testing.selenium.weekenddiscount.util.DBUtil;
import ch.testing.selenium.weekenddiscount.util.DateFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Date;

/**
 * The Class HeatClinicAcceptanceTests. In this class the acceptance Tests for
 * the weekend discount features are implemented.
 */
@ExtendWith(ScreenshotOnFailureExtension.class)
public class WeekendDiscountAcceptanceTests implements Constants {

    private static final Log LOG = LogFactory
            .getLog(WeekendDiscountAcceptanceTests.class);

    //	@Rule
    public ScreenshotOnFailureExtension screenshot = new ScreenshotOnFailureExtension();

    private WebDriver driver;

    @BeforeEach
    public void setup() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        WebDriverKeeper.getInstance().setDriver(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testWeekendDiscountEnabled() {
        // TODO: Implement this
        Assertions.fail("Implement Testcase");


    }

    @Test
    public void testWeekendDiscountDisabled() {
        // TODO: Implement this
        Assertions.fail("Implement Testcase");

    }

}