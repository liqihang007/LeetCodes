//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

import java.util.*;

public class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value){
            prev = next = null;
            this.key = key;
            this.value = value;
        }
    }

//    public HashMap<Integer, Node> map; // for TestCases
    private HashMap<Integer, Node> map;
    private int cap;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>(capacity);
        cap = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node!=null){
            if(node!=head){ // move to head
                if(node.next!=null){
                    node.next.prev = node.prev;
                }
                node.prev.next = node.next;
                node.next = head;
                head.prev = node;
                head = node;
                if(node==tail){
                    tail = node.prev;       
                }
                node.prev = null;
            }
            return node.value;
        }
        else{
            return -1;
        }
    }

    public void set(int key, int value) {
        Node node = new Node(key, value);
        Node temp;
        if((temp=map.get(key))!=null) {
            map.remove(key);
            if(temp.prev!=null){
                temp.prev.next = temp.next;
            }
            if(temp.next!=null){
                temp.next.prev = temp.prev;
            }
            if(temp==tail){
                tail = temp.prev;
            }
            if(temp==head){
                head = temp.next;
            }
        }

        if(map.size()<cap){
            map.put(key,node);
            if(head!=null){
                head.prev = node;
                node.next = head;
                head = node;
            }
            else{
                tail = head = node;    
            }
        }
        else{//full
            map.remove(tail.key);
            if(tail.prev!=null){
                tail.prev.next = null;
                tail = tail.prev;
            }
            else{
                tail = head = null;
            }

            map.put(key, node);
            if(head!=null){
                head.prev = node;
                node.next = head;
                head = node;
            }
            else{
                tail = head = node;    
            }
        }
    }
}


//public class LRUCache {  // ArrayList version - TLE
//	private List<Integer> keylist;
//	private List<Integer> valuelist;
//	int size=0;
//	
//	public LRUCache(int capacity){
//		keylist=new ArrayList<Integer>();
//		valuelist=new ArrayList<Integer>();
//        if(capacity>0){size=capacity;}
//    }
//    
//    public int get(int key) {
//    	if(keylist.contains(key)){
//    		int i = keylist.indexOf(key);
//    		keylist.remove(i);
//    		int val=valuelist.remove(i);
//			keylist.add(key);
//    		valuelist.add(val);
//    		return val;
//    	}
//    	else{return -1;}
//    }
//    
//    public void set(int key, int value){
//    	int i=-1;
//    	if(keylist.size()>=size){
//    		i = keylist.contains(key) ? keylist.indexOf(key) : 0;
//    		keylist.remove(i);
//    		valuelist.remove(i);
//			keylist.add(value);
//    		valuelist.add(key);
//    	}
//    	else{
//			keylist.add(key);
//    		valuelist.add(key);
//    	}
//    }
//}
