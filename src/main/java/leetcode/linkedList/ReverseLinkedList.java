package leetcode.linkedList;

public class ReverseLinkedList
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

    public ListNode reverseList(ListNode head)
    {
        if(head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode temp = reverseList(next);
        next.next = head;
        head.next = null;
        return temp;

    }

}

 class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
    }
}
