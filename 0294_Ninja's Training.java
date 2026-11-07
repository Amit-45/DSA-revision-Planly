----------RECUR-----------------------------------------------
f(day,last) {
    if(day == 0) {
        maxi = Integer.MIN_VALUE;

        for(task=0;task<3;task++) {
            if(task != last) {
                maxi = max(maxi,points[0][task]);
            }
        }

        return maxi;
    }

    maxi = Integer.MIN_VALUE;

    for(task=0;task<3;task++) {
        if(task != last) {
            activity = points[day][task] + f(day-1,task);
            maxi = max(maxi,activity);
        }
    }

    return maxi;
}
------------MEMO --------------------------------------------
2 D DP Array 
-------------------------------------------------------------

import java.util.*;

class Solution {
    private int func(int day,int last,int[][] points,int[][] dp) {
        if(dp[day][last]!=-1) return dp[day][last];

        if(day==0) {
            int maxi=Integer.MIN_VALUE;

            for(int task=0;task<3;task++) {
                if(task!=last) {
                    maxi=Math.max(maxi,points[0][task]);
                }
            }

            return dp[day][last]=maxi;
        }

        int maxi=Integer.MIN_VALUE;

        for(int task=0;task<3;task++) {
            if(task!=last) {
                int activity=points[day][task]+func(day-1,task,points,dp);
                maxi=Math.max(maxi,activity);
            }
        }

        return dp[day][last]=maxi;
    }

    public int ninjaTraining(int[][] points) {
        int n=points.length;

        if(n==0) return 0;

        int[][] dp=new int[n][4];

        for(int[] row:dp) {
            Arrays.fill(row,-1);
        }

        return func(n-1,3,points,dp);
    }
}
