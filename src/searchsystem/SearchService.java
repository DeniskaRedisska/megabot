package searchsystem;

import java.io.IOException;

public class SearchService {
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

    public static String search(String searchTerm) throws IOException {
        Searcher searcher = new Searcher();
        StringBuilder sb = new StringBuilder();
        sb.append(searcher.search(GOOGLE_SEARCH_URL, GOOGLE_CLASS, "", searchTerm)).append("\n ");
        sb.append(searcher.search(YANDEX_SEARCH_URL, YANDEX_CLASS, "", searchTerm)).append("\n ");
        sb.append(searcher.search(YOUTUBE_SEARCH_URL, YT_CLASS, OPTIONAL_YT, searchTerm)).append("\n ");
        sb.append(searcher.search(HABR_SEARCH_URL, HABR_CLASS, "", searchTerm)).append("\n ");
        return sb.toString();
    }
}
