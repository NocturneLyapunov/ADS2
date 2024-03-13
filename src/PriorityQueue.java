import java.util.NoSuchElementException;
public class PriorityQueue {
    private Node root;

    class Node {
        public int key;
        public Node left, right,p,q;

        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
            this.p = null;
            this.q = this;
        }
    }

    public PriorityQueue() {
        root = null;
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            Node y = null;
            Node x = root;
            while (x != null) {
                y = x;
                if (x.key > key) {
                    x = x.left;
                }
                else x = x.right;
            }
            Node z = new Node(key);
            z.p = y;
            if (key > y.key) {
                y.right = new Node(key);
            }
            else y.left = new Node(key);
        }
    }

    public int extractMin() {
        if (root == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        Node y = null;
        Node x = root;
        while (x.left != null) {
            y = x;
            x = x.left;
        }
        int key = x.key;
        if (x == root) {
            root = root.right;
        }
        else {
            y.left = x.right;
        }
        return key;
    }

    public boolean isEmpty() {
        return root == null;
    }

    int min() {
        if (root == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        Node x = root;
        Node y = null;
        while (x.left != null) {
            y = x;
            x = x.left;
        }
        int key = x.key;
        return key;
    }

    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        q.insert(10);
        q.insert(5);
        q.insert(11);
        q.insert(3);
        q.insert(9);
        try {
            System.out.println(q.min());
            System.out.println(q.isEmpty());
            q.extractMin();
            System.out.println(q.min());
            q.extractMin();
            System.out.println(q);
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }


}




