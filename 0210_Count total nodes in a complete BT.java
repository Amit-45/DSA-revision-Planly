-----------------------------BRUTE-----------------------------------------------------
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)return 0; // BASE CASE
        return 1+countNodes(root.left)+countNodes(root.right); // COUNT ROOT + LEFT + RIGHT
    }
}
----------------------OPTIMAL----------------------------------------------------------
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)return 0; // BASE CASE

        int lh=findHeightLeft(root); // LEFT HEIGHT
        int rh=findHeightRight(root); // RIGHT HEIGHT

        if(lh==rh)return (1<<lh)-1; // PERFECT TREE = 2^H-1

        return 1+countNodes(root.left)+countNodes(root.right); // RECURSE LEFT + RIGHT
    }

    private int findHeightLeft(TreeNode node) {
        int height=0;
        while(node!=null){
            height++;
            node=node.left;
        }
        return height;
    }

    private int findHeightRight(TreeNode node) {
        int height=0;
        while(node!=null){
            height++;
            node=node.right;
        }
        return height;
    }
}
