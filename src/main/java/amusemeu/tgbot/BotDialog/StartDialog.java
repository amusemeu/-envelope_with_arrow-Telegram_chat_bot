/*package amusemeu.tgbot.BotDialog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartDialog extends Thread{
    private String phrase;
    private WebDriver webDriver;

    public StartDialog(String phrase, WebDriver webDriver){
        this.phrase = phrase;
        this.webDriver = webDriver;
    }

    @Override
    public void run(){
        try {
            BotDialog.say(webDriver, phrase);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}*/
