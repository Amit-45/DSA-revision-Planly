Preorder + Inorder: Root is the first element (preStart); skip root to build left, then right.
Postorder + Inorder: Root is the last element (postEnd); exclude root to build left, then right.
------------------------------------------------------------------------------------------------------
class Solution {
    public TreeNode buildTree(int[] inorder,int[] postorder) {
        Map<Integer,Integer> inMap=new HashMap<>();

        // HASHMAP = STORE INORDER VALUE : INDEX
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }

        return build(inorder,0,inorder.length-1,
                     postorder,0,postorder.length-1,inMap);
    }

    private TreeNode build(int[] inorder,int inStart,int inEnd, int[] postorder,int postStart,int postEnd, Map<Integer,Integer> inMap) {

        // BASE CASE = NO ELEMENTS
        if(postStart>postEnd || inStart>inEnd)return null;

        // ROOT = LAST ELEMENT OF POSTORDER
        int rootValue=postorder[postEnd];
        TreeNode root=new TreeNode(rootValue);

        // FIND ROOT INDEX IN INORDER
        int inRoot=inMap.get(rootValue);

        // COUNT LEFT SUBTREE NODES
        int numsLeft=inRoot-inStart;

        // BUILD LEFT = TAKE LEFT SIZE
        root.left=build(inorder,inStart,inRoot-1,
                        postorder,postStart,postStart+numsLeft-1,inMap);

        // BUILD RIGHT = TAKE REMAINING, EXCLUDE ROOT
        root.right=build(inorder,inRoot+1,inEnd,
                         postorder,postStart+numsLeft,postEnd-1,inMap);

        // RETURN CONSTRUCTED ROOT
        return root;
    }
}
