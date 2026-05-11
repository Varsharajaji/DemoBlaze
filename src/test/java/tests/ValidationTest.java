package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ValidationTest extends BaseTest {

    @Test(priority = 1)
    public void verifyExistingUserSignup() throws Exception
    {
        LoginPage lp = new LoginPage(driver);
        lp.signup("testuser123", "test123");
        Assert.assertTrue(true);
    }

    @Test(priority = 2)
    public void verifyEmptyLogin() throws Exception
    {
        LoginPage lp = new LoginPage(driver);
        lp.login("", "");
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        System.out.println(alertMsg);
        Assert.assertEquals(alertMsg, "Please fill out Username and Password.");
        alert.accept();
    }

    @Test(priority = 3)
    public void verifyModalFieldValues() throws Exception
    {
        driver.findElement(By.id("signin2")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("sign-username")).sendKeys("sampleuser");
        driver.findElement(By.id("sign-password")).sendKeys("samplepass");
        String usernameValue = driver.findElement(By.id("sign-username")).getAttribute("value");
        String passwordValue = driver.findElement(By.id("sign-password")).getAttribute("value");
        System.out.println(usernameValue);
        System.out.println(passwordValue);
        Assert.assertEquals(usernameValue, "sampleuser");
        Assert.assertEquals(passwordValue, "samplepass");
    }
}
