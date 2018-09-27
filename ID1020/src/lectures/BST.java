package lectures;

/**
 * Created by Linus Bein Fahlander on 2018-09-19.
 */
public class BST {
    private Node root;
    private Integer N;

    private class Node {
        String value;
        String key;
        Node left;
        Node right;

        Node(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public String get(String key){
        if(this.root.key.equals(key)){
            return this.root.value;
        } else {
            return this.recGet(this.root, key);
        }
    }

    private String recGet(Node current, String key) {
        if(key.equals(current.key)){
            return current.value;
        }
        Integer compare = key.compareTo(current.key);
        if(compare > 0) {
            if(current.right == null){
                return null;
            }
            else {
                return this.recGet(current.right, key);
            }
        } else if(compare < 0) {
            if(current.left == null){
                return null;
            }
            else {
                return this.recGet(current.left, key);
            }
        }

        return null;
    }

    public void put(String key, String value){
        if(this.root == null){
            this.root = new Node(key, value);
        } else {
            recPut(this.root, key, value);
        }
        this.N++;
    }

    private void recPut(Node current, String key, String value){
        Integer compare = key.compareTo(current.key);
        if(compare > 0) {
            if (current.right == null) {
                current.right = new Node(key, value);
            } else {
                this.recPut(current.right, key, value);
            }
        } else if(compare == 0) {
            current.value = value;
        } else if(compare < 0) {
            if(current.left == null){
                current.left = new Node(key, value);
            }
            else {
                this.recPut(current.left, key, value);
            }
        }
    }

    private String print(Node root)
    {
        String result = "";
        if (root == null)
            return "";
        result += print(root.left) + "\n  " + root.value + "  " + print(root.right) + "\n";
        return result;
    }

    @Override
    public String toString(){
        return this.print(this.root);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.put("e", "val1");
        tree.put("c", "val2");
        tree.put("g", "val3");
        tree.put("b", "val4");
        tree.put("d", "val5");
        tree.put("f", "val6");
        tree.put("h", "val7");

        System.out.println(tree.N);
    }
}
