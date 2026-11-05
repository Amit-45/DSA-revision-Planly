import java.util.*;
class Solution {

    // START == END → RETURN 0
    public int minimumMultiplications(int[] arr,int start,int end) {

        if(start==end) return 0;

        int mod=100000;

        // DIST = INFINITY
        int[] dist=new int[mod];
        Arrays.fill(dist,Integer.MAX_VALUE);

        // QUEUE → ADD SOURCE {STEPS, VALUE}
        Queue<int[]> q=new LinkedList<>();

        dist[start]=0;
        q.add(new int[]{0,start});

        while(!q.isEmpty()) {

            int[] curr=q.poll(); // POLL → GET STEPS + VALUE

            int steps=curr[0],val=curr[1];

            // TRAVERSE ARRAY → TRY ALL MULTIPLIERS
            for(int i=0;i<arr.length;i++) {

                int newValue=(val*arr[i])%mod; // MULTIPLY + MOD

                int newSteps=steps+1; // NEW STEPS = STEPS + 1

                // RELAX → CHECK IF SHORTER
                if(newSteps<dist[newValue]) {

                    dist[newValue]=newSteps; // UPDATE DIST

                    // ENQUEUE NEW VALUE
                    q.add(new int[]{newSteps,newValue});

                    if(newValue==end) return newSteps;
                }
            }
        }

        return -1; // UNREACHABLE
    }
}
