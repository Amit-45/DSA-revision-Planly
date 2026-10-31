2 HASHMAPS + Multiple DLLS + minFreq + Count

INITIALIZATION
  → Initialize 2 HashMaps
  → minFreq = 0
  → curSize = 0

GET(key)
  → Key exists?
      NO  → Return -1
      YES → Get node → Store value
            → Update frequency
            → Return value

PUT(key,value)
  → Key exists?
      YES → Get node → Update value
            → Update frequency → Return

      NO  → Cache full?
              YES → Get minFreq DLL
                    → Get LRU (tail.prev)
                    → Remove from keyNode
                    → Remove from DLL
                    → Decrease curSize

              NO  → Skip eviction

            → After either branch (YES/NO):
                → Create new node (freq = 1)
                → Get/Create freq 1 DLL
                → Insert at front (MRU)
                → Add to keyNode
                → minFreq = 1
                → Increase curSize
                → Return

UPDATE FREQUENCY
  → Remove from old DLL
  → Update minFreq if old DLL becomes empty
  → Increase frequency
  → Insert into new frequency DLL
  → Update keyNode

----------------------------------------------------------------
class LFUCache {
    class Node {
        int key,value,cnt;
        Node prev,next;
        Node(int key,int value) {
            this.key=key;
            this.value=value;
            this.cnt=1;
        }
    }
    class DLL {
        Node head,tail;
        int size;
        DLL() {
            head=new Node(-1,-1);
            tail=new Node(-1,-1);
            head.next=tail;
            tail.prev=head;
            size=0;
        }
        // Insert node at front (MRU)
        void addFront(Node node) {
            Node first=head.next;
            node.next=first;
            node.prev=head;
            head.next=node;
            first.prev=node;
            size++;
        }
        // Remove node from DLL
        void removeNode(Node node) {
            Node before=node.prev;
            Node after=node.next;
            before.next=after;
            after.prev=before;
            size--;
        }
    }
    int capacity,curSize,minFreq;
    HashMap<Integer,Node> keyNode;
    HashMap<Integer,DLL> freqListMap;
    LFUCache(int capacity) {
        this.capacity=capacity;
        curSize=0;
        minFreq=0;
        keyNode=new HashMap<>();
        freqListMap=new HashMap<>();
    }
    // GET: Find → Store value → Update frequency → Return
    public int get(int key) {
        if(!keyNode.containsKey(key)) return -1;
        Node node=keyNode.get(key);
        int value=node.value;
        updateFreqListMap(node);
        return value;
    }
    // PUT: Check key exists → Update OR Insert new key
    public void put(int key,int value) {
        if(capacity==0) return;
        // CASE 1: Key already exists
        if(keyNode.containsKey(key)) {
            Node node=keyNode.get(key);
            node.value=value;
            updateFreqListMap(node);
            return;
        }
        // CASE 2: Key does not exist
        // Check whether cache is full
        if(curSize==capacity) {
            DLL list=freqListMap.get(minFreq);
            // Get LRU node from minimum frequency DLL
            Node lruNode=list.tail.prev;
            // Remove key from HashMap and node from DLL
            keyNode.remove(lruNode.key);
            list.removeNode(lruNode);
            curSize--;
        }
        // Create new node with frequency 1
        Node node=new Node(key,value);
        // Get or create frequency 1 DLL
        DLL list=freqListMap.getOrDefault(1,new DLL());
        // Insert node at front (MRU)
        list.addFront(node);
        // Update both HashMaps
        freqListMap.put(1,list);
        keyNode.put(key,node);
        // New node starts with frequency 1
        minFreq=1;
        curSize++;
    }
    // Remove node from old frequency → Increase frequency → Insert into new DLL
    private void updateFreqListMap(Node node) {
        int oldFreq=node.cnt;
        // Remove node from keyNode and old frequency DLL
        keyNode.remove(node.key);
        DLL oldList=freqListMap.get(oldFreq);
        oldList.removeNode(node);
        // If minimum frequency DLL becomes empty, increase minFreq
        if(oldFreq==minFreq && oldList.size==0) {
            minFreq++;
        }
        // Increase node frequency
        node.cnt++;
        // Get or create new frequency DLL
        DLL newList=freqListMap.getOrDefault(node.cnt,new DLL());
        // Insert node at front (MRU)
        newList.addFront(node);
        // Update both HashMaps
        freqListMap.put(node.cnt,newList);
        keyNode.put(node.key,node);
    }
}
