package store1;

/**
 * Binary Search Tree implementation
 *
 * @param <Key>
 * @param <T>
 */
public class BST<Key extends Comparable<? super Key>, T> {

    private BSTNode<Key, T> root; // Root of the BST
    int size; // Number of nodes in the BST

    BST() {
        root = null;
        size = 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public BSTNode<Key, T> getRoot() {
        return root;
    }

    public void setRoot(BSTNode<Key, T> root) {
        if(root == null) 
            size=0;
        else size =1;
        
        this.root = root;
    }

    /**
     * Insert a record into the tree.
     *
     * @param k Key value of the record.
     * @param e The record to insert.
     */
    public void insert(Key k, T e) {
        root = inserthelp(root, k, e);
        size++;
    }

    /**
     * @return The current subtree, modified to contain the new item
     */
    private BSTNode<Key, T> inserthelp(BSTNode<Key, T> rt, Key k, T e) {
        if (rt == null) {
            return new BSTNode<Key, T>(k, e);
        }
        if (rt.getKey().compareTo(k) > 0) {
            rt.setLeft(inserthelp(rt.getLeft(), k, e));
        } else {
            rt.setRight(inserthelp(rt.getRight(), k, e));
        }
        return rt;
    }

    public T find(Key k) {
        return findhelp(root, k);
    }

    private T findhelp(BSTNode<Key, T> rt, Key k) {
        if (rt == null) {
            return null;
        }
        if (rt.getKey().compareTo(k) > 0) {
            return findhelp(rt.getLeft(), k);
        } else if (rt.getKey().compareTo(k) == 0) {
            return rt.getData();
        } else {
            return findhelp(rt.getRight(), k);
        }
    }

    public T remove(Key k) {
        T temp = findhelp(root, k); // First find it
        if (temp != null) {
            root = removehelp(root, k); // Now remove it
            size--;
        }
        return temp;
    }

    private BSTNode<Key, T> removehelp(BSTNode<Key, T> rt, Key k) {
        if (rt == null) {
            return null;
        }
        if (rt.getKey().compareTo(k) > 0) {
            rt.setLeft(removehelp(rt.getLeft(), k));
        } else if (rt.getKey().compareTo(k) < 0) {
            rt.setRight(removehelp(rt.getRight(), k));
        } else {
// Found it
            if (rt.getLeft() == null) {
                return rt.getRight();
            } else if (rt.getRight() == null) {
                return rt.getLeft();
            } else {
// Two children
                BSTNode<Key, T> temp = getmin(rt.getRight());
                rt.setData(temp.getData());
                rt.setKey(temp.getKey());
                rt.setRight(deletemin(rt.getRight()));
            }
        }
        return rt;
    }

    private BSTNode<Key, T> deletemin(BSTNode<Key, T> rt) {
        if (rt.getLeft() == null) {
            return rt.getRight();
        }
        rt.setLeft(deletemin(rt.getLeft()));
        return rt;
    }

    public BSTNode<Key, T> getmin(BSTNode<Key, T> rt) {
        if (rt.getLeft() == null) {
            return rt;
        }
        return getmin(rt.getLeft());
    }

    public void inOrder(BSTNode<Key, T> p) {
        if (p != null) {
            inOrder(p.getLeft());
            System.out.print(" , "+p.getKey());
            inOrder(p.getRight());
        }
        
    }

    public boolean isInternal(BSTNode<Key, T> p) {
        if (p != null) {
            if (p.getLeft() != null || p.getRight() != null) {
                return true;
            }
        }

        return false;

    }

    // The following methods used to draw the Binary Tree 
    public int layout(BSTNode<Key, T> p, int d, int x) {
        if (p != null) {
            if (p.getLeft() != null) {
                x = layout(p.getLeft(), d + 1, x);
            }
            p.setX(x++);
            p.setY(d);
            if (p.getRight() != null) {
                x = layout(p.getRight(), d + 1, x);
            }
            return x;
        }
        return x;
    }

    public void draw(BSTNode<Key, T> p) {
        if (p != null) {
            int x, y;
            int i = 0, j = 0;
            System.out.print("   ");
            int m = layout(p, 0, 0);
            for (int k = 0; k <= m; k++) {
                System.out.printf("%3d", k);
            }
            System.out.println();
            System.out.printf("%3d", i);
            TQueue<Key, BSTNode<Key, T>> tq = new TQueue<Key, BSTNode<Key, T>>();
            tq.enqueue(p);
            while (!tq.isEmpty()) {
                BSTNode<Key, T> n = tq.dequeue();
                if (n != null) {
                    x = n.getX();
                    y = n.getY();
                    while (y > i) {
                        for (; j <= m; j++) {
                            System.out.printf("...");
                        }
                        System.out.println();
                        i++;
                        j = 0;
                        System.out.printf("%3d", i);
                    }
                    while (x > j - 1) {
                        System.out.print("...");
                        j++;
                    }
                    System.out.print(String.format("%3s", n.getData()).replace(' ', '.'));
                    j++;
                    if (n.getLeft() != null) {
                        tq.enqueue(n.getLeft());
                    }
                    if (n.getRight() != null) {
                        tq.enqueue(n.getRight());
                    }
                }
            }
            for (; j <= m; j++) {
                System.out.printf("...");
            }
            System.out.println();

        }

    }

    //************************************************************************
    public BSTNode<Key, T> getMax(BSTNode<Key, T> p) {
        if (p != null) {
            if (p.getRight() == null) {
                return p;
            }
            return getMax(p.getRight());
        }
        return null;
    }

    public BSTNode<Key, T> parent(BSTNode<Key, T> p) {
        if (p != null && p != root) {
            return getParent(root, p);
        }
        return null;
    }

    private BSTNode<Key, T> getParent(BSTNode<Key, T> r, BSTNode<Key, T> p) {
        if (r != null) {
            if (r.getLeft() == p || r.getRight() == p) {
                return r;
            } else if (p.getKey().compareTo(r.getKey()) > 0) {
                return getParent(r.getRight(), p);
            } else {
                return getParent(r.getLeft(), p);
            }
        }
        return null;
    }

    public BSTNode<Key, T> deleteLeaves(BSTNode<Key, T> p) {
        if (p == null) {
            return null;
        }
        if (p.isLeaf()) {
            if (p == root) {
                root = null;
            }
            size--;
            return null;
        } else {
            p.setLeft(deleteLeaves(p.getLeft()));
            p.setRight(deleteLeaves(p.getRight()));
            return p;
        }
    }

    public int toSortedArray(BSTNode<Key, T> p, Key[] a, int i) {
        if (p != null) {
            i = toSortedArray(p.getLeft(), a, i);
            a[i++] = p.getKey();
            i = toSortedArray(p.getRight(), a, i);

        }
        return i;
    }

    //****************************************************************************
}

class BSTNode<Key, T> {

    private Key key;
    private T data;
    private BSTNode<Key, T> left;
    private BSTNode<Key, T> right;
    private int x, y;

    public BSTNode() {
        left = right = null;
    }

    public BSTNode(Key key, T data) {
        this.key = key;
        this.data = data;
        left = right = null;
    }

    public BSTNode(Key key, T data, BSTNode<Key, T> left,
            BSTNode<Key, T> right) {
        this.key = key;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BSTNode<Key, T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<Key, T> left) {
        this.left = left;
    }

    public BSTNode<Key, T> getRight() {
        return right;
    }

    public void setRight(BSTNode<Key, T> right) {
        this.right = right;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

}

class TQueue<Key, T> {

    private BSTNode<Key, T> head;
    private BSTNode<Key, T> tail;
    private int size;

    public TQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(T e) {
        BSTNode<Key, T> n = new BSTNode<Key, T>();
        n.setData(e);
        if (tail == null) {
            head = n;
            tail = n;
        } else {
            tail.setRight(n);
            tail = n;
        }
        size++;
    }

    public T dequeue() {
        if (head != null) {
            T e = head.getData();
            head = head.getRight();
            if (head == null) {
                tail = null;
            }
            size--;
            return e;
        }
        return null;
    }

    public T first() {
        if (head != null) {
            return head.getData();
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void print() {
        BSTNode<Key, T> n = head;
        while (n != null) {
            System.out.println(n.getData());
            n = n.getRight();
        }
    }
}
