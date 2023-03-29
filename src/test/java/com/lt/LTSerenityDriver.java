package com.lt;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;

import java.net.URL;
import java.util.Iterator;

public class LTSerenityDriver implements DriverSource {

    public AppiumDriver newDriver() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        String username = System.getenv("LT_USERNAME");
       
        String accessKey = System.getenv("LT_ACCESS_KEY");

        String environment = System.getProperty("environment");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("plugin","Serenity LambdaTest Plugin");
        // capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("autoAcceptAlerts", true);
        

		Iterator it = environmentVariables.getKeys().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();

			if (key.equals("lt.user") || key.equals("lt.key") || key.equals("lt.grid")) {
				continue;
			} else if (key.startsWith("lt_")) {
				capabilities.setCapability(key.replace("lt_", ""), environmentVariables.getProperty(key));

			} else if (environment != null && key.startsWith("environment." + environment)) {
				
				capabilities.setCapability(key.replace("environment." + environment + ".", ""),
						environmentVariables.getProperty(key));
			}
		}
        System.out.println(capabilities.asMap());
        try {
            if(capabilities.getCapability("device").toString().contains("iP")){
                IOSDriver driver = new IOSDriver<IOSElement>(new URL("https://" + username + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"), capabilities);
                System.out.println(driver);
                return driver;
            }
            else{
                AndroidDriver driver = new AndroidDriver<AndroidElement>(new URL("https://" + username + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"), capabilities);
                System.out.println(driver);
                return driver;
            }
        } catch (Exception e) {
            System.out.println("@@@\t"+e.getMessage() + "\n!!!\t" +e.getCause());
//            System.out.println(e);
            return null;
        }
    }

    public boolean takesScreenshots() {
        return true;
    }
}