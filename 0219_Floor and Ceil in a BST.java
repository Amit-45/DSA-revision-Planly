class Solution {
    public List<Integer> floorCeilOfBST(TreeNode root,int key) {
        int floor=-1,ceil=-1;

        // FLOOR: SAVE + RIGHT | ELSE LEFT
        TreeNode cur=root;
        while(cur!=null){
            if(cur.data<=key){
                floor=cur.data;
                cur=cur.right;
            } else {
                cur=cur.left;
            }
        }

        // CEIL: SAVE + LEFT | ELSE RIGHT
        cur=root;
        while(cur!=null){
            if(cur.data>=key){
                ceil=cur.data;
                cur=cur.left;
            } else {
                cur=cur.right;
            }
        }

        return Arrays.asList(floor,ceil);
    }
}
