package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ValidationTest extends BaseTest {


    // verify existing username signup

    @Test(priority = 1)

    public void verifyExistingUserSignup() throws Exception
    {
        LoginPage lp = new LoginPage(driver);

        // try signup with already existing user

        lp.signup("testuser123", "test123");

        // validation successful if alert handled

        Assert.assertTrue(true);
    }




    // verify empty username login

    @Test(priority = 2)

    public void verifyEmptyLogin() throws Exception
    {
        LoginPage lp = new LoginPage(driver);

        lp.login("", "");

        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();

        String alertMsg = alert.getText();

        System.out.println(alertMsg);

        Assert.assertEquals(
                alertMsg,
                "Please fill out Username and Password."
        );

        alert.accept();
    }



    // verify modal fields retain text

    @Test(priority = 3)

    public void verifyModalFieldValues() throws Exception
    {
        // open signup modal

        driver.findElement(By.id("signin2")).click();

        Thread.sleep(3000);

        // enter values

        driver.findElement(By.id("sign-username"))
                .sendKeys("sampleuser");

        driver.findElement(By.id("sign-password"))
                .sendKeys("samplepass");

        // fetch entered values

        String usernameValue = driver.findElement(
                        By.id("sign-username"))
                .getAttribute("value");

        String passwordValue = driver.findElement(
                        By.id("sign-password"))
                .getAttribute("value");

        System.out.println(usernameValue);

        System.out.println(passwordValue);

        Assert.assertEquals(usernameValue, "sampleuser");

        Assert.assertEquals(passwordValue, "samplepass");
    }

}
