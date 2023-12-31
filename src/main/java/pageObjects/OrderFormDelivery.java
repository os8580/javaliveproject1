package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class OrderFormDelivery extends BasePage {
    public WebDriver driver;

    By firstNameField = By.cssSelector("input[name='firstname']");
    By lastNameField = By.cssSelector("input[name='lastname']");
    By companyNameField = By.cssSelector("input[name='company']");
    By addressField = By.cssSelector("input[name='address1']");
    By addressComplementField = By.cssSelector("input[name='address2']");
    By cityField = By.cssSelector("input[name='city']");
    By stateDropdown = By.cssSelector("select[name='id_state']");
    By postcodeField = By.cssSelector("input[name='postcode']");
    By countryDropdown = By.cssSelector("select[name='id_country']");
    By phoneField = By.cssSelector("input[name='phone']");
    By invoiceSameAddCheckboc = By.cssSelector("input#use_same_address");
    By continueBtn = By.cssSelector("button[name='confirm-addresses']");

    public OrderFormDelivery() throws IOException {
        super();

    }

    public WebElement getFirstNameField() throws IOException, InterruptedException {
        this.driver = getDriver();
        return driver.findElement(firstNameField);
    }

    public WebElement getLastnameField() throws IOException, InterruptedException {
        this.driver = getDriver();
        return driver.findElement(lastNameField);
    }

    public WebElement getCompanyField() throws IOException, InterruptedException {
        this.driver = getDriver();
        return driver.findElement(companyNameField);
    }

    public WebElement getAddressField() throws IOException, InterruptedException {
        this.driver = getDriver();
        return driver.findElement(addressField);
    }

    public WebElement getAddressCompField() throws IOException, InterruptedException {
        this.driver = getDriver();
        return driver.findElement(addressComplementField);
    }

    public WebElement getCityField() throws IOException, InterruptedException {
        this.driver = getDriver();
        return driver.findElement(cityField);
    }

    public WebElement getStateDropdown() throws IOException, InterruptedException {
        this.driver = getDriver();
        return driver.findElement(stateDropdown);
    }

    public WebElement getPostcodeField() throws IOException, InterruptedException {
        this.driver = getDriver();
        return driver.findElement(postcodeField);
    }

    public WebElement getCountryDropdown() throws IOException, InterruptedException {
        this.driver = getDriver();
        return driver.findElement(countryDropdown);
    }

    public WebElement getPhoneField() throws IOException, InterruptedException {
        this.driver = getDriver();
        return driver.findElement(phoneField);
    }

    public WebElement getInvoiceSameAddCheckbox() throws IOException, InterruptedException {
        this.driver = getDriver();
        return driver.findElement(invoiceSameAddCheckboc);
    }

    public WebElement getContinueBtn() throws IOException, InterruptedException {
        this.driver = getDriver();
        return driver.findElement(continueBtn);
    }
}
