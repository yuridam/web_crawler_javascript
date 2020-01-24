package ElementCounter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class JavaScriptCounterTest {

    private JavaScriptCounter javaScriptCounter = new JavaScriptCounter();


    @Test
    public void getTopN_multipleJSWithSameName() {
        List<String> scripts = new ArrayList<>();
        scripts.add("javascript1");
        scripts.add("javascript1");
        scripts.add("javascript1");
        scripts.add("javascript1");
        scripts.add("javascript1");


        Map<String, Integer> actualResult = javaScriptCounter.getTopN(scripts, 5);
        Map<String, Integer> expectedResult  = new HashMap<String, Integer>() {{
            put("javascript1", 5);
        }};

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void getTopN_JSListFewerThanN() {
        List<String> scripts = new ArrayList<>();
        scripts.add("javascript1");
        scripts.add("javascript2");

        int N = 5;


        Map<String, Integer> actualResult = javaScriptCounter.getTopN(scripts, N);
        Map<String, Integer> expectedResult  = new HashMap<String, Integer>() {{
            put("javascript1", 1);
            put("javascript2", 1);
        }};

        assertEquals(expectedResult, actualResult);

    }
}