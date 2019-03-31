import java.io.*;

class Node {
    public int data;
    public Node lchild;
    public Node rchild;

    public Node (int data) {
        this.data = data;
    }

    public void displayNode() {
        System.out.println(data + " ");
    }
}

class BinarySearchTree {
    public Node root;

    public void insert(int i) {
        Node new1 = new Node(i);

        if (root == null) {
            root = new1;
        }

        else {
            Node cur = root;
            Node prev = null;

            while (true) {
                prev = cur;
                if (i < cur.data) {
                    cur = cur.lchild;
                    if (cur == null) {
                        prev.lchild = new1;
                        return;
                    }
                }

                else {
                    cur = cur.rchild;
                    if (cur == null) {
                        prev.rchild = new1;
                        return;
                    }
                }
            }
        }
    }

    public void inorderRecursion(Node root1) {
        inorderRecursion(root1.lchild);
        root1.displayNode();
        inorderRecursion(root1.rchild);
    }

    public void preorderRecursion(Node root1) {
        root1.displayNode();
        preorderRecursion(root1.lchild);
        preorderRecursion(root1.rchild);
    }

    public void postorderRecursion(Node root1) {
        postorderRecursion(root1.lchild);
        postorderRecursion(root1.rchild);
        root1.displayNode();
    }

    public void inorder(Node root1) {
        Node p = root1;
        Stack s = new Stack(20);

        while (p != null) {
            s.push(p);
            p = p.lchild;
        }

        if (!s.isEmpty) {
            // TO DO
        }

    }
}
