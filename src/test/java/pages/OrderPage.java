package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    WebDriver driver;
    public OrderPage(WebDriver driver)
    {
        this.driver = driver;
    }
    By samsungPhone = By.linkText("Samsung galaxy s6");
    By addToCartBtn = By.linkText("Add to cart");
    By cartLink = By.id("cartur");
    By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    By nameField = By.id("name");
    By countryField = By.id("country");
    By cityField = By.id("city");
    By cardField = By.id("card");
    By monthField = By.id("month");
    By yearField = By.id("year");
    By purchaseBtn = By.xpath("//button[text()='Purchase']");
    By confirmationMsg = By.className("sweet-alert");


    public void openProduct() throws Exception
    {
        driver.findElement(samsungPhone).click();
        Thread.sleep(3000);
    }

    public void addToCart() throws Exception
    {
        driver.findElement(addToCartBtn).click();
        Thread.sleep(4000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }

    public void openCart() throws Exception
    {
        driver.findElement(cartLink).click();
        Thread.sleep(3000);
    }

    public void clickPlaceOrder() throws Exception
    {
        driver.findElement(placeOrderBtn).click();
        Thread.sleep(3000);
    }

    public void fillOrderDetails(String name, String country, String city, String card, String month, String year)
    {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(cardField).sendKeys(card);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);
    }

    public void clickPurchase() throws Exception
    {
        driver.findElement(purchaseBtn).click();
        Thread.sleep(4000);
    }

    public String getConfirmationText()
    {
        return driver.findElement(confirmationMsg).getText();
    }
}
