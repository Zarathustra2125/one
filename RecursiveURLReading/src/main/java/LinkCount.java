import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class LinkCount extends RecursiveAction {

    private final int MAX_COUNT_MS = 200;
    private final int MIN_COUNT_MS = 100;


    private Node node;
    private String url;
    private Elements elements;
    private Set<String> uniqueURL = new HashSet<>();

    public LinkCount(Node node) {
        this.node = node;
        this.url = node.getLink();

    }

    @Override
    protected void compute() {
        try {

            Document doc = connect();
            elements = doc.select("a");

            if (elements.isEmpty()) {
                return;
            }

            List<LinkCount> subTasks = new LinkedList<>();

            for (Element element : elements) {
                String link = element.attr("abs:href");
                if (isGoodLink(link) && !link.contains("pdf")) {
                    Node child = new Node(link);
                    LinkCount task = new LinkCount(child);
                    subTasks.add(task);
                    node.addChildren(child);
                }
            }

            ForkJoinTask.invokeAll(subTasks);

            for (LinkCount task : subTasks) {
                task.join();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean isGoodLink(String link) {
        String reg = "[\\w.:\\/]+";
        boolean add = uniqueURL.add(link);

        return add && link.contains(url)
                && !link.equals(url)
                && link.matches(reg);
    }

    private Document connect() throws IOException, InterruptedException {

        int countMS = MAX_COUNT_MS - MIN_COUNT_MS;
        Thread.sleep(((int) (Math.random() * ++countMS) + MIN_COUNT_MS));

        return Jsoup.connect(this.url)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .maxBodySize(0)
                .get();
    }

}
