package Problem_List.Q432_All_O_one_Data_Structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {
    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Node head, tail;
    private Map<String, Node> keyMap;

    public AllOne() {
        head = new Node(-1);  // dummy head
        tail = new Node(-1);  // dummy tail
        head.next = tail;
        tail.prev = head;
        keyMap = new HashMap<>();
    }

    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            Node cur = keyMap.get(key);
            Node next = cur.next;
            if (next == tail || next.count != cur.count + 1) {
                Node newNode = new Node(cur.count + 1);
                insertAfter(cur, newNode);
                next = newNode;
            }
            next.keys.add(key);
            keyMap.put(key, next);
            cur.keys.remove(key);
            if (cur.keys.isEmpty()) remove(cur);
        } else {
            Node first = head.next;
            if (first == tail || first.count != 1) {
                Node newNode = new Node(1);
                insertAfter(head, newNode);
                first = newNode;
            }
            first.keys.add(key);
            keyMap.put(key, first);
        }
    }

    public void dec(String key) {
        if (!keyMap.containsKey(key)) return;

        Node cur = keyMap.get(key);
        if (cur.count == 1) {
            keyMap.remove(key);
        } else {
            Node prev = cur.prev;
            if (prev == head || prev.count != cur.count - 1) {
                Node newNode = new Node(cur.count - 1);
                insertAfter(prev, newNode);
                prev = newNode;
            }
            prev.keys.add(key);
            keyMap.put(key, prev);
        }

        cur.keys.remove(key);
        if (cur.keys.isEmpty()) remove(cur);
    }

    public String getMaxKey() {
        if (tail.prev == head) return "";
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.keys.iterator().next();
    }

    private void insertAfter(Node prev, Node node) {
        node.next = prev.next;
        node.prev = prev;
        prev.next.prev = node;
        prev.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey()); // "hello"
        System.out.println(allOne.getMinKey()); // "hello"
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey()); // "hello"
        System.out.println(allOne.getMinKey()); // "leet"
    }
}
