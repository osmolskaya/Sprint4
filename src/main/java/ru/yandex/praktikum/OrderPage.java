package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private final WebDriver driver;


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // элементы страницы https://qa-scooter.praktikum-services.ru/order
    // поле Имя
    private By fieldName = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    //поле Фамилия
    private By fieldSurname = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    //поле Адрес
    private By fieldAddress = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    //поле Станция
    private By fieldStation = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");
    //Выбор станции
    private By selectorStation=By.className("select-search__select");
    //поле Телефон
    private By fieldPhone = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    //кнопка Далее1
        private By buttonFurther = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
//Метод Для кого самокат
        public void enterDataWhoOrder(String name, String surname, String address, String station, String phone) {
            driver.findElement(fieldName).click();
            driver.findElement(fieldName).sendKeys(name);
            driver.findElement(fieldSurname).click();
            driver.findElement(fieldSurname).sendKeys(surname);
            driver.findElement(fieldAddress).click();
            driver.findElement(fieldAddress).sendKeys(address);
            driver.findElement(fieldStation).click();
            driver.findElement(fieldStation).sendKeys(station);
            driver.findElement(selectorStation).click();
            driver.findElement(fieldPhone).click();
            driver.findElement(fieldPhone).sendKeys(phone);
            driver.findElement(buttonFurther).click();
        }

        //поле Когда привезти
        private By fieldDateOrder = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
        //поле Срок аренды
        private By fieldRentalPeriod = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]");
        private By period = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");
        //Комментарий
        private By fieldComment = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
        //Цвет самоката
        private By fieldColorScooter = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/label[1]");
        //Кнопка Заказать
        private By buttonOrder = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

//Метод Про аренду
        public void  enterDataOrderAboutRent(String date, String comment){
            driver.findElement(fieldDateOrder).click();
            driver.findElement(fieldDateOrder).sendKeys(date);
            driver.findElement(fieldRentalPeriod).click();
            driver.findElement(period).click();
            driver.findElement(fieldColorScooter).click();
            driver.findElement(fieldComment).sendKeys(comment);
            driver.findElement(buttonOrder).click();
        }

        //Хотите заказть? Да!
        private By buttonYesOrder =  By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
        //Заказ оформлен
        private By OrderText =  By.xpath ("//*[@id=\"root\"]/div/div[2]/div[5]/div[1]");

        public void  clickButtonYesOrder(){
            driver.findElement(buttonYesOrder).click();


        }
        public OrderPage expectResult(){
            driver.findElement(OrderText).getText();
            return this;
        }



    }
