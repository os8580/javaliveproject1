package com.github.os8580;

import base.BasePage;
import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;
import java.time.Duration;

@Listeners(resources.Listeners.class)

public class AddRemoveItemBasketTest extends Hooks {
    public AddRemoveItemBasketTest() throws IOException {
        super();
    }


    @Test
    public void addRemoveItem() throws IOException, InterruptedException {
        // creating an object of the automationtesting.co.uk webpage
        Homepage home = new Homepage();

        //handles cookie prompt
        home.getCookie().click();

        home.getTestStoreLink().click();

        // creating an object of the test store homepage
        ShopHomepage shopHome = new ShopHomepage();
        shopHome.getProdOne().click();

        // creating an object of the shop products page (when a product has been selected)
        ShopProductPage shopProd = new ShopProductPage();
        Select option = new Select(shopProd.getSizeOption());
        option.selectByVisibleText("M");
        shopProd.getQuantIncrease().click();
        shopProd.getAddToCartBtn().click();

        // creating an object of the cart content panel (once an item was added)
        ShopContentPanel cPanel = new ShopContentPanel();
//        waitForElementVisible(cPanel.getContinueShopBtn(), 10);
        cPanel.getContinueShopBtn().click();
//        waitForElementVisible(shopProd.getHomepageLink(), 10);
        shopProd.getHomepageLink().click();
        shopHome.getProdTwo().click();
        shopProd.getAddToCartBtn().click();
        cPanel.getCheckoutBtn().click();

        // creating an object for the shopping cart page and deleting item 2
        ShoppingCart cart = new ShoppingCart();
        cart.getDeleteItemTwo().click();

        // using a wait to ensure the deletion has taken place
        waitForElementInVisible(cart.getDeleteItemTwo(), 10);

        // printing the total amount to console
        System.out.println(cart.getTotalAmount().getText());

        // using an assertion to make sure the total amount is what we are expecting
        Assert.assertEquals(cart.getTotalAmount().getText(), "$45.24");
    }
}
