package models;//import com.vdurmont.emoji.EmojiParser;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import searchsystem.SearchService;
import searchsystem.Searcher;
import services.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    private long chat_id;
    //private Searcher searcher;
    private String lastMessage = "";
    private ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    private User user;


    public Bot() {
    }

    @Override
    public void onUpdateReceived(Update update) {
        update.getUpdateId();
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        chat_id = update.getMessage().getChatId();
        String text = update.getMessage().getText();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        try {
            sendMessage.setText(getMessage(text));
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return "OlegMongolBot";
    }

    @Override
    public String getBotToken() {
        return "1046176762:AAEOtneYOGcPYC9fWO53V7luFj-CFxiP7YI";
    }

    public String getMessage(String msg) {

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        if (msg.toLowerCase().equals("привет") || msg.toLowerCase().equals("в главное")) {
            if (msg.equals("привет")) {
                UserService service = new UserService();
                user = new User(chat_id, 0);
                service.saveUser(user);
            }
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("C++");
            keyboardFirstRow.add("Python");
            keyboardFirstRow.add("Java");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбрать...";

        }
        if (msg.equals("C++")) {
            lastMessage = msg;
            keyboard.clear();
            keyboardFirstRow.clear();
            SendMessage sendMessage = new SendMessage();



            try {
                sendMessage.setText(SearchService.search("C++"));
                sendMessage.setChatId(chat_id);
                execute(sendMessage);
            } catch (IOException | TelegramApiException e) {
                e.printStackTrace();
            }

            keyboardFirstRow.add("Системное");
            keyboardFirstRow.add("GameDev");
            keyboardFirstRow.add("для ПТУ(ВУЗ)");
            keyboardSecondRow.add("В главное");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Набор Сишника";
        }
        if (msg.equals("Java")) {
            lastMessage = msg;
            keyboard.clear();
            keyboardFirstRow.clear();


            keyboardFirstRow.add("WebDev");
            keyboardFirstRow.add("Android");
            keyboardFirstRow.add("Desktop");
            keyboardSecondRow.add("В главное");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Джавистик";
        }

        return msg;
    }
}
