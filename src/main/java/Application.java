public class Application {

    public static void main(String[] args) {
        for (String s : args)
            new Crawler(s).doCrawling();
    }
}
