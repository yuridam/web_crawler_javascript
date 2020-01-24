package ElementCollector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class JavaScriptCollectorThread extends Thread {
    private String link;
    private List<String> scripts;
    private static int timeout = 5000;

    public JavaScriptCollectorThread(String link, List<String> scripts) {
        this.link = link;
        this.scripts = scripts;

        start();
    }


    @Override
    public void run(){


        try {
            Document document = Jsoup.connect(link).timeout(timeout).ignoreHttpErrors(true).get();

            // Get all <script></script> elements
            Elements elements = document.select("script");

            // Get <script></script> element with "src" attribute. e.g. <script src="">
            for (Element element:elements){

                String src = element.attr("src");

                // Filter only script that has .js extension
                if (src.contains(".js")){

                    // Remove all leading folder paths and version detail of the file
                    // e.g. : ../js/filename.js?ver=1.0.1  -> filename.js
                    String srcCleaned = src.substring(src.lastIndexOf("/")+1);

                    if (srcCleaned.contains("?")){
                        srcCleaned = srcCleaned.substring(0, srcCleaned.indexOf("?"));
                    }


                    scripts.add(srcCleaned);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
