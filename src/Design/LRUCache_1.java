package src.Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_1 {

    /**
     * https://leetcode.cn/problems/lru-cache/description/
     */
    Map<Integer,Integer> keyValue;
    Map<Integer,LinkNode> keyNode;
    LinkNode head;
    LinkNode tail;
    private int capacity;
    private int size;
    public LRUCache_1(int capacity) {
        this.capacity=capacity;
        keyValue = new HashMap<>();
        keyNode = new HashMap<>();
        head = new LinkNode(-1);
        tail = new LinkNode(-1);
        head.next=tail;
        tail.pre=head;
        size=0;
    }

    public int get(int key) {
        if(keyValue.containsKey(key)){
            head.remove(keyNode.get(key));
            head.addFirst(keyNode.get(key));
            return keyValue.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {

        if(keyValue.containsKey(key)){
            keyValue.put(key,value);
            LinkNode node = keyNode.get(key);
            head.remove(node);
            head.addFirst(node);
        }else {
            if(size>=capacity){
                keyValue.remove(tail.pre.key);
                head.removeLast();
            }
            keyValue.put(key,value);
            LinkNode node = new LinkNode(key);
            keyNode.put(key,node);
            head.addFirst(node);
        }



    }

    class LinkNode{
        private int key;
        private LinkNode pre;
        private LinkNode next;


        public LinkNode(int key){
            this.key=key;
        }

        public void remove(LinkNode node){
            node.pre.next=node.next;
            node.next.pre=node.pre;
            size--;
        }

        public void removeLast(){
            remove(tail.pre);
        }

        public void addFirst(LinkNode node){
            keyNode.put(node.key,node);
            head.next.pre=node;
            node.next=head.next;
            head.next=node;
            node.pre=head;
            size++;

        }

    }


    public static void main(String[] args) {

        LRUCache_1 lRUCache = new LRUCache_1(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }


}
