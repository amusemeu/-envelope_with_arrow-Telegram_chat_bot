package amusemeu.tgbot.pageParsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;

public class WordOfADayParser {
        public static final String WORDOFADAYPAGE = "https://www.merriam-webster.com/word-of-the-day";
        public static final String WORDIMAGE = "https://ibb.co/BGK99Pq";

        public WordOfADayParser(){}

    public static Document getWordPage() throws IOException {
        Document page = Jsoup.parse(new URL(WORDOFADAYPAGE), 3000);
        return page;
    }
    public static String getUrlWord() throws IOException {
        Document page = getWordPage();
        String element = page.select("div[class*='word-and-pronunciation'] h1").text().toUpperCase(Locale.ROOT);
        String element2 = page.selectFirst("div[class*='wod-definition-container'] p").text();
        String link =  "\n" + element + "\n\n" + "What it means:" + "\n" + "\n" + element2;
        return link;
    }
    public static String getWordImg() throws IOException {
            Document page = getWordPage();
            String element = page.select("div[class*='awp-left'] src").text();
            return element;
    }
}
