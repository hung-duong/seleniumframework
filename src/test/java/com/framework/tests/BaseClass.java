package com.framework.tests;

import com.framework.driver.BrowserType;
import com.framework.driver.DriverConfig;
import com.framework.driver.DriverMode;
import com.framework.driver.WebUIDriver;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.ExcelSheetDriver;
import jxl.read.biff.BiffException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by hungduong on 5/28/17.
 */
public class BaseClass {
    protected ConfigReader config;
    protected ExcelSheetDriver excel;

    @BeforeTest(description = "Setup application")
    public void setUpApplication() throws Exception, BiffException {
        config = new ConfigReader();

        excel = new ExcelSheetDriver("/Users/hungduong/Desktop/Projects/Selenium-package/Excel.xls", "Sheet1");
        DriverConfig config = new DriverConfig();
        config.setBrowser(BrowserType.Chrome);
        config.setMode(DriverMode.LOCAL);

        WebUIDriver webUIDriver = new WebUIDriver();
        webUIDriver.setConfig(config);
        webUIDriver.createWebDriver();

        System.out.println("========== Setup Ready =========");
    }

    @AfterTest(description = "Clean application")
    public void closeApplication() {
        WebUIDriver.cleanUp();
    }
}
