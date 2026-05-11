package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By signupLink = By.id("signin2");
    By signupUsername = By.id("sign-username");
    By signupPassword = By.id("sign-password");
    By signupButton = By.xpath("//button[text()='Sign up']");


    By loginLink = By.id("login2");
    By loginUsername = By.id("loginusername");
    By loginPassword = By.id("loginpassword");
    By loginButton = By.xpath("//button[text()='Log in']");
    By userNameText = By.id("nameofuser");
    By logoutBtn = By.id("logout2");



    public void signup(String uname, String pass) throws Exception
    {
        driver.findElement(signupLink).click();
        Thread.sleep(2000);
        driver.findElement(signupUsername).sendKeys(uname);
        driver.findElement(signupPassword).sendKeys(pass);
        driver.findElement(signupButton).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }


    public void login(String uname, String pass) throws Exception
    {
        driver.findElement(loginLink).click();
        Thread.sleep(2000);
        driver.findElement(loginUsername).sendKeys(uname);
        driver.findElement(loginPassword).sendKeys(pass);
        driver.findElement(loginButton).click();
        Thread.sleep(3000);
    }


    public String getUserName()
    {
        return driver.findElement(userNameText).getText();
    }



    public void logout() throws Exception
    {
        driver.findElement(logoutBtn).click();
        Thread.sleep(2000);
    }

}
