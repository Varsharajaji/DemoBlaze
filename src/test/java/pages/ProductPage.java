package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;
    public ProductPage(WebDriver driver)
    {
        this.driver = driver;
    }
    By phonesCategory = By.linkText("Phones");
    By laptopsCategory = By.linkText("Laptops");
    By homeLink = By.xpath("//a[contains(text(),'Home')]");
    By samsungPhone = By.linkText("Samsung galaxy s6");
    By sonyLaptop = By.linkText("Sony vaio i5");
    By productName = By.className("name");
    By productPrice = By.className("price-container");
    By productDescription = By.id("more-information");


    public void clickPhones() throws Exception
    {
        driver.findElement(phonesCategory).click();
        Thread.sleep(2000);
    }

    public void clickLaptops() throws Exception
    {
        driver.findElement(laptopsCategory).click();
        Thread.sleep(2000);
    }

    public void openSamsungPhone() throws Exception
    {
        driver.findElement(samsungPhone).click();
        Thread.sleep(2000);
    }

    public void openSonyLaptop() throws Exception
    {
        driver.findElement(sonyLaptop).click();
        Thread.sleep(2000);
    }

    public String getProductName()
    {
        return driver.findElement(productName).getText();
    }

    public String getProductPrice()
    {
        return driver.findElement(productPrice).getText();
    }

    public String getProductDescription()
    {
        return driver.findElement(productDescription).getText();
    }

    public void clickHome() throws Exception
    {
        driver.findElement(homeLink).click();
        Thread.sleep(2000);
    }
}
