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

        if (!root) {
            root = new1;
        }

        else {
            Node cur = root;
            Node prev = null;

            while (True) {
                prev = cur;
                if (data < cur.data)
                    cur = cur.left;
                    if (!cur) {
                        prev.left = new1;
                        new1.rthread = true;
                        new1.rchild = prev;
                        return;
                    }
                else {
                    if (!cur.rthread) {
                        cur = cur.right;
                        if (!cur) {
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
            while (p) {
                q = p;
                p = p.lchild;
            }
            
            if (q) {
                q.displayNode();
                p = q.rchild;
                while (q.rthread && p) {
                    p.displayNode();
                    q = p;
                    p = q.rchild;
                }
            }
        } while (q);
    }
}

public class SBTTree {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        SBTTClass tree = new SBTTClass();

        tree.insert(100);
        tree.insert(50);
        tree.insert(25);
        tree.insert(7);
        tree.insert(99);
    }
}

