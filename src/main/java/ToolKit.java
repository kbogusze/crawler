public class ToolKit {

    public static boolean isSubdomain(String URL, String domain)
    {
        return URL.toLowerCase().contains(domain.toLowerCase().replaceFirst("^https?", ""));
    }
}
