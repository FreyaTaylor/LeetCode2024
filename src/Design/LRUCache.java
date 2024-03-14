package src.Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /**
     * https://leetcode.cn/problems/lru-cache/description/
     *
     * 代码优化：
     * 类LinkNode的功能尽可能少
     * 判断capacity和维护keyNode，在主类的方法里面实现，而非类LinkNode
     *
     */

    Map<Integer,LinkNode> keyNode;
    LinkNode head;
    LinkNode tail;
    private int capacity;
    private int size;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        keyNode = new HashMap<>();
        head = new LinkNode(-1,-1);
        tail = new LinkNode(-1,-1);
        head.next=tail;
        tail.pre=head;
        size=0;
    }

    public int get(int key) {
        if(keyNode.containsKey(key)){
            remove(keyNode.get(key));
            addFirst(keyNode.get(key));
            return keyNode.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {

        if(keyNode.containsKey(key)){
            LinkNode node = keyNode.get(key);
            node.value=value;
            remove(node);
            addFirst(node);
        }else {
            if(size>=capacity){
                keyNode.remove(tail.pre.key);
                removeLast();
                size--;
            }
            LinkNode node = new LinkNode(key,value);
            keyNode.put(key,node);
            addFirst(node);
            size++;
        }
    }

    public void remove(LinkNode node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    public void removeLast(){
        remove(tail.pre);
    }

    public void addFirst(LinkNode node){
        head.next.pre=node;
        node.next=head.next;
        head.next=node;
        node.pre=head;
    }

    class LinkNode{
        private int key;
        private int value;
        private LinkNode pre;
        private LinkNode next;

        public LinkNode(int key,int value){
            this.key=key;
            this.value=value;
        }


    }




    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);
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
