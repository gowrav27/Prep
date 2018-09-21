package leetcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSortedArray
{
    public static int[] mergeKSortedArray(int[][] arr)
    {
        // PriorityQueue is heap in Java
        PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
        int total = 0;

        // add arrays to heap
        for(int[] element : arr)
        {
            queue.add(new ArrayContainer(element, 0));
            total = total + element.length;
        }

        int m = 0;
        int result[] = new int[total];

        // while heap is not empty
        while(!queue.isEmpty())
        {
            ArrayContainer ac = queue.poll();
            result[m++] = ac.arr[ac.index];

            if(ac.index < ac.arr.length - 1)
            {
                queue.add(new ArrayContainer(ac.arr, ac.index + 1));
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 15};
        int[] arr3 = {10, 11};

        int[] result = mergeKSortedArray(new int[][] {arr1, arr2, arr3});
        System.out.println(Arrays.toString(result));
    }
}

class ArrayContainer implements Comparable<ArrayContainer>
{
    int[] arr;
    int index;

    public ArrayContainer(int[] arr, int index)
    {
        this.arr = arr;
        this.index = index;
    }

    public int compareTo(ArrayContainer o)
    {
        return this.arr[this.index] - o.arr[o.index];
    }
}