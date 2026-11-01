Brute: A BST's inorder traversal is always sorted. So, store all node values in a list, find the key using binary search, and pick its previous and next elements.
optimal: Use BST properties to search for the key while updating predecessor/successor candidates; if found, find the rightmost node in LEFT and leftmost node in RIGHT subtree; return -1 if either is missing.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
class Solution {
    public int[] succPredBST(TreeNode root,int key) {
        TreeNode pred=null,succ=null;
        while(root!=null) {
            if(key>root.data) {
                pred=root;            // Curr node can be PRED → MOVE RIGHT
                root=root.right;
            }
            else if(key<root.data) {
                succ=root;           // Curr node can be SUCC → MOVE LEFT
                root=root.left;
            }
            else {
                // If FOUND KEY → PRED = RIGHTMOST OF LEFT Sub Tree
                TreeNode temp=root.left;
                while(temp!=null && temp.right!=null)
                    temp=temp.right;
                if(temp!=null)pred=temp;

                // If FOUND KEY → SUCC = LEFTMOST OF RIGHT Sub Tree
                temp=root.right;
                while(temp!=null && temp.left!=null)
                    temp=temp.left;
                if(temp!=null)succ=temp;

                break;
            }
        }

        // NULL → -1
        return new int[]{
            pred==null?-1:pred.data,
            succ==null?-1:succ.data
        };
    }
}
