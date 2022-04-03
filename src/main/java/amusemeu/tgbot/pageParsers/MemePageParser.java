package amusemeu.tgbot.pageParsers;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

public class MemePageParser {

    public static final String MEMEPAGE = "https://www.anekdot.ru/random/mem/";

    public MemePageParser() {
    }

    public static Document getPage() throws IOException {
        return Jsoup.parse(new URL(MEMEPAGE), 3000);
    }

    public static String getUrl() throws IOException {
        Document page = getPage();
        Element imageElement = page.select("img").get(5);
        String link = imageElement.attr("src");
        return link;
    }

}




