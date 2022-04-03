package amusemeu.tgbot.pageParsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class QuotePageParser {

   public static final String QUOTEPAGE = "https://socratify.net/quotes/random";

    public QuotePageParser(){
    }

    public static Document getQuotePage() throws IOException {
        Document page = Jsoup.parse(new URL(QUOTEPAGE), 3000);
        return page;
    }
    public static String getUrlQuote() throws IOException {
        Document page = getQuotePage();
        String element = page.select("div[class*='b-quote'] h1").text();
        String link = element;
        return link;
    }

}
