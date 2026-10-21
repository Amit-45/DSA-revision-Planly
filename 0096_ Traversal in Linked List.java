import java.util.*;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data=data;
        this.next=null;
    }
}

class Solution {
    public List<Integer> LLTraversal(ListNode head) {

        // 1. Preserve head and start traversal
        ListNode temp=head;

        // 2. Create a list to store node values
        List<Integer> ans=new ArrayList<>();

        // 3. Traverse until null
        while(temp!=null) {

            // 4. Store the current node's value
            ans.add(temp.data);

            // 5. Move to the next node
            temp=temp.next;
        }

        // 6. Return all collected values
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

        // Create nodes
        ListNode y1=new ListNode(5);
        ListNode y2=new ListNode(4);
        ListNode y3=new ListNode(3);
        ListNode y4=new ListNode(1);
        ListNode y5=new ListNode(0);

        // Link nodes
        y1.next=y2;
        y2.next=y3;
        y3.next=y4;
        y4.next=y5;

        // Call the traversal function
        Solution solution=new Solution();
        List<Integer> ans=solution.LLTraversal(y1);

        // Print the result
        System.out.println(ans);
    }
}
