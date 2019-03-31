import java.io.*;


class Node {
    public int data;
    public Node lchild;
    public Node rchild;
    public boolean rthread;

    public Node (int data) {
        this.data = data;
        rthread = false;
    }

    public void displayNode() {
        System.out.println(data + " ");
    }
}

class SBTTClass {
    Node root;

    public void insert(int data) {
        Node new1 = new Node(data);

        if (root == null) {
            root = new1;
        }

        else {
            Node cur = root;
            Node prev = null;

            while (true) {
                prev = cur;
                if (data < cur.data) {
                        cur = cur.lchild;
                        if (cur == null) {
                            prev.lchild = new1;
                            new1.rthread = true;
                            new1.rchild = prev;
                            return;
                        }
                    }
                else {
                    if (!cur.rthread) {
                        cur = cur.rchild;
                        if (cur == null) {
                            prev.rchild = new1;
                            return;
                        }
                    }

                    else {
                        Node t = cur.rchild;
                        cur.rchild = new1;
                        cur.rthread = false;
                        new1.rthread = true;
                        new1.rchild = t;
                        return;
                    }
                }
            }
        }
    }

    public void inorder (Node root1) {
        Node p = root1;
        Node q = null;

        do {
            q = null;
            while (p != null) {
                q = p;
                p = p.lchild;
            }
            
            if (q != null) {
                q.displayNode();
                p = q.rchild;
                while (q.rthread && p != null) {
                    p.displayNode();
                    q = p;
                    p = q.rchild;
                }
            }
        } while (q != null);
    }
}

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        SBTTClass tree = new SBTTClass();

        tree.insert(100);
        tree.insert(50);
        tree.insert(25);
        tree.insert(7);
        tree.insert(99);
        tree.inorder(tree.root);
    }
}
