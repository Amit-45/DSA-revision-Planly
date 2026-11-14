Memory triggers:
------------------
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        AL<AL>
        sort the array 
        for(i){
            DUp of i 
            for(j){
                DUP of j
                int k, int l 
                while(k<l)
                    calc sum :
                        if sum<target -> k++
                        if sum> target -> l--
                        if sum==target -> {
                            Add it to list
                            k++;
                            l--;
                            DUP of k -> k++
                            DUP of L -> l--
                        }
            }
        }
        return ans;
    }
}

DUPLIACTE:
    if(i>0 && nums[i]==nums[i-1])
    if(j>i+1 && nums[j]==nums[j-1])
    while(k<l && nums[k]==nums[k-1])
    while(k<l && nums[l]==nums[l+1]) (only this is +)

-----------CODE-----------
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) k++;
                    else if (sum > target) l--;
                    else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }
        return ans;
    }
}
