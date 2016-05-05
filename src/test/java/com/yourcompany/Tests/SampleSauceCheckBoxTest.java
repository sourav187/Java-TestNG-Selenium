package com.yourcompany.Tests;

import com.yourcompany.Pages.GuineaPigPage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by mehmetgerceker on 12/7/15.
 */

public class SampleSauceCheckBoxTest extends SampleSauceTestBase {

    /**
     * Runs a simple test verifying the checked checkbox state
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyUncheckedCheckBoxInputTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
		if((browser == "chrome") || (browser == "internet explorer")){
			System.out.println("Passing test because of invalid browser: " + browser);
            throw new SkipException("Testing skip.");

		}
        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        //Navigate to the page
        driver.get("https://saucelabs.com/test/guinea-pig");

        // get page object
        GuineaPigPage page = GuineaPigPage.getPage(driver);

        /*
         checkUncheckedCheckBox is an exposed "service",
             which interacts with the email input field element by sending text to it.
        */
        page.checkUncheckedCheckBox();

        /*
         Assertions should be part of test and not part of Page object.
         Each test should be verifying one piece of functionality (atomic testing)
        */
        assertEquals(page.getUncheckedCheckBoxState(), true);

    }

    /**
     * Runs a simple test verifying the checked checkbox state
     *
     * @throws InvalidElementStateException
     */
}