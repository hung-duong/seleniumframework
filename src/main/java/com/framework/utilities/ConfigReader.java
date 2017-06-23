package com.framework.utilities;

import com.framework.driver.BrowserType;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by hungduong on 5/28/17.
 */
public class ConfigReader {
    private static FileInputStream fis;
    private static Properties pro;

    static {
        pro = new Properties();
        try {
            fis = new FileInputStream(new File("./src/main/java/com/framework/config/config.properties"));
            pro.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getBrowserPath(BrowserType browserType) {
        String path = null;
        switch (browserType) {
            case Chrome:
                path = pro.getProperty("ChromeDriver");
                break;
            case FireFox:
                path = pro.getProperty("FirefoxDriver");
                break;
            case InternetExplore:
                path = pro.getProperty("IEDriver");
                break;
            case Safari:
                path = pro.getProperty("SafariDriver");
                break;
        }

        return path;
    }

    public static String getApplicationUrl() {
        return pro.getProperty("Url");
    }
}
