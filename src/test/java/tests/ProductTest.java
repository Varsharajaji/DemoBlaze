package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    // verify phones category

    @Test(priority = 1)

    public void verifyPhonesCategory() throws Exception
    {
        ProductPage pp = new ProductPage(driver);

        pp.clickPhones();

        boolean status = driver.findElement(
                By.linkText("Samsung galaxy s6")).isDisplayed();

        Assert.assertTrue(status);
    }



    // verify laptops category

    @Test(priority = 2)

    public void verifyLaptopsCategory() throws Exception
    {
        ProductPage pp = new ProductPage(driver);

        pp.clickLaptops();

        boolean status = driver.findElement(
                By.linkText("Sony vaio i5")).isDisplayed();

        Assert.assertTrue(status);
    }



    // verify product details

    @Test(priority = 3)

    public void verifyProductDetails() throws Exception
    {
        ProductPage pp = new ProductPage(driver);

        pp.clickPhones();

        pp.openSamsungPhone();

        String name = pp.getProductName();

        String price = pp.getProductPrice();

        String desc = pp.getProductDescription();

        System.out.println(name);

        System.out.println(price);

        System.out.println(desc);

        Assert.assertTrue(name.contains("Samsung"));

        Assert.assertTrue(price.contains("$"));
    }



    // verify home link

    @Test(priority = 4)

    public void verifyHomeLink() throws Exception
    {
        ProductPage pp = new ProductPage(driver);

        pp.clickPhones();

        pp.clickHome();

        boolean status = driver.findElement(
                By.linkText("Nexus 6")).isDisplayed();

        Assert.assertTrue(status);
    }

}
