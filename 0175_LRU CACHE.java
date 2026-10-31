INITILISE → GET → PUT → DELETE → INSERT
- GET: Find value → Delete → Move to Front → Return.
- PUT Existing: Update value → Delete node from curr position →Move to Front.
- No key + Space: Create new node →Insert at Front → Add (KEY, VAL) in Map.
- No key + Cache Full: Get LRU (tail.prev) → Remove KEY from Map → Delete LRU node → Create new node → Insert at Front → Add (KEY,VAL) in Map.
- DELETE: Connect neighbours.
- INSERT: Connect after head.
Map finds. DLL orders. Head = MRU. Tail = LRU.
-------------------------------------------------------------
