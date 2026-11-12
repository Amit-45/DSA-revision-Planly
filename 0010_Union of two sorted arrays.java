======SYANTAX ================
// Initialize two pointers
int i=0,j=0;

// 1. While BOTH pointers are within bounds
while(i<n && j<m){

    if(nums1[i]<=nums2[j]){
        // duplicate check
        // add nums1[i]
        i++;
    }
    else{
        // duplicate check
        // add nums2[j]
        j++;
    }
}

// 2. While nums1 has remaining elements
while(i<n){
    // duplicate check
    // add nums1[i]
    i++;
}

// 3. While nums2 has remaining elements
while(j<m){
    // duplicate check
    // add nums2[j]
    j++;
}

// 4. Convert List to Array
// 5. Return array
--------------------------CODE----------------------------------
class Solution {
   public int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> UnionList = new ArrayList<>();
        int i = 0, j = 0;
        int n = nums1.length;
        int m = nums2.length;
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                    UnionList.add(nums1[i]);
                }
                i++;
            } 
            else {
                if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                    UnionList.add(nums2[j]);
                }
                j++;
            }
        }
        while (i < n) {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                UnionList.add(nums1[i]);
            }
            i++;
        }
        while (j < m) {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                UnionList.add(nums2[j]);
            }
            j++;
        }
        int[] Union = new int[UnionList.size()];
        for (int k = 0; k < UnionList.size(); k++) {
            Union[k] = UnionList.get(k);
        }
 
        return Union;
    }
    }
