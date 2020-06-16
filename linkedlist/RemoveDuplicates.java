package linkedlist;

/**
 * 83. Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */
public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode node = head.next;
        while(node !=null){
            if(curr.val != node.val){
                curr.next = node;
                curr = node;
            }
            node = node.next;
        }
        curr.next = null;
        return head;
    }
}


//  Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

