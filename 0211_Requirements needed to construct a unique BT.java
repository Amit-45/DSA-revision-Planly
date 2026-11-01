Root identification(PRE/POST) + Left/Right separation(INORDER IS MUST) = Unique Binary Tree.

1-> PRE
2-> IN
3-> POST 

class Solution {
    public boolean uniqueBinaryTree(int a, int b) {
        if(a == b) return false;
        return a == 2 || b == 2;
    }
}



