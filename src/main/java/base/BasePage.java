package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BasePage {
    private String url;
    private Properties prop;

    public BasePage() throws IOException {
        prop = new Properties();
        FileInputStream data = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
        prop.load(data);
    }

    public static WebDriver getDriver() throws IOException, InterruptedException {
        return WebDriverInstance.getDriver();
    }

    public String getUrl() throws IOException {
        url = prop.getProperty("url");
        return url;
    }

    public void takeSnapShot(String name) throws IOException, InterruptedException {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        File destFile = new File(System.getProperty("user.dir") + "\\target\\screenshots\\" + timestamp() + ".png");
        FileUtils.copyFile(srcFile, destFile);

    }

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static void waitForElementInVisible(WebElement element, int timer) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timer));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public static void waitForElementVisible(WebElement element, int timer) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timer));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
