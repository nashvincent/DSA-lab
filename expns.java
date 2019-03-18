import java.io.*;

class Node {
    public int coeff, exp;
    public Node next;

    public Node (int a, int b) {
        coeff = a;
        exp = b;
    }

    public void displayNode() {
        System.out.println(coeff + "x^" + exponent + " ");
    }
}

class LinkedList {
    public Node first;
    public Node last;

    public void insert (int x, int y) {
        Node n1 = new Node(x, y);

        if (first == null)
            first = n1;
        
        else 
            last.next = n1;
         last = last.next;
    }

    public void display() {
        Node cur = first;
        while (cur != null) {
            cur.displayNode();
            cur = cur.next;
        }
    }
}

class Adder {
    public static void main (String args[]) throws IOException {
        // INPUT
    }

    public static void add (expn e1, expn e2) {
        LinkedList temp = new LinkedList();
        int x, y;
        Node cur1 = expn1.first;
        Node cur2 = expn2.first;

        while (cur1 != null && cur2 != null) {
            if (cur1.exp == cur2.exp) {
                x = cur1.coeff + cur2.coeff;
                y = cur1.exp;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            else if (cur1.exp > cur2.exp) {
                x = cur1.coeff;
                y = cur1.exp;
                cur1 = cur1.next;
            }

            else {
                x = cur2.coeff;
                y = cur2.exp;
                cur2= cur2.next;
            }

            temp.insert(x, y);
        }

        while(current1!=null) {
            x = cur1.coeff;
            y = cur1.exp;
            cur1=cur1.next;
            temp.insert(x,y);
        }

        while(current2!=null) {
            x=cur2.coeff;
            y=cur2.exp;
            cur2=cur2.next;
            temp.insert(x,y);
        }
    } // add
} // Adder
