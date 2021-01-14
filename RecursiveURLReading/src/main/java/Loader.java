import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class Loader {
    public static void main(String[] args){

        Node node = new Node(args[0]);

        LinkCount linkCount = new LinkCount(node);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(linkCount);


        try (FileWriter writer = new FileWriter("mapSite.txt")) {
            writer.write(node.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
