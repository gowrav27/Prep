package leetcode.array.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutocompleteSystem
{

    class TrieNode
    {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;

        public TrieNode()
        {
            children = new HashMap<Character, TrieNode>();
            counts = new HashMap<String, Integer>();
            isWord = false;
        }
    }

    class Pair
    {
        String s;
        int c;

        public Pair(String s, int c)
        {
            this.s = s;
            this.c = c;
        }
    }

    TrieNode root;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times)
    {
        root = new TrieNode();
        prefix = "";

        for(int i = 0; i < sentences.length; i++)
        {
            add(sentences[i], times[i]);
        }
    }

    private void add(String s, int count)
    {
        TrieNode curr = root;
        for(char c : s.toCharArray())
        {
            TrieNode next = curr.children.get(c);
            if(next == null)
            {
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
            curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
        }
        curr.isWord = true;
    }

    public List<String> input(char c)
    {
        if(c == '#')
        {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }

        prefix = prefix + c;
        TrieNode curr = root;
        for(char cc : prefix.toCharArray())
        {
            TrieNode next = curr.children.get(cc);
            if(next == null)
            {
                return new ArrayList<String>();
            }
            curr = next;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(5, new Comparator<Pair>() {

            public int compare(Pair p1, Pair p2)
            {
                if(p1.c == p2.c)
                {
                    return p2.s.compareTo(p1.s);
                }

                    return p2.c - p1.c;

            }
        });
        for(String s : curr.counts.keySet())
        {
            pq.add(new Pair(s, curr.counts.get(s)));
        }

        List<String> res = new ArrayList<String>();
        for(int i = 0; i < 3 && !pq.isEmpty(); i++)
        {
            res.add(pq.poll().s);
        }
        return res;
    }


    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
