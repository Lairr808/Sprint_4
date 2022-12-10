package Test;

import Pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionsAboutImportant {
    private final String question;
    private final String answer;
    private final String expected;


    public QuestionsAboutImportant (String question,String answer,String expected) {
        this.question = question;
        this.answer = answer;
        this.expected = expected;

    }

    @Parameterized.Parameters ()
    public static Object[][] getTextData() {
        return new Object[][] {
                {"0", "0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"1", "1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"2", "2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"3", "3",  "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"4", "4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"5", "5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"6", "6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"7", "7", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
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
    public void checkOrder2(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        js.executeScript("arguments[0].scrollIntoView();", element);


        MainPage objMainPage = new MainPage(driver);
        objMainPage.openQuestion(question);
        objMainPage.takeTextQuestionOne(answer);
        String actual = objMainPage.takeTextQuestionOne(answer);

        assertEquals ("Ответ должен соответствовать", actual, expected);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
