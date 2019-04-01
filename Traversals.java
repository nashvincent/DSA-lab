import java.io.*;
import java.util.Stack;

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
        if (root1 == null) 
            return;
        inorderRecursion(root1.lchild);
        root1.displayNode();
        inorderRecursion(root1.rchild);
    }

    public void preorderRecursion(Node root1) {
        if (root1 == null) 
            return;
        root1.displayNode();
        preorderRecursion(root1.lchild);
        preorderRecursion(root1.rchild);
    }

    public void postorderRecursion(Node root1) {
        if (root1 == null) 
            return;
        postorderRecursion(root1.lchild);
        postorderRecursion(root1.rchild);
        root1.displayNode();
    }

    public void inorder(Node root1) {
        Node p = root1;
        Stack<Node> s = new Stack<Node>();

        do {
            while (p != null) {
                s.push(p);
                p = p.lchild;
            }

            if (!s.empty()) {
                p = s.pop();
                p.displayNode();
                p = p.rchild;
            }
        } while(!s.empty() || p != null);
    }

    public void preoder(Node root1) {
        Stack<Node> s = new Stack<Node>();
        s.push(root1);

        while (!s.empty()) {
            Node temp = s.pop();
            temp.displayNode();

            if (temp.rchild != null)
                s.push(temp.rchild);
            if (temp.lchild != null)
                s.push(temp.lchild);
        }
    }

    public void postorder(Node root1) {
        Stack<Node> s1 = new Stack<Node>(); 
        Stack<Node> s2 = new Stack<Node>(); 
  
        if (root1 == null) 
            return; 
  
        s1.push(root1);  
        while (!s1.isEmpty()) { 

            Node temp = s1.pop(); 
            s2.push(temp); 

            if (temp.lchild != null) 
                s1.push(temp.lchild); 
            if (temp.rchild != null) 
                s1.push(temp.rchild); 
        } 
        while (!s2.isEmpty()) { 
            Node temp = s2.pop(); 
            System.out.print(temp.data + " ");  
        } 
    }
}

class Traversals {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input the number of elements :");
        int n = Integer.parseInt(br.readLine());
        BinarySearchTree tree = new BinarySearchTree();

        System.out.println("Input the elements :");
        for (int i = 0; i < n; i++)
            tree.insert(Integer.parseInt(br.readLine()));

        System.out.println("Inorder using recursion: ");
        tree.inorderRecursion(tree.root);

        System.out.println("\nPreorder using recursion: ");
        tree.preorderRecursion(tree.root);

        System.out.println("\nPostorder using recursion: ");
        tree.postorderRecursion(tree.root);
        
        System.out.println("\nInorder without recursion: ");
        tree.inorder(tree.root);

        System.out.println("\nPreorder without recursion: ");
        tree.preoder(tree.root);

        System.out.println("\nPostorder without recursion: ");
        tree.postorder(tree.root);
    }
}
