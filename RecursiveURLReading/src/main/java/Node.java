import java.util.ArrayList;
import java.util.List;

public class Node {

    private String link;
    private List<Node> children;
    private int level;

    public Node(String link) {
        this.link = link;
        children = new ArrayList<>();
    }

    public String getLink() {
        return link;
    }

    public void addChildren(Node node) {
        node.setLevel(level + 1);
        children.add(node);
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(link +  "\n");
        for(Node child : children)
        {
            builder.append("\t".repeat(level + 1) + child.toString());
        }
        return builder.toString();
    }


}
