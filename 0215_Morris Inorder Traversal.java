class Solution {
    public List<Integer> getInorder(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        TreeNode cur=root;

        while(cur!=null){

            // CASE 1: NO LEFT = VISIT + MOVE RIGHT
            if(cur.left==null){
                ans.add(cur.data);
                cur=cur.right;
            } else {

                // FIND RIGHTMOST NODE IN LEFT SUBTREE
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }

                // CASE 2: NO THREAD = CREATE + MOVE LEFT
                if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                }

                // CASE 3: THREAD EXISTS = REMOVE + VISIT + MOVE RIGHT
                else {
                    prev.right=null;
                    ans.add(cur.data);
                    cur=cur.right;
                }
            }
        }
        return ans;
    }
}
