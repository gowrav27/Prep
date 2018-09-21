package leetcode.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * when people talking about time complexity; say, O(nlogk) Can we first clarify what is “n” please?
 * If n is total number of numbers of all lists, then it’s nlogk; if n is average length of each
 * list, then it’s nklogk; Without clarification it’ll cause lots of confusion.
 * <p>
 * @author Gowrav Deivasigamani
 */
public class MergeKSortedList
{

    public ListNode mergeKLists(ListNode[] lists)
    {
        if(lists == null)
            return null;
        if(lists.length == 0)
        {
            return null;
        }
        if(lists.length <= 1)
        {
            return lists[0];
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2)
            {
                return o1.val - o2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(ListNode node : lists)
            if(node != null)
                queue.add(node);

        while(!queue.isEmpty())
        {
            tail.next = queue.poll();
            tail = tail.next;

            if(tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
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