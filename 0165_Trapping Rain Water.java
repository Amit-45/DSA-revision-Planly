




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
