----------------------------------BRUTE same as 2 sum normal BRUTE------------------------------------------
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
--------------------------------OPTIMAL use BST Iterator logic (2 stacks + 2 pointers)--------------------------------------------
class BSTIterator {
    Stack<TreeNode> stack=new Stack<>();
    boolean reverse;

    // CONSTRUCTOR → PUSH LEFT/RIGHT PATH
    public BSTIterator(TreeNode root,boolean reverse) {
        this.reverse=reverse;
        pushAll(root);
    }

    // STACK NOT EMPTY?
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // POP → PUSH OPPOSITE SUBTREE'S PATH → RETURN DATA
    public int next() {
        TreeNode node=stack.pop();
        if(reverse)pushAll(node.left); // REVERSE → LEFT
        else pushAll(node.right); // NORMAL → RIGHT
        return node.data;
    }

    // NORMAL = MOVE LEFT | REVERSE = MOVE RIGHT
    private void pushAll(TreeNode node) {
        while(node!=null) {
            stack.push(node);
            node=reverse?node.right:node.left;
        }
    }
}

class Solution {
    public boolean twoSumBST(TreeNode root,int k) {
        if(root==null)return false;

        // FORWARD + BACKWARD ITERATORS
        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);

        int i=l.next(),j=r.next();

        // TWO POINTERS → ONE FROM EACH END
        while(i<j) {
            int sum=i+j;
            if(sum==k)return true; // PAIR FOUND
            else if(sum<k)i=l.next(); // SUM SMALL → MOVE LEFT FORWARD
            else j=r.next(); // SUM LARGE → MOVE RIGHT BACKWARD
        }
        return false; // NO PAIR
    }
}
