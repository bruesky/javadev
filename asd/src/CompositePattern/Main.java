package CompositePattern;

public class Main {
    public static void main(String[]args){
        Node root = new Node(0,"root");

        Node c1 = new Node(1,"child1");
        Node c2 = new Node(1,"child1");
        Node c3 = new Node(1,"child1");
        Node c4 = new Node(1,"child1");

        root.addNode(c1);
        root.addNode(c2);
        root.addNode(c3);
        root.addNode(c4);

        System.out.println(root);
        root.getChildren().stream().forEach(System.out::println);
    }
}
