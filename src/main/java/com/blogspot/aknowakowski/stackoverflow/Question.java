package com.blogspot.aknowakowski.stackoverflow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;



public class Question
{
    static long l = 8;

    private static Long getCodeValueIdFromMeaning(int x)
    {

        return x ==1 ? null : l;
    }

    private static long getCodeValueIdFromMeaning2(long x)
    {

        return x;
    }

    static int sum(Integer... integer)
    {
        int sum = 0;
        for(int arg : integer)
        {
            sum += arg;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println(getCodeValueIdFromMeaning2(getCodeValueIdFromMeaning(2)));
        System.out.println(sum(new Integer[] {1, 2, 3}));
        System.out.println(createPersonnelMID());

    }

    public static ArrayList<String> assignGraders(ArrayList<String> students, ArrayList<String> graders)
    {
        int studentsSize = students.size();
        int gradersSize = graders.size();

        int studentToGrader = studentsSize / gradersSize;
        int assignedStudents = 0;

        ArrayList<String> studToGrader = new ArrayList<String>(students.size());
        while(assignedStudents < studentsSize)
        {
            int i = 0;
            while(i < studentToGrader)
            {
                studToGrader.add(students.get(assignedStudents) + "--" + graders.get(i));
                assignedStudents++;
                i++;
            }
        }
        return studToGrader;
    }

    public static String createPersonnelMID()
    {
        Collection<String> personnelMIDs = createPersonnelMIDs();
        return personnelMIDs.iterator().next();
    }

    public static Collection<String> createPersonnelMIDs()
    {
        return Collections.emptySet();
    }

}
