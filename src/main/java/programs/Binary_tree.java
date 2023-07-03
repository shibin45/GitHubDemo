package programs;

class Binary_tree {
    Node root;
    public int count=0;

    Binary_tree() {
        root = null;
    }
    void postorder_traversal(Node node, int treesize) {
        if (node == null)
            return;
        postorder_traversal(node.left,treesize);
        postorder_traversal(node.right,treesize);
        System.out.print(node.data+"\t");
        count++;
        if(count<treesize)
            System.out.print("->\t");
        if(count>=treesize)
            count=0;
    }

    void inorder_traversal(Node node, int treesize) {
        if (node == null)
            return;
        inorder_traversal(node.left,treesize);
        System.out.print(node.data+"\t");
        count++;
        if(count<treesize)
        System.out.print("->\t");
        if(count>=treesize)
            count=0;
        inorder_traversal(node.right,treesize);
    }
    void preorder_traversal(Node node, int treesize) {
        if (node == null)
            return;
        System.out.print(node.data+"\t");
        count++;
        if(count<treesize)
            System.out.print("->\t");
        if(count>=treesize)
            count=0;
        preorder_traversal(node.left,treesize);
        preorder_traversal(node.right,treesize);
    }
    public static void main(String[] args) {
        int treesize=0;
        Binary_tree tree = new Binary_tree();
        tree.root = new Node(10);
        treesize++;
        tree.root.left = new Node(12);
        treesize++;
        tree.root.right = new Node(30);
        treesize++;
        tree.root.right.right=new Node(20);
        treesize++;
        tree.root.left.left = new Node(15);
        treesize++;
        tree.root.left.right = new Node(25);
        treesize++;
        System.out.println("Inorder traversal");
        tree.inorder_traversal(tree.root,treesize);
        System.out.println("\nPreorder traversal ");
        tree.preorder_traversal(tree.root,treesize);
        System.out.println("\nPostorder traversal");
        tree.postorder_traversal(tree.root,treesize);
    }
}