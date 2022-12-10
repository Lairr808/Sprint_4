package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowCheckout {
    private WebDriver driver;

    public WindowCheckout(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка "Да"
    private final By ButtonYes = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    //окно "Заказ оформлен"
    private final By WindowHeader = By.xpath("//div[@class='Order_Modal__YZ-d3']/div[text()='Заказ оформлен']");

    //метод нажать на кнопку "Да"
    public void clickButtonYes() {
        driver.findElement(ButtonYes).click();
    }

    // метод для получения текста из заголовка окна
    public String headerWindow(){
        return driver.findElement(By.className("Order_ModalHeader__3FDaJ")).getText();
    }
}
