package ElementCollector;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class JavaScriptCollector {

    public List<String> getJavaScript(List<String> links){

        List<String> scripts = new Vector<>();
        List<JavaScriptCollectorThread> threads = new ArrayList<>();

        for (String link : links){
            threads.add(new JavaScriptCollectorThread(link, scripts));

        }

        for (JavaScriptCollectorThread javaScriptCollectorThread : threads){
            while (javaScriptCollectorThread.isAlive()){
                try {
                    javaScriptCollectorThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return scripts;
    }
}
