import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        List<Integer> st=new ArrayList<>();

        // Traverse: Check each asteroid
        for(int i=0;i<n;i++) {

            // Positive: Push right-moving asteroid into stack
            if(asteroids[i]>0) {
                st.add(asteroids[i]);
            }
            // Negative: Check collision with right-moving asteroids
            else {
                // Smaller positive: Pop and destroy it
                while(!st.isEmpty() && st.get(st.size()-1)>0 &&
                      st.get(st.size()-1)<Math.abs(asteroids[i])) {
                    st.remove(st.size()-1);
                }

                // Equal size: Pop and destroy both asteroids
                if(!st.isEmpty() &&
                   st.get(st.size()-1)==Math.abs(asteroids[i])) {
                    st.remove(st.size()-1);
                }
                // Stack empty or top negative: Push current asteroid
                else if(st.isEmpty() || st.get(st.size()-1)<0) {
                    st.add(asteroids[i]);
                }
            }
        }

        // Convert list to array: Create result array → Copy each element
        int[] result=new int[st.size()];
        for(int i=0;i<st.size();i++) {
            result[i]=st.get(i);
        }

        // Return: Return result array because method's return type is int[]
        return result;
    }
}
