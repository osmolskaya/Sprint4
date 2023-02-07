package test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.MainPage;
import ru.yandex.praktikum.OrderPage;



    @RunWith(Parameterized.class)
    public class CheckOrder {
        private final String name;
        private final String surname;
        private final String address;
        private final String station;
        private final String phone;
        private final String date;
        private final String comment;


        public TestClass(String name, String surname, String address, String station, String phone, String date, String comment) {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.station = station;
            this.phone = phone;
            this.date = date;
            this.comment = comment;
        }


        @Parameters
        public static Object[][] getData() {
            //Сгенерируй тестовые данные (нам нужно название городов и результат поиска)
            return new Object[][] {
                    {"Ваня", "Иванов", "Советская, 2","89085746335", "Коммент 1"},
                    {"Маша", "Петрова", "Ленина, 14","89155748520", "Коммент 2"},
                    {"Женя", "Лукашин", "Строителей, 25","89835747413", "Коммент 3"},
            };
        }


    private WebDriver driver;
    @Test
    public void CheckOrder() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создай объект класса главной страницы приложения
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonOrderUp();

        // создай объект класса  страницы заказа
        OrderPage objOrderPage = new OrderPage(driver);
                objOrderPage.enterDataWhoOrder(name, surname, address, station, phone);
        objOrderPage.enterDataOrderAboutRent(date,comment);
        objOrderPage.clickButtonYesOrder();
        String result = objOrderPage.expectResult().toString();
        Assert.assertEquals(result,"Заказ оформлен") ;

    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
