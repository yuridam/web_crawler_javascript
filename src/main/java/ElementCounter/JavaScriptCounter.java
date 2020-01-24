package ElementCounter;

import java.util.*;

public class JavaScriptCounter {


    public Map<String, Integer> getTopN(List<String> javascripts, Integer N){

        //Create an empty TreeMap so that the javascripts will be sorted by their name
        Map<String, Integer> unsortedMap = new TreeMap<>();
        for (String js: javascripts) {
            unsortedMap.put(js, unsortedMap.getOrDefault(js, 0) +1);
        }

        if (javascripts.size() < N) N = javascripts.size();

        //Create an empty LinkedHashMap to store the top N of javascripts but still retaining their name order
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

        //Sort by value
        unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(N)
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        return sortedMap;
    }
}
