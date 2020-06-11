package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//select[@id='billing-address-select']")
    public WebElement AddTextBox;

    @FindBy(xpath = "(//input[@title='Continue'])[1]")
    public WebElement continueButton;

    @FindBy(xpath = "(//input[@type='button'])[4]")
    public WebElement secondContinueButton;

    @FindBy(xpath = "//input[@id='paymentmethod_1']")
    public WebElement creditCardRadioButton;

    @FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']")
    public WebElement thirdContinueButton;
    @FindBy(xpath = "//select[@id='CreditCardType']")
    public WebElement creditCardDropDown;

    @FindBy(css = "input#CardholderName")
    public WebElement cardholderNameTextBox;
    @FindBy(css = "input#CardNumber")
    public WebElement cardNumberTextBox;

    @FindBy(xpath = "//select[@id='ExpireMonth']")
    public WebElement monthDropDown;
    @FindBy(xpath = "//select[@id='ExpireYear']")
    public WebElement yearDropDown;

    @FindBy(css="input#CardCode")
    public WebElement cardCodeTextBox;
    @FindBy(xpath = "(//input[@type='button'])[6]")
    public WebElement fourthContinueButton;
    @FindBy(xpath = "(//input[@type='button'])[7]")
    public WebElement confirmButton;

    @FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
    public WebElement confirmationMessage;

    public void ClickContinueButton()
    {
        continueButton.click();
    }

    public void ClickSecondContinueButton() {

        secondContinueButton.click();
    }

    public void ClickCreditCardRadioButton()
    {

        creditCardRadioButton.click();
    }
    public void ClickThirdContinueButton()
    {
        thirdContinueButton.click();
    }
    public void enterCardholderNameTextBox(String name)
    {
        cardholderNameTextBox.sendKeys(name);
    }
    public void enterCardNumberTextBox(String number)
    {
        cardNumberTextBox.sendKeys(number);
    }
    public void enterCodeTextBox(String code)
    {
        cardCodeTextBox .sendKeys(code);
    }
    public void setCreditCard()
    { Select cardType = new Select(creditCardDropDown);
        cardType.selectByVisibleText("Visa");

    }
    public void setMonthDropDown()
    {
        Select Month = new Select(monthDropDown);
        Month .selectByVisibleText("01");
    }
    public void setYearDropDown()
    {
        Select Year = new Select(yearDropDown);
        Year.selectByVisibleText("2022");
    }
    public void ClickFourthContinueButton()
    {
        fourthContinueButton .click();
    }
    public void ClickConfirmButton()
    {
        confirmButton.click();
    }
    public String verifyConfirmationMegssage()
    {

        return  confirmationMessage.getText();
    }

}
