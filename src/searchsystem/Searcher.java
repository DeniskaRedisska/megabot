package searchsystem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class Searcher {

    public String search(String searchSystem, String className, String optional, String searchTerm) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder foundedLinks = new StringBuilder();
        String searchURL = searchSystem + searchTerm + optional;

        Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();

        Elements results = doc.getElementsByClass(className);
        for (Element result : results) {
            String hreftext = result.attr("href");
            String linkText = result.text();
            foundedLinks.append(linkText);
            foundedLinks.append("  ");
            foundedLinks.append(hreftext);
        }
        System.out.println(foundedLinks);
        return foundedLinks.toString();
    }
}
