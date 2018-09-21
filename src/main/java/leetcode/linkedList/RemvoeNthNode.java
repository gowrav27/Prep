package leetcode.linkedList;

public class RemvoeNthNode
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

    public ListNode removeNthFromEnd2(ListNode head, int n)
    {
        ListNode slow = head, fast = head;
        while(n > 0)
        {
            fast = fast.next;
            n--;
        }
        if(fast == null)
        {
            return head.next;
        }
        ListNode prev = null;
        while(fast != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n)
    {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        // Move fast in front so that the gap between slow and fast becomes n
        for(int i = 1; i <= n + 1; i++)
        {
            fast = fast.next;
        }
        // Move fast to the end, maintaining the gap
        while(fast != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        // Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
