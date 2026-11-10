--------------------Tabulation (LIS + LDS DP)--------------------------------
import java.util.*;

class Solution {
    public int LongestBitonicSequence(int[] arr) {
        int n=arr.length;

        // 1. LIS = 1
        int[] LIS=new int[n];
        Arrays.fill(LIS,1);

        // 2. LEFT TO RIGHT - Calculate LIS
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){

                // 3. SMALLER PREVIOUS
                if(arr[prev]<arr[i]){
                    LIS[i]=Math.max(LIS[i],LIS[prev]+1);
                }
            }
        }

        // 4. LDS = 1
        int[] LDS=new int[n];
        Arrays.fill(LDS,1);

        int maxLen=0;

        // 5. RIGHT TO LEFT - Calculate LDS
        for(int i=n-1;i>=0;i--){
            for(int prev=n-1;prev>i;prev--){

                // 6. SMALLER NEXT
                if(arr[prev]<arr[i]){
                    LDS[i]=Math.max(LDS[i],LDS[prev]+1);
                }
            }

            // 7. COMBINE LIS + LDS - 1
            if(LIS[i]>1 && LDS[i]>1){
                maxLen=Math.max(maxLen,LIS[i]+LDS[i]-1);
            }
        }

        // 8. RETURN MAX
        return maxLen;
    }
}
