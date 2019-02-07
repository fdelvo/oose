package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawl {
    static Writer out;
    private static List<String> pagesToVisit = new LinkedList<>();
    private static Set<String> visitedUrls = new HashSet<>();

    public Crawl(String startURL, Writer out) {
        String startURL1 = startURL;
        Crawl.out = out;
    }

    public static void search(String startURL) throws IOException {
        int MAX_PAGES_TO_SEARCH = 20;
        while (visitedUrls.size() < MAX_PAGES_TO_SEARCH) {
            String currentUrl;
            if (visitedUrls.isEmpty()) {
                currentUrl = startURL;
                visitedUrls.add(startURL);
                System.out.println(visitedUrls);
            } else {
                currentUrl = nextUrl();
            }
            crawl(currentUrl);
        }
        out = new FileWriter("buffer.txt");
        for (String element : visitedUrls) {
            out.write(element);
        }
        out.close();
    }

    private static String nextUrl() {
        String nextUrl;
        do {
            nextUrl = pagesToVisit.remove(0);
        } while (visitedUrls.contains(nextUrl));
        visitedUrls.add(nextUrl);
        System.out.println(visitedUrls.size());
        return nextUrl;
    }

    public static void crawl(String urlString) {
        URL url;
        InputStream is = null;
        DataInputStream dis;
        Pattern LINK_PATTERN = Pattern.compile("(http:\\/\\/|https:\\/\\/|www[.])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&amp;@#/%=~_()|]");

        try {
            url = new URL(urlString);
            is = url.openStream();
            dis = new DataInputStream(new BufferedInputStream(is));
            String line;
            while ((dis.available() > 0)) {
                line = dis.readLine();
                if (line.contains("<a href=\"") && line.contains("http")) {
                    Matcher m = LINK_PATTERN.matcher(line);
                    if (m.find())
                    {
                        String theGroup = m.group(0);
                        pagesToVisit.add(theGroup + "\n");
                    }
                }
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            throw  new RuntimeException(ioe);
        } finally {
            try {
                is.close();
            } catch (IOException ioe) {
            }
        }
    }

    public void start() {

    }

    public static void main(String[] args) throws IOException {
        search("https://www.heise.de/");
    }
}
