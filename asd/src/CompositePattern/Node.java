package CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int id;
    private String tag;
    private List<Node> children;

    public Node(int id, String tag) {
        this.id = id;
        this.tag = tag;
        children = new ArrayList<>();
    }

    public void addNode(Node node){
        children.add(node);
    }

    public List<Node> getChildren(){
        return children;
    }

    public int getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public void removeChildByTag(String tag){
        for (Node n:
             children) {
            if(n.getTag().compareTo(tag)==0){
                children.remove(n);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +",tag="+ tag+"}";
    }
}
