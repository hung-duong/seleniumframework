package com.framework.tests;

import com.framework.webpage.GoogleHomePage;
import com.framework.webpage.SeleniumHomePage;
import org.testng.annotations.Test;

/**
 * Created by hungduong on 5/28/17.
 */
public class TestCases extends BaseClass {

    @Test(description = "This TC will perform launching google.com")
    public void TestMethode1() throws Exception {
        System.out.println("========== Test Started =========");
        //Object for page
        GoogleHomePage page = new GoogleHomePage();

        //Search for Selenium
        page.SearchGoogle(excel.ReadCell("SearchTerms", 1));
        page.clickSeleniumLink();

        //Click the Selenium website, will return selenium website
        SeleniumHomePage selPage = new SeleniumHomePage();

        //Wait for page load
        Thread.sleep(5000);

        selPage.ClickDownload();

        //Navigate to Home page
        selPage.NavigateHome();
    }

    @Test
    public void TestMethode2() {
        System.out.println("Method2");
    }
}
