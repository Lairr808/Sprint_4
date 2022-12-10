package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver) {this.driver = driver;}
    private final By orderTop = By.className("Button_Button__ra12g");
    //кнопка "Заказать" внизу страницы
    //private final By orderBelow = By.className("Button_Button__ra12g Button_UltraBig__UU3Lp");

    public void clickOrderTop(){               //Метод нажать кнопку "Заказать"
        driver.findElement(orderTop).click();
    }

    public void openQuestion(String question){                                   //метод нажать на вопрос
        String question1 = "accordion__heading-";
        driver.findElement (By.id("" + question1 + "" + question + "")).click();
    }

    public String takeTextQuestionOne(String answer){
        String answer1 = "accordion__panel-";
        return driver.findElement(By.id("" + answer1 + "" + answer + "")).getText();} //метод вытащить текст ответа
}
