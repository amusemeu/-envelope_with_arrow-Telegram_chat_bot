package amusemeu.tgbot.BotDialog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BotDialog {


    public static String conversate(String phrase) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://p-bot.ru/index.html");




        WebElement text = webDriver.findElement(By.xpath("//*[@id=\"user_request\"]"));
        WebElement button = webDriver.findElement(By.xpath("//*[@id=\"btnSay\"]"));
        Thread.sleep(1000);
        text.clear();
        text.sendKeys(phrase);
        Thread.sleep(1000);
        button.click();
        Thread.sleep(2000);
        WebElement answer = webDriver.findElement(By.xpath("//*[@id=\"answer_0\"]"));
        Thread.sleep(1000);
        String anwr = answer.getText();
        String answ = anwr.replaceAll("ρBot: ", "");
        Thread.sleep(3000);
        webDriver.quit();
        return answ;
    }

   public static void stopDialog(WebDriver webDriver) throws InterruptedException{
        Thread.sleep(10000);
        webDriver.quit();
    }
}
