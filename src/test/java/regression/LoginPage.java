package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "Email")
    public WebElement emailTextBox;

    @FindBy(id="Password")
    public WebElement passwordTextBox;

    @FindBy(css = "input.login-button")
    public WebElement loginButton;

    @FindBy(xpath = "(//input[@value='Add to cart'])[1]")
    public WebElement FirstAddToCart;

    public void enterEmail(String email)
    {
        emailTextBox.sendKeys(email);
    }

    public void enterPassword(String password)
    {
        passwordTextBox.sendKeys(password);
    }
    public void clickLoginButton()
    {
        loginButton.click();
    }
    public void clickAddToCart()
    {
        FirstAddToCart.click();
    }
}
