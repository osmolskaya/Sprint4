package ru.yandex.praktikum;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {

    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // Элементы страницы https://qa-scooter.praktikum-services.ru/
    // кнопка Заказать верх
    private By buttonOrderUp = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");
    //кнопка Заказать низ
    private By buttonOrderDown = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");
    //Локатор кнопки использования аккордиона для поиска элементов List<>
    private By accordionButtonImportantQuestions = By.className("accordion__item");

    // Локатор, берет текст из открывщегося аккордиона
    private By textAnswer= By.xpath(".//div[@class='accordion__panel']/p");
    // Закрытие куки
    private By buttonCookie = By.className("App_CookieButton__3cvqF");


    public MainPage clickButtonOrderUp(){
        driver.findElement(buttonOrderUp).click();
        return this;
    }
    public MainPage clickButtonOrderDown(){
        driver.findElement(buttonOrderUp).click();
        return this;
    }
    public void openBrowser(){driver.get("https://qa-scooter.praktikum-services.ru/");}

    public void openPageAndClickButtonOrder(By orderButton){
        openBrowser();
        closeCookie();
        driver.findElement(orderButton).click();
    }
    public void closeCookie(){
        driver.findElement(buttonCookie).click();
    }
    public String [] importantAnswer(){
        String [] array = new String[8];
        List<WebElement> importantQuestions = driver.findElements(accordionButtonImportantQuestions);
        List<WebElement> importantAnswer = driver.findElements(textAnswer);
        for (int i=0;i<8;i++) {
            importantQuestions.get(i).click();
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOf(importantAnswer.get(i)));
            array[i]=importantAnswer.get(i).getText();
        }
        return array;
    }
    }

