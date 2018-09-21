package leetcode.linkedList;

public class ReverseKNodes
{
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        reverseBetween(n1, 2);
    }

    public static ListNode reverseBetween(ListNode head, int k)
    {
        if(head == null)
            return null;
        if(k <= 1)
        {
            return head;
        }
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        int size = 1;
        ListNode countNode = head;
        while(countNode.next != null)
        {
            countNode = countNode.next;
            size++;
        }
        int count = size / k;
        while(count > 0)
        {
            ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be
                                       // reversed
            ListNode then = start.next; // a pointer to a node that will be reversed
            for(int i = 0; i < k - 1; i++)
            {
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
                then = start.next;
            }
            pre = start;
            count--;
        }

        return dummy.next;

    }

    public ListNode reverseList(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr.next != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr.next = prev;
        return curr;
    }
}
