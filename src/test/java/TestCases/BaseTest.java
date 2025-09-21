package TestCases;

import Pages.DriverInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass(alwaysRun = true)
    public void driverInit() {
       DriverInit.intilization();
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver(){
        DriverInit.intilization().quit();
        DriverInit.driver = null;
    }
}
