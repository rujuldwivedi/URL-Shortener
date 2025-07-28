import java.util.HashMap;

public class URLShortener
{
    private final String BASE_HOST = "http://short.url/";
    private final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final HashMap<String, String> keyToUrl = new HashMap<>();
    private final HashMap<String, String> urlToKey = new HashMap<>();
    private long counter = 1;

    public String shortenURL(String longUrl)
    {
        if(urlToKey.containsKey(longUrl))
        return BASE_HOST + urlToKey.get(longUrl);

        String key = encode(counter++);
        keyToUrl.put(key, longUrl);
        urlToKey.put(longUrl, key);

        return BASE_HOST + key;
    }

    public String expandURL(String shortUrl)
    {
        String key = shortUrl.replace(BASE_HOST, "");
        return keyToUrl.getOrDefault(key, null);
    }

    private String encode(long num)
    {
        StringBuilder sb = new StringBuilder();

        while (num > 0)
        {
            sb.append(BASE62.charAt((int)(num % 62)));
            num /= 62;
        }
        return sb.reverse().toString();
    }

    public void printAllMappings()
    {
        System.out.println("\n--- Stored URL Mappings ---");

        for (String key : keyToUrl.keySet())
        System.out.println(BASE_HOST + key + " -> " + keyToUrl.get(key));
    }
}
