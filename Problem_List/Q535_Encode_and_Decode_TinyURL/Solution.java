package Problem_List.Q535_Encode_and_Decode_TinyURL;

import java.util.*;

public class Solution {
    private Map<String, String> longToShort = new HashMap<>();
    private Map<String, String> shortToLong = new HashMap<>();
    private int counter = 1;
    private final String BASE = "http://tinyurl.com/";

    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return longToShort.get(longUrl);
        }

        String shortUrl = BASE + counter++;
        longToShort.put(longUrl, shortUrl);
        shortToLong.put(shortUrl, longUrl);
        return shortUrl;
    }

    public String decode(String shortUrl) {
        return shortToLong.getOrDefault(shortUrl, "");
    }
}
