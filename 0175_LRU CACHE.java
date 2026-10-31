INITILISE → GET → PUT → DELETE → INSERT
- GET: Find value → Delete → Move to Front → Return.
- PUT Existing: Update value → Delete node from curr position →Move to Front.
- No key + Space: Create new node →Insert at Front → Add (KEY, VAL) in Map.
- No key + Cache Full: Get LRU (tail.prev) → Remove KEY from Map → Delete LRU node → Create new node → Insert at Front → Add (KEY,VAL) in Map.
- DELETE: Connect neighbours.
- INSERT: Connect after head.
Map finds. DLL orders. Head = MRU. Tail = LRU.
-------------------------------------------------------------
import java.util.*;
class Node {
    int key,val;
    Node prev,next;
    Node(int key,int val) {
        this.key=key;
        this.val=val;
    }
}

class LRUCache {
    private Map<Integer,Node> map;
    private int cap;
    private Node head,tail;
    // 1. INITIALISE: Create Map, Dummy Head and Tail, and connect them
    public LRUCache(int capacity) {
        cap=capacity;
        map=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    // 2. GET: Find value → Delete → Move to Front → Return
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        int value=node.val;
        deleteNode(node);
        insertAfterHead(node);
        return value;
    }
    // 3. PUT: Check if key exists → YES / NO
    public void put(int key,int value) {
        // PUT Existing: Update value → Delete node from current position → Move to Front
        if(map.containsKey(key)) {
            Node node=map.get(key);
            node.val=value;
            deleteNode(node);
            insertAfterHead(node);
            return;
        }
        // No key + Cache Full: Get LRU → Remove KEY from Map → Delete LRU node
        if(map.size()==cap) {
            Node lru=tail.prev;
            map.remove(lru.key);
            deleteNode(lru);
        }
        // No key + Space / Cache Full: Create new node → Insert at Front → Add (KEY,VAL) in Map
        Node newNode=new Node(key,value);
        insertAfterHead(newNode);
        map.put(key,newNode);
    }
    // 4. DELETE helper function: Connect neighbours
    private void deleteNode(Node node) {
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }
    // 5. INSERT helper function: Connect after head
    private void insertAfterHead(Node node) {
        Node nextNode=head.next;
        head.next=node;
        nextNode.prev=node;
        node.prev=head;
        node.next=nextNode;
    }
}
