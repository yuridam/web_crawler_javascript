package LinkProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleLinkProvider implements LinkProvider {

    private static String searchQuery = "https://www.google.com/search?q=";
    private static int timeout = 5000;

    public List<String> getLinks(String keywords) {

        List<String> links = new ArrayList<>();

        // Get all main result links in the first page of Google search result
        try {
            Document googleResult = Jsoup.connect(searchQuery + keywords).timeout(timeout).get();
            Elements elemLinks = googleResult.select("div[class=g]");

            for (Element e: elemLinks){
                Elements elements = e.getElementsByTag("a");
                String url = elements.attr("href");
                if (url.startsWith("http"))
                    links.add(url);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return links;
    }
}
