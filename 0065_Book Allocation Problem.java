import java.util.*;

class Solution{
    // Count students needed for the given page limit
    private int countStudents(int[] nums,int pages){
        int students=1,pagesStudent=0;
        for(int i=0;i<nums.length;i++){
            if(pagesStudent+nums[i]<=pages){
                pagesStudent+=nums[i];
            }
            else{
                students++;
                pagesStudent=nums[i];
            }
        }
        return students;
    }

    // Minimize the maximum pages allocated to a student
    public int findPages(int[] nums,int m){
        int n=nums.length;
        if(m>n)return -1;

        int l=Integer.MIN_VALUE,h=0;
        for(int i=0;i<n;i++){
            l=Math.max(l,nums[i]); // Largest book
            h+=nums[i]; // Total pages
        }

        while(l<=h){
            int mid=l+(h-l)/2;
            int students=countStudents(nums,mid);

            if(students>m){
                l=mid+1; // Too many students, increase limit
            }
            else{
                h=mid-1; // Possible, try smaller limit
            }
        }
        return l;
    }
}
