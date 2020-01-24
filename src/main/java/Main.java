import ElementCollector.JavaScriptCollector;
import ElementCounter.JavaScriptCounter;
import LinkProvider.GoogleLinkProvider;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static GoogleLinkProvider googleLinkProvider = new GoogleLinkProvider();
    private static JavaScriptCollector JSCollector = new JavaScriptCollector();
    private static JavaScriptCounter JSCounter = new JavaScriptCounter();

    public static void main(String[] args){

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the keyword:");

        String keyword = myObj.nextLine();

        System.out.println("******************************");

        List<String> searchResults = googleLinkProvider.getLinks(keyword);
        System.out.println("Search results : "+ searchResults.size());

        System.out.println("******************************");

        List<String> javascripts = JSCollector.getJavaScript(searchResults);
        System.out.println("JavaScripts found : "+ javascripts.size());

        System.out.println("******************************");

        Map<String, Integer> sortedTopN = JSCounter.getTopN(javascripts,5);

        System.out.println("Top 5 JavaScripts : ");
        for (String keyJS : sortedTopN.keySet()){
            System.out.println(keyJS + " = " + sortedTopN.get(keyJS));
        }
    }
}
