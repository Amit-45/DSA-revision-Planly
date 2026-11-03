## Graphs – Memory Triggers

-----------------------------------------------------------------
Graph: VERTICES + EDGES
Directed: ONE-WAY
Undirected: TWO-WAY
Cyclic: START NODE → RETURN TO SAME NODE
Acyclic: NO CYCLE
Component: CONNECTED GROUP, DISCONNECTED FROM OTHER GROUPS
Path: CONNECTED NODES, NO REPEAT
Simple Path: NO REPEATED VERTEX
Closed Path: START = END
Undirected Degree: COUNT CONNECTED EDGES
Degree Property: SUM OF DEGREES = 2E
Directed Degree: IN = INCOMING | OUT = OUTGOING
Weighted: EDGE + COST
Unweighted: EDGE WITHOUT COST
-----------------------------------------------------------------
### 1. Graph Representation

- Adjacency Matrix – Directed: Matrix banao → Har edge uthao → `adj[u][v]=1`.
- Adjacency Matrix – Undirected: Matrix banao → Har edge uthao → `adj[u][v]=1` → `adj[v][u]=1`.
- Adjacency List – Directed: Graph banao → Har vertex ko empty neighbour list do → Har edge uthao → `v` ko `u` ke neighbours mein add karo.
- Adjacency List – Undirected: Graph banao → Har vertex ko empty neighbour list do → Har edge uthao → `u → v` → `v → u`.
- Matrix to List: Graph banao → Empty lists → Matrix par `i,j` loops → Edge mile toh `j` ko `i` ke neighbours mein add karo.

### 2. DFS and BFS

- DFS Function: Visit → Kaam karo → Neighbours par jao → Return.
- DFS Main: Saare vertices ko mauka do → `for` loop → Unvisited hai toh DFS call.
- BFS Function: Queue se nikalo → Visited mark karo → Work/Print → Unvisited neighbours ko visited mark karke Queue mein daalo.
- BFS Main: Saare vertices ko mauka do → `for` loop → Unvisited hai toh BFS call.
- DFS Recall: `VISIT → WORK → NEIGHBOURS → RETURN`.
- BFS Recall: `QUEUE → VISIT → WORK → NEIGHBOURS`.

### 3. Cycle Detection – Undirected Graph

- DFS: Visit → Kaam karo → Neighbours par jao → Unvisited: DFS call with parent → Visited + Not Parent: Cycle.
- BFS: Queue se nikalo → Already visited neighbour (not parent): Cycle → Otherwise visit → Neighbours ko Queue mein daalo with parent.
- Main: Saare vertices ko mauka do → Unvisited hai toh DFS/BFS call.
- Recall: `VISITED + NOT PARENT = CYCLE`.

### 4. Cycle Detection – Directed Graph (DFS)

- Visit → `visited=true` → `pathVisited=true`.
- Neighbours par jao:
  - Unvisited → DFS call.
  - Visited + PathVisited → Cycle.
  - Visited + Not PathVisited → Continue.
- Return time → `pathVisited=false`.
- Recall: `VISITED + PATH VISITED = CYCLE → RETURN: UNMARK PATH VISITED`.

### 5. Topological Sort – DFS (DAG)

- DFS Function: Visit → Kaam karo → Neighbours par jao → Return time par Stack mein push karo.
- Main: Saare vertices ko mauka do → Unvisited hai toh Topological DFS call.
- Output: Stack pop karo → Topological ordering.
- Recall: `DFS → NEIGHBOURS → RETURN TIME PUSH INTO STACK`.
- Faith: Mere saare dependencies mujhse pehle Stack mein aa chuke honge.

### 6. Topological Sort – BFS (Kahn's Algorithm)

- Main: Indegree array banao → Indegree fill karo → Indegree 0 walon ko Queue mein daalo.
- BFS: Queue se nikalo → Answer mein add karo → Neighbours ka indegree ghatao → Indegree 0 ho toh Queue mein daalo.
- Repeat: Jab tak Queue empty na ho.
- Recall: `INDEGREE → ZERO WALI QUEUE → REMOVE → ANSWER → NEIGHBOURS INDEGREE-- → ZERO: QUEUE`.

### 7. Cycle Detection – Directed Graph (Kahn's Algorithm)

- Same Kahn's Algorithm chalao.
- Queue se node nikalo → `countNodes++`.
- Neighbours ka indegree decrease karo → Zero ho toh Queue mein daalo.
- Queue empty hone ke baad `countNodes` compare karo.
- `countNodes == N` → No Cycle.
- `countNodes < N` → Cycle Exists.
- Recall: `KHAN'S → COUNT NODES → COUNT == N: NO CYCLE | COUNT < N: CYCLE`.

### 8. Final Quick Revision

- Matrix Directed: `adj[u][v]=1`.
- Matrix Undirected: `adj[u][v]=1 + adj[v][u]=1`.
- List Directed: `u → v`.
- List Undirected: `u → v + v → u`.
- DFS: `VISIT → WORK → NEIGHBOURS → RETURN`.
- BFS: `QUEUE → VISIT → WORK → NEIGHBOURS`.
- Undirected Cycle: `VISITED + NOT PARENT`.
- Directed Cycle: `VISITED + PATH VISITED`.
- Topo DFS: `RETURN TIME → STACK PUSH`.
- Topo BFS: `INDEGREE 0 → QUEUE → REMOVE → DECREASE`.
- Cycle using Kahn's: `COUNT == N: NO CYCLE | COUNT < N: CYCLE`.
