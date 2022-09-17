package amusemeu.tgbot;

import amusemeu.tgbot.BotDialog.BotDialog;
import amusemeu.tgbot.Keyboard.Keyboard;
import amusemeu.tgbot.pageParsers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

@SpringBootApplication
public class TgbotApplication extends TelegramLongPollingBot {


	public TgbotApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(TgbotApplication.class, args);
		//the way to chromedriver
		System.setProperty("webdriver.chrome.driver", "/Users/amusemeu/Documents/JAVA/tgbot/selenium/chromedriver 5");

		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			telegramBotsApi.registerBot(new TgbotApplication());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	/*@Value("${bot.username}")
	private static String username;
	@Value("${bot.token}")
	private static String token;*/

	//fields for your bot's username and token
	public  final String username = "";
	public  final String token = "";

	@Override
	public String getBotUsername() {
		return username;
	}

	@Override
	public String getBotToken() {
		return token;
	}

	@Override
	public void onUpdateReceived(Update update) {

		if (update.getMessage() != null && update.getMessage().hasText() && update.getMessage().getText().contains("/start")) {
			long chat_id = update.getMessage().getChatId();
			try {
				execute(Keyboard.sendInlineKeyBoardMessage(chat_id));
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		} else if (update.hasCallbackQuery()) {
			Message message = update.getCallbackQuery().getMessage();
			CallbackQuery callbackQuery = update.getCallbackQuery();
			String data = callbackQuery.getData();
			long chat_id = message.getChatId();
			String chat_idd = String.valueOf(chat_id);
			if (data.equals("Meme")) {
				try {
					execute(new SendPhoto(chat_idd, new InputFile(MemePageParser.getUrl())));
				} catch (TelegramApiException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (data.equals("Quote")) {
				try {
					execute(new SendMessage(chat_idd, QuotePageParser.getUrlQuote()));
				} catch (TelegramApiException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

		} else if (data.equals("Word")) {
				try {
					execute(new SendPhoto(chat_idd, new InputFile(WordOfADayParser.WORDIMAGE)));
					execute(new SendMessage(chat_idd, WordOfADayParser.getUrlWord()));
				} catch (TelegramApiException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if (data.equals("Fact")) {
				try {
					execute(new SendMessage(chat_idd, FactPageParser.getUrlFact()));
				} catch (TelegramApiException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else if (update.getMessage() != null && update.getMessage().hasText() && update.getMessage().getText().contains("sorry")) {
			long chat_id = update.getMessage().getChatId();
			String chat_idd = String.valueOf(chat_id);

			try {
				execute(new SendSticker(chat_idd, new InputFile("CAACAgIAAxkBAAED1Alh_8S7wlSSGqOkULzb7Hi_5QtQMgAC4AoAAokEKEogQzJB_ZpiRSME")));
			} catch (TelegramApiException e) {
				e.printStackTrace();

			}
		} else if (update.getMessage() != null && update.getMessage().hasText() && update.getMessage().getText().contains(username)) {
			long chat_id = update.getMessage().getChatId();
			String chat_idd = String.valueOf(chat_id);

			try {
				execute(new SendMessage(chat_idd, "Ну, чего?"));
				execute(new SendSticker(chat_idd, new InputFile("CAACAgIAAxkBAAEEUY1iRCGrPP6lOMSrUcPSwWACEuxiEAAC-wADG3iyGG6Bi0RXEUO7IwQ")));
				execute(new SendMessage(chat_idd, "Для вызова меню напиши /start"));
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}

		} else if (update.getMessage() != null && update.getMessage().hasText()){


		long chat_id = update.getMessage().getChatId();
		String chat_idd = String.valueOf(chat_id);
			User user = update.getMessage().getFrom();
			String name = user.getFirstName();
			int messgId = update.getMessage().getMessageId();
		try {
			execute(new SendMessage(chat_idd, BotDialog.conversate(update.getMessage().getText())));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
}

