class Solution {
    public List<Integer> leaders(int[] nums) {
        List<Integer> answer= new ArrayList<>();
        int n=nums.length;
        if(n==0) return answer;
        int maxSoFar=nums[n-1];
        answer.add(maxSoFar);

        for(int i=n-2;i>=0;i--){
            if(nums[i]>maxSoFar){
                answer.add(nums[i]);
                maxSoFar=nums[i];
            }
        }
        Collections.reverse(answer);
        return answer;
    }
}
