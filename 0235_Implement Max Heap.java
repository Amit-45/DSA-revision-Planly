import java.util.*;
class Solution {
    List<Integer> arr=new ArrayList<>();

    // PARENT → COMPARE → SWAP → REPEAT UP
    private void heapifyUp(int ind) {
        int parent=(ind-1)/2;
        if(ind>0 && arr.get(ind)>arr.get(parent)) {
            swap(ind,parent);
            heapifyUp(parent);
        }
    }

    // CHILDREN → LARGEST → SWAP → REPEAT DOWN
    private void heapifyDown(int ind) {
        int n=arr.size(),largest=ind;
        int left=2*ind+1,right=2*ind+2;

        if(left<n && arr.get(left)>arr.get(largest))largest=left;
        if(right<n && arr.get(right)>arr.get(largest))largest=right;

        if(largest!=ind) {
            swap(ind,largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i,int j) {
        int temp=arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }

    // CLEAR HEAP
    public void initializeHeap() {
        arr.clear();
    }

    // ADD LAST → HEAPIFY UP
    public void insert(int key) {
        arr.add(key);
        heapifyUp(arr.size()-1);
    }

    // UPDATE → LARGER UP | SMALLER DOWN
    public void changeKey(int index,int newVal) {
        int old=arr.get(index);
        arr.set(index,newVal);

        if(newVal>old)heapifyUp(index);
        else heapifyDown(index);
    }

    // LAST TO ROOT → REMOVE LAST → HEAPIFY DOWN
    public void extractMax() {
        if(arr.isEmpty())return;

        int last=arr.remove(arr.size()-1);
        if(!arr.isEmpty()) {
            arr.set(0,last);
            heapifyDown(0);
        }
    }

    // CHECK EMPTY
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    // RETURN ROOT
    public int getMax() {
        return arr.get(0);
    }

    // RETURN SIZE
    public int heapSize() {
        return arr.size();
    }
}
