

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.logging.LoggingPreferences

import java.util.logging.Level

//Default browser to run on local machine
environments {
    chrome {
        WebDriverManager.chromedriver().setup()
        def options = new ChromeOptions()
        options.setAcceptInsecureCerts(true)
        options.addArguments('window-size=1600,1200')
        driver = { new ChromeDriver(options) }
    }
}
