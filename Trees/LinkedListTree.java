package Trees;

import java.util.*;

class TreeNode {
    public String value;
    public TreeNode left;
    public TreeNode right;
    public int height;

    public TreeNode(String data) {
        value = data;
        left = null;
        right = null;
    }
}

public class LinkedListTree {
    static TreeNode root;

    public LinkedListTree() {
        root = null;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }


    public void preOrderIterative() {
        List<String> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            stack.pop();

            if (current != null) {
                arr.add(current.value);
                stack.push(current.right);
                stack.push(current.left);
            }
        }
        System.out.print("Pre-Order (iterative): ");
        System.out.print(arr);
        System.out.println();

    }

    public List<String> levelOrder() {
        List<String> arr = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return arr;
        }

        TreeNode current = root;
        queue.offer(current);

        while (!queue.isEmpty()) {
            current = queue.poll();
            arr.add(current.value);

            if (current.left != null) queue.offer(current.left);

            if (current.right != null) queue.offer(current.right);
        }
        return arr;
    }

    public boolean search(String target) {
        List<String> ans = levelOrder();

        return ans.contains(target);
    }

    public void insert(String data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            System.out.println("Root node Inserted");
        } else {
            Queue<TreeNode> q = new LinkedList<>();
            TreeNode current = root;
            q.offer(current);
            while (!q.isEmpty()) {
                current = q.poll();

                if (current.left != null) q.offer(current.left);
                else {
                    current.left = newNode;
                    break;
                }

                if (current.right != null) q.offer(current.right);
                else {
                    current.right = newNode;
                    break;
                }
            }
            System.out.println("Inserted");
        }

    }

    public TreeNode getDeepestNode() {
        List<TreeNode> allNodes = new ArrayList<>();
        TreeNode current = root;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(current);
        while (!q.isEmpty()) {
            current = q.poll();
            allNodes.add(current);
            if (current.left != null) q.offer(current.left);

            if (current.right != null) q.offer(current.right);
        }
        return allNodes.get(allNodes.size() - 1);
    }

    public String getAndDeleteDeepestNode() {
        TreeNode targetNode = getDeepestNode();
        TreeNode current = root;
        TreeNode parent = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(current);

        while (!q.isEmpty()) {
            current = q.poll();

            if (current == targetNode) {
                String ans = current.value;
                if (parent != null && parent.left == current) parent.left = null;
                else if (parent != null && parent.right == current) parent.right = null;
                return ans;
            }

            if (current.left != null) q.offer(current.left);

            if (current.right != null) q.offer(current.right);
            parent = current;
        }
        return "";
    }

    public void deleteNode(String target) {
        String deepNodeValue = getAndDeleteDeepestNode();
        TreeNode current = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(current);
        while (!q.isEmpty()) {
            current = q.poll();

            if (current.value == target) {
                current.value = deepNodeValue;
                break;

            }

            if (current.left != null) q.offer(current.left);

            if (current.right != null) q.offer(current.right);
        }
    }

    public static void main(String[] args) {
        LinkedListTree tree = new LinkedListTree();
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");
        tree.insert("E");
        tree.insert("F");
        System.out.println(tree.levelOrder());
        tree.deleteNode("B");
        System.out.println(tree.levelOrder());

        tree.preOrder(root);

    }
}
