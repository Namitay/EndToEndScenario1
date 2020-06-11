package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(linkText = "Log in")
    public WebElement loginLink;

    @FindBy(xpath = "//span[@class='cart-label']")
    public WebElement ShoppingCartLink;

    public void clickLoginLink()
    {
        loginLink.click();
    }
    public void clickShoppingCartLink()
    {
        ShoppingCartLink .click();
    }

    public void navigateToUrl()

    {
        // use driver.get when you opening browser first time
        driver.get("http://twentyconsulting-001-site1.dtempurl.com/");
        //driver.navigate().to("http://twentyconsulting-001-site1.dtempurl.com/");
    }
    public String getPageTitle()
    {
        return driver.getTitle();
    }

}
