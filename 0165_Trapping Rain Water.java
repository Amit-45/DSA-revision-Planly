-----------------------------------------OPTIMAL -----------------------------------------------------------------------------------
Initialize: Set two pointers at both ends and initialize left maximum, right maximum, and total water to zero.
Compare: Process the smaller height → Because the smaller side determines the water level.
Left: If left maximum is greater than current height → Add the difference to total; otherwise update left maximum → Because water is trapped only below a taller boundary.
Right: If right maximum is greater than current height → Add the difference to total; otherwise update right maximum → Because water is trapped only below a taller boundary.
Move: Move the pointer of the processed side inward → Because its trapped water has been calculated.
Return: Return total trapped water
-------------------------------------------------------------------------------------------------------------------------------------    
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int leftMax=0,rightMax=0,total=0;

        // Traverse from both ends
        while(left<right) {
            // Process the smaller height
            if(height[left]<=height[right]) {
                // If left maximum is bigger → Add trapped water
                if(leftMax>height[left]) total+=leftMax-height[left];
                // Otherwise → Update left maximum
                else leftMax=height[left];

                // Move left pointer ahead
                left++;
            } else {
                // If right maximum is bigger → Add trapped water
                if(rightMax>height[right]) total+=rightMax-height[right];
                // Otherwise → Update right maximum
                else rightMax=height[right];

                // Move right pointer backward
                right--;
            }
        }

        // Return total trapped water
        return total;
    }
}
------------------------------------------BRUTE------------------------------------------------------------------------------------
class Solution {
    //BRUTE
    public int trap(int[] height) {
        int n=height.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        int total=0;

        // Left Max: Traverse forward → Store prefix maximum
        leftMax[0]=height[0];
        for(int i=1;i<n;i++) {
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }

        // Right Max: Traverse backward → Store suffix maximum
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--) {
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }

        // Water: Minimum boundary height - current height → Add to total
        for(int i=0;i<n;i++) {
            total+=Math.min(leftMax[i],rightMax[i])-height[i];
        }

        // Return: Total trapped water
        return total;
    }
}
