import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToolKitTest {

    @Test
    void isCorrectHTTPSubdomain() {
        String URL = "http://www.linkedin.com/legal/sas-terms#additional-terms-for-optional-conversion-tracking";
        String domain = "https://www.linkedin.com";
        assertEquals(true, ToolKit.isSubdomain(URL,domain));
    }

    @Test
    void isCorrectHTTPSSubdomain() {
        String URL = "https://www.linkedin.com/legal/sas-terms#additional-terms-for-optional-conversion-tracking";
        String domain = "http://www.linkedin.com";
        assertEquals(true, ToolKit.isSubdomain(URL,domain));
    }

    @Test
    void isNotCorrectSubdomain() {
        String URL = "http://www.linkedin.com/legal/sas-terms#additional-terms-for-optional-conversion-tracking";
        String domain = "https://www.facebook.com";
        assertEquals(false, ToolKit.isSubdomain(URL,domain));
    }
}