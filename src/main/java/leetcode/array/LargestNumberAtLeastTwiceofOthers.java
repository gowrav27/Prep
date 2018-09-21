package leetcode.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumberAtLeastTwiceofOthers
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] ia = {5, 1, 0};
        System.out.println("dominantIndex :" + dominantIndex(ia));
    }

    public static int dominantIndex(int[] nums)
    {
        if(nums.length ==0){
            return -1;
        }
        if(nums.length ==1){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, new Desc());
        int max  =0;
        int i=0;
        int index =0;
        for(int n : nums){
            if(n>max){
                max = n;
                index =i;
            }
            i++;
            pq.add(n);
        }
        int max1= pq.poll();
        int max2 = pq.poll();
        
        return max1 >= 2*max2? index:-1;

    }
}

class Desc implements Comparator<Integer>{

    public int compare(Integer o1, Integer o2)
    {
        // TODO Auto-generated method stub
        return o2-o1;
    }
    
}