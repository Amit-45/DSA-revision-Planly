---------------------GREEDY SLOPE APPROACH ------------------------------
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int i=1,sum=1;
        while(i<n) {
            // Equal ratings
            if(ratings[i]==ratings[i-1]) {
                sum++;
                i++;
                continue;
            }
            // Increasing slope
            int peak=1;
            while(i<n && ratings[i]>ratings[i-1]) {
                peak++;
                sum+=peak;
                i++;
            }
            // Decreasing slope
            int down=1;
            while(i<n && ratings[i]<ratings[i-1]) {
                sum+=down;
                down++;
                i++;
            }
            // Adjust peak
            if(down>peak) sum+=(down-peak);
        }
        return sum;
    }
}
