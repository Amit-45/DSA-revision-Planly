class Solution {
  public static int[] twoSum(int nums[], int target){
         int n=nums.length;
         HashMap<Integer,Integer> myMap = new HashMap<>();
         for(int i=0;i<n;i++){
            int complement = target - nums[i];
            if (myMap.containsKey(complement)){
                return new int[] {myMap.get(complement),i};
            }
            myMap.put(nums[i],i);
         }
         return new int[]{};
    }
}
