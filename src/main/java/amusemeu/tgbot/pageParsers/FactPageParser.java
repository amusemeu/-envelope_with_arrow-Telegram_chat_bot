package amusemeu.tgbot.pageParsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.net.URL;

public class FactPageParser {

        public static final String FACTPAGE = "https://randstuff.ru/fact/";

        public FactPageParser(){}

        public static Document getFactPage() throws IOException {
            Document page = Jsoup.parse(new URL(FACTPAGE), 3000);
            return page;
        }
        public static String getUrlFact() throws IOException {
            Document page = getFactPage();
            String element = page.select("div[class*='content'] tr").text();
            String link = element;
            return link;

        }
    }

