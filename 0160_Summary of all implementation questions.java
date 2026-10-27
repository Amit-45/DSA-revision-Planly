-----------------------------------------------
Implement Stack Using Array
-----------------------------------------------
-Initialize: Create array → topIndex=-1.
-Push: Check full → Increment topIndex → Insert element.
-Pop: Check empty → Read top value → Decrement topIndex.
-Top: Check empty → Read arr[topIndex].
-IsEmpty: Check topIndex==-1.
-----------------------------------------------
Implement Queue using Array 
------------------------------------------------
-Initialize: Create array → Initialize pointers → currSize=0.
-Push: Check full → Initialize or move end → Insert element → Increase size.
-Pop: Check empty → Read front value → Reset or move start → Decrease size.
-Peek: Check empty → Read front value.
-IsEmpty: Check currSize==0.
-Circular Movement: (index+1)%maxSize.
-------------------------------------------------
Implement Stack using Queue
-------------------------------------------------
-Initialize: Create queue.
-Push: Add x at rear → Rotate previous elements from front to rear.
-Pop: Check empty → Remove front element.
-Top: Check empty → Read front element.
-IsEmpty: Check if queue is empty.
--------------------------------------------------
Implement Queue using Stack 
--------------------------------------------------
O(n) push method using 2 stacks:-
-Initialize: Create stacks s1 and s2.
-Push: Move all elements from s1 to s2 → Push new element into s1 → Move all elements back from s2 to s1.
-Pop: Check empty → Pop from s1.
-Peek: Check empty → Read top of s1.
-IsEmpty: Check if s1 is empty.
-----------------------------------------------------
O(1) push method using 2 stacks:-
-Initialize: Create stacks s1 and s2.
-Push: Push element into s1.
-Pop: Check empty → If s2 is empty, transfer all elements from s1 to s2 → Pop from s2.
-Peek: Check empty → If s2 is empty, transfer s1 to s2 → Read top of s2.
-IsEmpty: Check if both s1 and s2 are empty.
--------------------------------------------------
Implement stack using linked list
--------------------------------------------------
-Initialize: top=null → Size=0.
-Push: Create node → Point new node to old top → Move top to new node → Increase size.
-Pop: Check empty → Read top value → Move top to next node → Decrease size.
-Top: Check empty → Read top value.
-IsEmpty: Check size==0.
----------------------------------------------------
Implement queue using linked list
-----------------------------------------------------
-Initialize: Start and end are null → Size=0.
-Push: Create node → If empty, start=end=node → Otherwise, link end to new node → Move end to new node → Increase size.
-Pop: Check empty → Read start value → Move start to next node → Decrease size → If start is null, reset end to null.
-Peek: Check empty → Read start value.
-IsEmpty: Check size==0.
