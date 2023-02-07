package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.MainPage;

import static ru.yandex.praktikum.PageAnswer.answer;


public class CheckQuesst{
    private WebDriver driver;

    @Test
    public void Test() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openBrowser();
        mainPage.closeCookie();
        String[] result = mainPage.importantAnswer();
        Assert.assertArrayEquals(answer, result);
    }
    @After
    public void teardown() {
        // Закрой браузер
         driver.quit();
    }
}
