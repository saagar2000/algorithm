package grind75;

import java.util.*;
import linkedlist.*;

public class LRUCache {
  public static void main(String[] args) {
    LRUCacheInternal lruCacheInternal = new LRUCacheInternal(10);
    lruCacheInternal.put(77, 2);
    lruCacheInternal.put(2, 4);
    lruCacheInternal.put(4, 5);
    lruCacheInternal.put(1, 6);
    lruCacheInternal.put(5, 9);
    lruCacheInternal.print();
  }

  private static class LRUCacheInternal {
    private final int capacity;
    private final Map<Integer, Node<Map.Entry<Integer, Integer>>> cache;
    private int size;
    private final Node<Map.Entry<Integer, Integer>> head;
    private final Node<Map.Entry<Integer, Integer>> tail;

    public LRUCacheInternal(int capacity) {
      this.capacity = capacity;
      cache = new HashMap<>(capacity);
      head = new Node<>(Map.entry(-1, -1));
      tail = new Node<>(Map.entry(-1, -1));
      head.next = tail;
      tail.prev = head;
      size = 0;
    }

    private void put(int key, int value) {
      if (size == capacity) {
        Node<Map.Entry<Integer, Integer>> remove = this.tail.prev;
        unlinkNode(remove);
        cache.remove(remove.data.getKey());
        size--;
      }
      Node<Map.Entry<Integer, Integer>> node;
      if (cache.containsKey(key)) {
        node = cache.get(key);
        node.data.setValue(value);
        moveToHead(node);
        size--;
      } else {
        node = new Node<>(new AbstractMap.SimpleEntry<>(key, value));
        addToHead(node);
      }
      size++;
      cache.put(key, node);
    }

    private int get(int key) {
      if (cache.containsKey(key)) {
        Node<Map.Entry<Integer, Integer>> node = cache.get(key);
        moveToHead(node);
        return node.data.getValue();
      }
      return -1;
    }

    private void print() {
        Node<Map.Entry<Integer, Integer>> current = head;
        while(current.next != tail) {
            Node<Map.Entry<Integer, Integer>> node = current.next;
            System.out.println(node.data);
            current = current.next;
        }
    }

    private void moveToHead(Node<Map.Entry<Integer, Integer>> node) {
      unlinkNode(node);
      addToHead(node);
    }

    private void unlinkNode(Node<Map.Entry<Integer, Integer>> node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    private void addToHead(Node<Map.Entry<Integer, Integer>> node) {
      //Head -> Current Node/New Node
      //head.next = current node
      //head.next.prev = current node backward pointer
      //node.next = new node forward pointer
      //node.prev = new node backward pointer
      node.prev = head;// set the new node backward pointer to head
      node.next = head.next; // set the new node forward pointer to current node
      head.next.prev = node; // set the current node backward pointer to new node
      head.next = node;  //set the head forward pointer to new node
    }
  }
}
