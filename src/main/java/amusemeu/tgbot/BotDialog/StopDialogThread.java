package amusemeu.tgbot.BotDialog;

import org.openqa.selenium.WebDriver;

public class StopDialogThread extends Thread{
    private final WebDriver webDriver;

    public StopDialogThread(WebDriver webDriver){
        this.webDriver = webDriver;
    }


    @Override
    public void run(){
        try {
            BotDialog.stopDialog(webDriver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }

