package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartTest extends BaseTest {

    @Test(priority = 1)
    public void verifySingleProductCart() throws Exception
    {
        CartPage cp = new CartPage(driver);
        cp.openSamsungPhone();
        cp.addToCart();
        cp.openCart();
        boolean status = driver.getPageSource().contains("Samsung galaxy s6");
        Assert.assertTrue(status);
    }

    @Test(priority = 2)
    public void verifyTwoProductsCart() throws Exception
    {
        CartPage cp = new CartPage(driver);
        cp.openSamsungPhone();
        cp.addToCart();
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(5000);
        cp.openNokiaPhone();
        cp.addToCart();
        cp.openCart();
        Thread.sleep(4000);

        boolean firstProduct = driver.getPageSource().contains("Samsung galaxy s6");
        boolean secondProduct = driver.getPageSource().contains("Nokia lumia 1520");

        Assert.assertTrue(firstProduct);
        Assert.assertTrue(secondProduct);
    }

    @Test(priority = 3)
    public void verifyDeleteProduct() throws Exception
    {
        CartPage cp = new CartPage(driver);
        cp.openSamsungPhone();
        cp.addToCart();
        cp.openCart();
        cp.deleteProduct();
        Thread.sleep(4000);
        boolean status = driver.getPageSource().contains("Samsung galaxy s6");
        Assert.assertFalse(status);
    }

    @Test(priority = 4)
    public void verifyTotalPrice() throws Exception
    {
        CartPage cp = new CartPage(driver);
        cp.openSamsungPhone();
        cp.addToCart();
        cp.openCart();
        Thread.sleep(3000);
        String total = cp.getTotal();
        System.out.println("Total Price : " + total);
        Assert.assertTrue(Integer.parseInt(total) > 0);
    }

}