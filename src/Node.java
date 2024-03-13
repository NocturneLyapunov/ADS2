class Node
{
    int key;
    Node left, right;

    Node(int i)
    {
        key = i;
        left = right = null;
    }
}
class skewedBST
{
    public static Node node;
    static Node lastNode = null;
    static Node rootNode = null;

    static void skew(Node root, int size)
    {


        if(root == null)
        {
            return;
        }

        if(size > 0)
        {
            skew(root.right, size);
        }
        else
        {
            skew(root.left, size);
        }
        Node rightNode = root.right;
        Node leftNode = root.left;

        if(rootNode == null)
        {
            rootNode = root;
            root.left = null;
            lastNode = root;
        }
        else
        {
            lastNode.right = root;
            root.left = null;
            lastNode = root;
        }

        if (size > 0)
        {
            skew(leftNode, size);
        }
        else
        {
            skew(rightNode, size);
        }
    }


    public static void main (String[] args)
    {

        skewedBST tree = new skewedBST();
        tree.node = new Node(5);
        tree.node.left = new Node(3);
        tree.node.right = new Node(6);

        int size = 0;
        skew(node, size);

    }
}

