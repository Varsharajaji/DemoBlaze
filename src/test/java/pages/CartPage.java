package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }


    // product locators

    By samsungPhone = By.linkText("Samsung galaxy s6");

    By nokiaPhone = By.linkText("Nokia lumia 1520");

    By addToCartBtn = By.linkText("Add to cart");

    By cartLink = By.id("cartur");

    By deleteBtn = By.linkText("Delete");

    By totalAmount = By.id("totalp");



    // open samsung phone

    public void openSamsungPhone() throws Exception
    {
        driver.findElement(samsungPhone).click();

        Thread.sleep(3000);
    }



    // open nokia phone

    public void openNokiaPhone() throws Exception
    {
        driver.findElement(nokiaPhone).click();

        Thread.sleep(3000);
    }



    // add product to cart

    public void addToCart() throws Exception
    {
        driver.findElement(addToCartBtn).click();

        // wait for alert

        Thread.sleep(4000);

        try
        {
            Alert alert = driver.switchTo().alert();

            System.out.println(alert.getText());

            alert.accept();
        }
        catch (Exception e)
        {
            System.out.println("Alert not found");
        }

        Thread.sleep(2000);
    }



    // open cart page

    public void openCart() throws Exception
    {
        driver.findElement(cartLink).click();

        Thread.sleep(4000);
    }



    // delete product

    public void deleteProduct() throws Exception
    {
        driver.findElement(deleteBtn).click();

        Thread.sleep(4000);
    }



    // get total amount

    public String getTotal()
    {
        return driver.findElement(totalAmount).getText();
    }

}