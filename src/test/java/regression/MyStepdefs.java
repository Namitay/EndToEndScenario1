package regression;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import junit.textui.TestRunner;
//import junit.textui.TestRunner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStepdefs extends MyTestRunner {
  //WebDriver driver;
    public  HomePage homePage;
    public  LoginPage loginPage;
    public  ShoppingCartPage shoppingcartpage;
    public  CheckoutPage checkoutPage;
    public  WebDriverWait wait;
//endToEnd scenario using Hooks
    @Before
    public void start() {

       /* WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
               //WebDriverWait wait = new WebDriverWait(driver,30);      Explicit wait
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       */
        driver.manage().window().maximize();


        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        shoppingcartpage = new ShoppingCartPage(driver);
        checkoutPage = new CheckoutPage(driver);

    }

    @After
    public void stop(Scenario scenario) {
        // if(scenario.isFailed()) {
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshotBytes, "image/png");
        // }
        //driver.quit();
    }



    @Given("I navigate to url")
    public void iNavigateToUrl() {
      homePage.navigateToUrl();

    }

    @When("I click on login link from nav bar")
    public void iClickOnLoginLinkFromNavBar()
    {
     homePage.clickLoginLink();
    }

    @Then("I should be navigated to login page")
    public void iShouldBeNavigatedToLoginPage()
    {
        System.out.println(homePage.getPageTitle());
    }

    @When("I enter user name {string}")
    public void iEnterUserName(String email)
    {
        driver.navigate().refresh();
      loginPage.enterEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password)
    {
        loginPage.enterPassword(password);
    }
    @And("I click on login button")
    public void iClickOnLoginButton() {
loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        System.out.println(homePage.getPageTitle());
    }

    @When("I add item in to the cart")
    public void iAddItemInToTheCart()
    {

loginPage.clickAddToCart();

    }

    @And("I go to the cart")
    public void iGoToTheCart()  {
        homePage.clickShoppingCartLink();
    }

    @And("I click on terms of service")
    public void iClickOnTermsOfService()
    {
        driver.navigate().refresh();
        shoppingcartpage.ClickTermOfServiceCheckBox();

    }

    @And("I checkout as a existing user")
    public void iCheckoutAsAExistingUser() {
shoppingcartpage.ClickCheckoutButton();
    }

    @Then("I click on continue")
    public void iClickOnContinue() throws InterruptedException
    {

       // wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.continueButton));

        Thread.sleep(3000);

       checkoutPage.ClickContinueButton();

    }

    @When("I click on continue second again")
    public void iClickOnContinueSecondAgain() throws InterruptedException {

        Thread.sleep(3000);

       // wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.secondContinueButton));
     checkoutPage.ClickSecondContinueButton();
    }

    @And("I click on credit card")
    public void iClickOnCreditCard() throws InterruptedException {
        Thread.sleep(3000);

       // wait.until(ExpectedConditions.elementToBeSelected(checkoutPage.creditCardRadioButton));
        checkoutPage.ClickCreditCardRadioButton();

    }

    @And("I click on continue again third time")
    public void iClickOnContinueAgainThirdTime() {
    checkoutPage.ClickThirdContinueButton();
    }

    @And("I select credit card")
    public void iSelectCreditCard() throws InterruptedException {
     Thread.sleep(3000);

        //wait.until(ExpectedConditions.elementToBeSelected(checkoutPage.creditCardDropDown));
    checkoutPage.setCreditCard();
    }

    @And("I enter cardholder name {string}")
    public void iEnterCardholderName(String name)
    {
        checkoutPage.enterCardholderNameTextBox(name);
    }

    @And("I enter a card number {string}")
    public void iEnterACardNumber(String number)
    {
        checkoutPage.enterCardNumberTextBox(number);
    }



    @And("I select a month")
    public void iSelectAMonth()
    {
        checkoutPage.setMonthDropDown();
    }

    @And("I select a year")
    public void iSelectAYear() {
        checkoutPage.setYearDropDown();
    }


    @And("I enter a card code {string}")
    public void iEnterACardCode(String code)
    {
        checkoutPage.enterCodeTextBox(code);
    }

    @And("I click on continue fourth time")
    public void iClickOnContinueFourthTime() {
        checkoutPage.ClickFourthContinueButton();
    }

    @And("I click on confirm")
    public void iClickOnConfirm() throws InterruptedException {
       Thread.sleep(3000);

       // wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.confirmButton));
        checkoutPage.ClickConfirmButton();

    }

    @Then("I should see the order confirmation message")
    public void iShouldSeeTheOrderConfirmationMessage() throws InterruptedException {
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.textToBePresentInElement(By.ByXPath("\"//strong[text()='Your order has been successfully processed!']","Your order has been successfully processed!"));
        System.out.println(checkoutPage.verifyConfirmationMegssage());
    }


}

