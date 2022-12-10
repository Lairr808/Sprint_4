package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FirstOrderPage {
    private WebDriver driver;

    //поле "Имя"
    private final By fieldName = By.xpath("//div/input[@placeholder='* Имя']");
    //поле "Фамилия"
    private final By fieldSurname = By.xpath("//div/input[@placeholder='* Фамилия']");
    //поле "Адрес: куда привезти заказ"
    private final By fieldAddress = By.xpath("//div/input[@placeholder='* Адрес: куда привезти заказ']");
    //поле "Станция метро"
    private final By fieldMetro = By.xpath("//div/input[@placeholder='* Станция метро']");
    //поле "Телефон: на него позвонит курьер"
    private final By fieldPhone = By.xpath("//div/input[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка "Далее"
    private final By nextButton = By.xpath("//div/button[text()='Далее']");

    public FirstOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void nameField(String name) { driver.findElement(fieldName).sendKeys(name); }
    public void surnameField(String surname) {driver.findElement(fieldSurname).sendKeys(surname);}
    public void addressField(String address) { driver.findElement(fieldAddress).sendKeys(address);}
    public void metroField(String metro) {
        driver.findElement(fieldMetro).sendKeys(metro, Keys.ARROW_DOWN, Keys.RETURN);
    }
    public void phoneField(String phone) {driver.findElement(fieldPhone).sendKeys(phone);}

    //метод нажатие далее
    public void nextButtonCLick() {
        driver.findElement(nextButton).click();

    }
}
