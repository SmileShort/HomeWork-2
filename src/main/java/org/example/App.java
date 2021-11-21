package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class App 
{
    public static void main( String[] args ) {

        System.out.println("Тест по созданию контактного лица");
        createContact();
        System.out.println("Тест на проверку существования проекта");
        examinationProject();

    }

    public static void examinationProject(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");

        WebDriver driver2 = new ChromeDriver(chromeOptions);

        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver2.get("https://crm.geekbrains.space");
        driver2.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver2.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver2.findElement(By.id("_submit")).click();

        driver2.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/a/span")).click();
        driver2.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/ul/li[4]/a/span")).click();

        driver2.findElement(By.cssSelector(".filter-item:nth-child(1) > .btn")).click();
        driver2.findElement(By.name("value")).sendKeys("SmileShort");
        driver2.findElement(By.xpath("//button[@class='btn btn-primary filter-update']")).click();

        driver2.findElement(By.xpath("//tr[@class='grid-row']")).click();

        driver2.findElement(By.xpath("//*[@id='user-menu']/a/i")).click();
        driver2.findElement(By.xpath("//*[@id='user-menu']/ul/li[6]/a")).click();

        driver2.quit();

    }

    public static void createContact(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://crm.geekbrains.space");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

        driver.findElement(By.cssSelector(".first > .unclickable > .title")).click();
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/ul/li[4]/a/span")).click();

        driver.findElement(By.xpath("//a[@title='Создать контактное лицо']")).click();

        driver.findElement(By.xpath("//input[@data-name='field__last-name']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@data-name='field__first-name']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@data-name='field__job-title']")).sendKeys("tester");
        driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
        driver.findElement(By.xpath("//div[@class='select2-search']")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/ul[2]/li[3]/div")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();

        driver.quit();

    }

}

