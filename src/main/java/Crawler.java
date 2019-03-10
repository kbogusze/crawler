import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class Crawler {
    private String domain;
    private HashSet<String> links = new HashSet<String>();
    private HashSet<String> externalLinks = new HashSet<String>();

    public Crawler(String domain) {
        this.domain = domain;
    }

    public void doCrawling()
    {
        explorePage(domain);
        printCrawlingResult();
    }

    private void printCrawlingResult() {
        System.out.println("\n Subdomains visited: \n");
        links.forEach(System.out::println);

        System.out.println("\n External links not visited: \n");
        externalLinks.forEach(System.out::println);
    }

    private void explorePage(String URL) {
        try {
            System.out.println("Currently in: " + URL);

            Document document = Jsoup.connect(URL).get();
            getMediaFromPage(document.select("[src]"));
            getLinksFromPage(document.select("a[href]"));
        } catch (IOException e) {
            System.err.println("For '" + URL + "': " + e.getMessage());
        }
    }

    private void getMediaFromPage(Elements media) {
        media.forEach(m -> System.out.println("Found static content: "+ m.attr("abs:src")));
    }

    private void getLinksFromPage(Elements linksOnPage) {
        linksOnPage.forEach(page -> {
            String link = page.attr("abs:href");
            if (ToolKit.isSubdomain(link,domain))
                exploreSubDomain(link);
            else
                externalLinks.add(link);
        });
    }

    private void exploreSubDomain(String link) {
        if (links.add(link))
            explorePage(link);
    }

    public int getLinksSize() {
        return links.size();
    }
}
