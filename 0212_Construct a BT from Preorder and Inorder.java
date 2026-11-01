class Solution {
    public TreeNode buildTree(int[] preorder,int[] inorder) {
        Map<Integer,Integer> inMap=new HashMap<>();

        // HASHMAP = STORE INORDER VALUE : INDEX
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }

        return build(preorder,0,preorder.length-1,
                     inorder,0,inorder.length-1,inMap);
    }

    private TreeNode build(int[] preorder,int preStart,int preEnd, int[] inorder,int inStart,int inEnd, Map<Integer,Integer> inMap) {

        // BASE CASE = NO ELEMENTS
        if(preStart>preEnd || inStart>inEnd)return null;

        // ROOT = FIRST ELEMENT OF PREORDER
        int rootValue=preorder[preStart];
        TreeNode root=new TreeNode(rootValue);

        // FIND ROOT INDEX IN INORDER
        int inRoot=inMap.get(rootValue);

        // COUNT LEFT SUBTREE NODES
        int numsLeft=inRoot-inStart;

        // BUILD LEFT = SKIP ROOT, TAKE LEFT SIZE
        root.left=build(preorder,preStart+1,preStart+numsLeft,
                        inorder,inStart,inRoot-1,inMap);

        // BUILD RIGHT = SKIP ROOT + LEFT, TAKE REMAINING
        root.right=build(preorder,preStart+numsLeft+1,preEnd,
                         inorder,inRoot+1,inEnd,inMap);

        // RETURN CONSTRUCTED ROOT
        return root;
    }
}
