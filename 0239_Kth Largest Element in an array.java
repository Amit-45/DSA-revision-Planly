BETTER:(MIN HEAP)SIZE K → INSERT FIRST K → COMPARE ROOT → POLL + ADD → RETURN ROOT
OPTIMAL(QUICK SELECT): TARGET k-1 → RANDOM PIVOT → PARTITION DESCENDING → CHECK INDEX → LEFT / RIGHT
---------------------------BETTER (Min Heap)-----------------------------------------
import java.util.*;

class Solution {
    // MIN HEAP OF SIZE K → ROOT IS KTH LARGEST
    public int kthLargestElement(int[] nums,int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<k;i++)
            pq.add(nums[i]);

        for(int i=k;i<nums.length;i++) {
            if(nums[i]>pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }
}

------------------------OPTIMAL(Quick select)-----------------------------------------------
import java.util.*;

class Solution {
    Random rand=new Random();

    // TARGET INDEX → PARTITION → SEARCH REQUIRED SIDE
    public int kthLargestElement(int[] nums,int k) {
        int left=0,right=nums.length-1;

        while(left<=right) {
            int pivot=randomIndex(left,right);
            pivot=partition(nums,pivot,left,right);

            if(pivot==k-1)return nums[pivot];
            else if(pivot>k-1)right=pivot-1;
            else left=pivot+1;
        }

        return -1;
    }

    // RANDOM INDEX WITHIN RANGE
    private int randomIndex(int left,int right) {
        return rand.nextInt(right-left+1)+left;
    }

    // GREATER LEFT → SMALLER/EQUAL RIGHT → PIVOT AT CORRECT INDEX
    private int partition(int[] nums,int pivotIndex,int left,int right) {
        int pivot=nums[pivotIndex];
        swap(nums,left,pivotIndex);

        int ind=left+1;

        for(int i=left+1;i<=right;i++) {
            if(nums[i]>pivot) {
                swap(nums,i,ind);
                ind++;
            }
        }

        swap(nums,left,ind-1);
        return ind-1;
    }

    private void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
