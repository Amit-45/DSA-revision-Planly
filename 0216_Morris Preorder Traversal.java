class Solution {
    public List<Integer> preorder(TreeNode root) {
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

                // CASE 2: NO THREAD = CREATE + VISIT + MOVE LEFT
                if(prev.right==null){
                    prev.right=cur;
                    ans.add(cur.data);
                    cur=cur.left;
                }

                // CASE 3: THREAD EXISTS = REMOVE + MOVE RIGHT
                else {
                    prev.right=null;
                    cur=cur.right;
                }
            }
        }
        return ans;
    }
}
