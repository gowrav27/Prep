package leetcode.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

// Merge two arrays https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
public class MergeKSortedStack
{

    public static void main(String[] args)
    {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        Stack<Integer> stack3 = new Stack<Integer>();
        stack1.add(1);
        stack1.add(5);
        stack1.add(9);

        stack2.add(2);
        stack2.add(7);
        stack2.add(10);

        stack3.add(3);
        stack3.add(4);
        stack3.add(8);
        System.out.println(stack1);
        Stack[] s = {stack1, stack2, stack3};
        System.out.println(mergeKLists(s));

    }

    public static Stack<Integer> mergeKLists(Stack[] stacks)
    {
        if(stacks == null)
            return null;
        if(stacks.length == 0)
        {
            return null;
        }
        if(stacks.length <= 1)
        {
            return stacks[0];
        }

        PriorityQueue<Stack<Integer>> queue = new PriorityQueue<Stack<Integer>>(stacks.length, new Comparator<Stack<Integer>>() {

            public int compare(Stack<Integer> o1, Stack<Integer> o2)
            {
                // TODO Auto-generated method stub
                return o2.peek() - o1.peek();
            }

        });

        Stack<Integer> resultStack = new Stack<Integer>();

        for(Stack<Integer> stack : stacks)
            if(stack != null)
                queue.add(stack);

        Stack<Integer> interim = new Stack<Integer>();
        while(!queue.isEmpty())
        {
            interim = queue.poll();
            resultStack.push(interim.pop());
            if(!interim.isEmpty())
                queue.add(interim);
        }

        return resultStack;

    }
}
