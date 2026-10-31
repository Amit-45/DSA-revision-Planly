import java.util.*;
class Solution {
    public int findMaximumCookieStudents(int[] Student,int[] Cookie) {
        int n=Student.length;
        int m=Cookie.length;
        // Sort both arrays: least greedy student and smallest cookie first
        Arrays.sort(Student);
        Arrays.sort(Cookie);
        // Initialize pointers
        int l=0,r=0;
        // Traverse both arrays
        while(l<n && r<m) {
            // If cookie satisfies the current student
            if(Cookie[r]>=Student[l]) {
                l++; // Move to next student
            }
            // Always move to next cookie
            r++;
        }
        // Return number of satisfied students
        return l;
    }
}
