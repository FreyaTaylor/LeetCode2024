package src.Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    LinkNode head;
    LinkNode tail;

    Map<Integer,LinkNode> map;
    private int capacity;
    private int size;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head = new LinkNode(-1,-1);
        tail = new LinkNode(-1,-1);
        head.next=tail;
        tail.pre=head;
        map = new HashMap<>();
        size=0;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            LinkNode node = map.get(key);
            del(node);
            add2head(node);
            return node.val;
        }
        return -1;

    }

    public void del(LinkNode node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    public void add2head(LinkNode node){
        head.next.pre=node;
        node.next=head.next;
        head.next=node;
        node.pre=head;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            LinkNode node = map.get(key);
            node.val=value;
            del(node);
            add2head(node);
        }else {
            if(size>=capacity){
                map.remove(tail.pre.key);
                del(tail.pre);
                size--;
            }
            LinkNode node = new LinkNode(key,value);
            add2head(node);
            map.put(key,node);
            size++;
        }

    }


    class LinkNode {
        private int key;
        private int val;
        private LinkNode pre;
        private LinkNode next;

        public LinkNode(int key, int val){
            this.key = key;
            this.val=val;
        }

    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 0); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=0, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 0
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }
}
