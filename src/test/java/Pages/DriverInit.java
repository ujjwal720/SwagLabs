package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverInit {

    public static WebDriver driver;


    /*
    Inlization of Webdriver
     */

    public static WebDriver intilization(){

        if(driver==null){
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection_enabled", false);
            //prefs.put("download.default_directory", StaticPaths.getDownloadUrl());
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--incognito");
            driver=new ChromeDriver(options);
            driver.manage().window().maximize();
          //  driver.get("");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return driver;
        }
        return driver;
    }
}
