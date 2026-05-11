package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AuthenticationTest extends BaseTest {

    String username = "user" + System.currentTimeMillis();
    String password = "pass123";

    @Test(priority = 1)
    public void verifySignup() throws Exception
    {
        LoginPage lp = new LoginPage(driver);
        lp.signup(username, password);
    }

    @Test(priority = 2)
    public void verifyLogin() throws Exception
    {
        LoginPage lp = new LoginPage(driver);
        lp.login(username, password);
        Thread.sleep(5000);
        String actualName = lp.getUserName();
        System.out.println(actualName);
        Assert.assertTrue(actualName.contains(username));
    }

    @Test(priority = 3)
    public void verifyWrongLogin() throws Exception
    {
        LoginPage lp = new LoginPage(driver);
        lp.login("wronguser", "wrongpass");
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        System.out.println(alertMsg);
        Assert.assertEquals(alertMsg, "Wrong password.");
        alert.accept();
    }

    @Test(priority = 4)
    public void verifyLogout() throws Exception
    {
        LoginPage lp = new LoginPage(driver);
        lp.login(username, password);
        lp.logout();
        boolean status = driver.findElement(By.id("login2")).isDisplayed();
        Assert.assertTrue(status);
    }
}
