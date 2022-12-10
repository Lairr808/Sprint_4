package Test;

import Pages.FirstOrderPage;
import Pages.MainPage;
import Pages.SecondOrderPage;
import Pages.WindowCheckout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderAScooter {
    private final String Name;
    private final String Surname;
    private final String Address;
    private final String Metro;
    private final String Phone;
    private final String When;
    private final String Period;
    private final String Color;
    private final String Comment;

    public OrderAScooter (String Name, String Surname, String Address, String Metro, String Phone, String When, String Period, String Color, String Comment) {
        this.Name = Name;
        this.Surname = Surname;
        this.Address = Address;
        this.Metro = Metro;
        this.Phone = Phone;
        this.When = When;
        this.Period = Period;
        this.Color = Color;
        this.Comment = Comment;
    }
    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {"Имя", "Фамилия", "Москва", "Черкизовская", "89988776655", "30.12.2022", "сутки", "black", "Нет комментария"},
                {"Тест", "Тест", "Казань", "Сокольники", "84358764555", "20.01.2023", "трое суток", "grey", "Есть комментарий"},
        };
    }

    @Before
    public void startDriver(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    private WebDriver driver;

    @Test
    public void checkOrder() {
        MainPage objMainPage = new MainPage(driver);
        // кликни на кнопку "Заказать"
        objMainPage.clickOrderTop();

        FirstOrderPage objFirstOrderPage = new FirstOrderPage(driver);
        //заполнение первой страницы Заказать
        objFirstOrderPage.nameField(Name);
        objFirstOrderPage.surnameField(Surname);
        objFirstOrderPage.addressField(Address);
        objFirstOrderPage.metroField(Metro);
        objFirstOrderPage.phoneField(Phone);
        //нажатие Далее
        objFirstOrderPage.nextButtonCLick();

        SecondOrderPage objSecondOrderPage = new SecondOrderPage(driver);
        //заполнение второй страницы Заказать
        objSecondOrderPage.whenField(When);
        objSecondOrderPage.periodRental(Period);
        objSecondOrderPage.colorScooter(Color);
        objSecondOrderPage.commentField(Comment);

        //нажатие заказать
        objSecondOrderPage.orderButtonCLick();

        WindowCheckout objWindowCheckout = new WindowCheckout(driver);
        objWindowCheckout.clickButtonYes();
        String headerWindow = objWindowCheckout.headerWindow();
        String expected = "Заказ оформлен";

        assertEquals("Заголовок должен соответствоать", headerWindow, expected);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
