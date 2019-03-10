import static org.junit.jupiter.api.Assertions.*;

class CrawlerTest {

    @org.junit.jupiter.api.Test
    void doCrawling() {
        Crawler c = new Crawler("http://wiprodigital.com");
        c.doCrawling();
        assertNotEquals(0,c.getLinksSize());
    }
}