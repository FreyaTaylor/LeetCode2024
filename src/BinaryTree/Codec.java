package src.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "none,";
        }
        return root.val+","+serialize(root.left)+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] val=data.split(",");
        Deque<String> q = new ArrayDeque<>();
        for (String s : val) {
            q.add(s);
        }

        return build(q);
    }

    public TreeNode build(Deque<String> q){
        if(q.getFirst().equals("none")){
            q.removeFirst();
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(q.removeFirst()));
        node.left=build(q);
        node.right=build(q);
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        treeNode.right.left=new TreeNode(4);
        treeNode.right.right=new TreeNode(5);

        String s = new Codec().serialize(treeNode);
        System.out.println(s);

        TreeNode n = new Codec().deserialize(s);
        System.out.println();
    }


}
