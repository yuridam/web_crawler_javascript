package LinkProvider;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GoogleLinkProviderTest {

    private GoogleLinkProvider googleLinkProvider = new GoogleLinkProvider();


    // Test if given a keyword that yields 0 result would not pick up random href elements
    @Test
    public void getLinks_WithNoResult() {
        String gibberishKeyword = "dsakdjakjdkajdakdasdsd";
        List<String> result = googleLinkProvider.getLinks(gibberishKeyword);

        assertEquals(0, result.size());
    }
}