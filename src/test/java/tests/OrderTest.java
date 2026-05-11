package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrderPage;

public class OrderTest extends BaseTest {

    @Test(priority = 1)
    public void verifyPlaceOrder() throws Exception {
        OrderPage op = new OrderPage(driver);

        op.openProduct();
        op.addToCart();
        op.openCart();
        op.clickPlaceOrder();
        op.fillOrderDetails("Varsha", "India", "Chennai", "123456789", "May", "2026");
        op.clickPurchase();
        String msg = op.getConfirmationText();
        System.out.println(msg);
        Assert.assertTrue(msg.contains("Thank you"));
    }

    @Test(priority = 2)
    public void verifyOrderId() throws Exception {
        OrderPage op = new OrderPage(driver);
        op.openProduct();
        op.addToCart();
        op.openCart();
        op.clickPlaceOrder();

        op.fillOrderDetails("Varsha","India", "Chennai", "123456789", "May", "2026");
        op.clickPurchase();
        String msg = op.getConfirmationText();
        System.out.println(msg);
        Assert.assertTrue(msg.contains("Id"));
    }

    @Test(priority = 3)
    public void verifyEmptyFields() throws Exception {
        OrderPage op = new OrderPage(driver);
        op.openProduct();
        op.addToCart();
        op.openCart();
        op.clickPlaceOrder();

        op.fillOrderDetails("","India","Chennai","","May","2026");
        op.clickPurchase();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        System.out.println(alertMsg);
        Assert.assertEquals(alertMsg, "Please fill out Name and Creditcard.");
        alert.accept();
    }
}
