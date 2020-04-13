import models.Bot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import searchsystem.Searcher;

import java.io.IOException;

public class Main {

    private static final String ENCODING = "UTF-8";
    private static final String GOOGLE_SEARCH_URL = "https://www.google.com/search?q=";
    private static final String HABR_SEARCH_URL = "https://habr.com/ru/search/?target_type=posts&order_by=relevance&q=";
    private static final String YANDEX_SEARCH_URL = "https://yandex.by/search/?text=";
    private static final String YOUTUBE_SEARCH_URL = "https://www.youtube.com/results?search_query=";
    private static final String OPTIONAL_YT = "&sp=EgIQAw%253D%253D";
    private static final String GOOGLE_CLASS = "TbwUpd";
    private static final String YANDEX_CLASS = "link link_theme_normal organic__url link_cropped_no i-bem";
    private static final String HABR_CLASS = "post__title_link";
    private static final String YT_CLASS = "post__title_link";

    public static void main(String[] args) throws IOException {

        Searcher search = new Searcher();

        ApiContextInitializer.init();
        TelegramBotsApi tgApi = new TelegramBotsApi();
        Bot bot = new Bot();
        try {
            tgApi.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
