package amusemeu.tgbot.Keyboard;

import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class Keyboard {
    public static SendMessage sendInlineKeyBoardMessage(long chatId){
        String chat_idd = String.valueOf(chatId);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Чем могу помочь?");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(chat_idd);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

        inlineKeyboardButton.setText("Send a meme");
        inlineKeyboardButton.setCallbackData("Meme");
        inlineKeyboardButton1.setText("Send word of the day");
        inlineKeyboardButton1.setCallbackData("Word");
        inlineKeyboardButton2.setText("Send quote");
        inlineKeyboardButton2.setCallbackData("Quote");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();

        keyboardButtonsRow1.add(inlineKeyboardButton);
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow2.add(inlineKeyboardButton2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);

        inlineKeyboardMarkup.setKeyboard(rowList);

        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        return sendMessage;
    }

}
