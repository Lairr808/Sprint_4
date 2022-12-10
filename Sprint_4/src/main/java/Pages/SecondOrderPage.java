package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SecondOrderPage {
    private WebDriver driver;

    public SecondOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //поле "Когда привезти самокат"
    private final By fieldWhen = By.xpath("//div/input[@placeholder='* Когда привезти самокат']");
    //поле "срок аренды"
    private final By rentalPeriodField = By.className("Dropdown-placeholder");

    //поле "Комментарий для курьера"
    private final By fieldComment = By.xpath("//div/input[@placeholder='Комментарий для курьера']");
    //кнопка "Заказать" в меню "Про аренду"
    private final By orderInside = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public void whenField(String when) {driver.findElement(fieldWhen).sendKeys(when,Keys.RETURN);}

    public void periodRental (String period){
        driver.findElement(rentalPeriodField).click();
        By rentPeriodOption = By.xpath(".//div[@class = 'Dropdown-menu']/div[contains(text(),'" + period + "')]");
        driver.findElement(rentPeriodOption).click();
    }

    public void colorScooter(String Color) {
        By colorScooterOption = By.id("" + Color + "");
        driver.findElement(colorScooterOption).click();
    }
    public void commentField(String comment) { driver.findElement(fieldComment).sendKeys(comment); }

    //метод нажатие далее
    public void orderButtonCLick() {
        driver.findElement(orderInside).click();
    }
}
