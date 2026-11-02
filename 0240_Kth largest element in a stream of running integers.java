import java.util.*;

class KthLargest {
    private int K;
    private PriorityQueue<Integer> pq;

    // INITIALIZE → PROCESS INITIAL ARRAY → MAINTAIN SIZE K
    public KthLargest(int k,int[] nums) {
        K=k;
        pq=new PriorityQueue<>();

        for(int num:nums) {
            if(pq.size()<K)pq.offer(num);
            else if(num>pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
    }

    // NOT FULL: ADD | FULL: COMPARE ROOT → POLL + ADD
    public int add(int val) {
        if(pq.size()<K)pq.offer(val);
        else if(val>pq.peek()) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}
