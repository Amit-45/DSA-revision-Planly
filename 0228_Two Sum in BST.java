----------------------------------BRUTE------------------------------------------
class Solution {
    public boolean twoSumBST(TreeNode root,int k) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list); // INORDER → STORE SORTED

        int left=0,right=list.size()-1; // TWO POINTERS

        while(left<right) {
            int sum=list.get(left)+list.get(right);
            if(sum==k)return true; // PAIR FOUND
            else if(sum<k)left++; // SUM SMALL → LEFT++
            else right--; // SUM LARGE → RIGHT--
        }
        return false; // NO PAIR
    }

    private void inorder(TreeNode root,List<Integer> list) {
        if(root==null)return;
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
    }
}
--------------------------------OPTIMAL--------------------------------------------
