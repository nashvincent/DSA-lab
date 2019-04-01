import java.io.*;

class Node {
    public int rank;
    public String name;
    public Node lchild;
    public Node rchild;

    public Node (int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    public void displayRank() {
        System.out.println(rank + " ");
    }
    
    public void displayAll() {
        System.out.println("\nRank #" + rank + "\t" + name);
    }
}

class BinarySearchTree {
    public Node root;

    public void insert(int i, String j) {
        Node new1 = new Node(i, j);

        if (root == null) {
            root = new1;
        }

        else {
            Node cur = root;
            Node prev = null;

            while (true) {
                prev = cur;
                if (i < cur.rank) {
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

    public void search (int key) {
        Node cur = root;

        while ((cur.rank != key) && (cur != null)){
            if (cur.rank > key) 
                cur = cur.lchild;
            else 
                cur = cur.rchild;
        }
        if (cur == null)
            System.out.println("Not found");
        else
            cur.displayAll();
    }

    public void display (Node root1) {
        if (root1 == null) 
            return;
        display(root1.lchild);
        root1.displayRank();
        display(root1.rchild);
    }
}

class BST {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input the number of elements :");
        int n = Integer.parseInt(br.readLine());
        BinarySearchTree tree = new BinarySearchTree();

        System.out.println("Input the elements :");
        for (int i = 0; i < n; i++) {
            int t1 = Integer.parseInt(br.readLine());
            String t2 = br.readLine();
            tree.insert(t1, t2);
        }

        System.out.println("\nInput the rank to be searched for");
        int key = Integer.parseInt(br.readLine());
        tree.search(key);

        System.out.println("\nEntire list of students: ");
        tree.display(tree.root);
    }
}
