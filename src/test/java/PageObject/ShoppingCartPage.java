package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    WebDriver driver;
    public ShoppingCartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='termsofservice']")
    public WebElement TermOfServiceCheckBox;

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement CheckoutButton;


    public void ClickTermOfServiceCheckBox()
    {
        TermOfServiceCheckBox.click();
    }
    public void ClickCheckoutButton()
    {
        CheckoutButton.click();
    }

}
