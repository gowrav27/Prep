package leetcode.string;

public class VersionNumbers
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String v1 ="1.1";
        String v2 ="1";
        System.out.println(compareVersion(v1, v2));
    }

    public static int compareVersion(String version1, String version2)
    {
        return compareVersion2(version1, version2);
    }

    private  static int compareVersion2(String version1, String version2)
    {
        if(version1.isEmpty() && version2.isEmpty()){
            return 0;
        }
        int pos1 = version1.indexOf(".");
        int pos2 = version2.indexOf(".");
        if(pos1 == -1 && pos2 == -1){
            if( Integer.valueOf(version1) > Integer.valueOf(version2)){
                return 1;
            }else{
                return -1;
            }
        }
        if(pos1 == -1){
            if(Integer.valueOf(version1) == Integer.valueOf(version2.substring(0, pos2))){
                return -1;
            }else if(Integer.valueOf(version1) > Integer.valueOf(version2.substring(0, pos2))){
                return 1;
            }else{
                return -1;
            }
        }
        if(pos2 == -1){
            if(Integer.valueOf(version2) == Integer.valueOf(version2.substring(0, pos2))){
                return 1;
            }else if(Integer.valueOf(version2) > Integer.valueOf(version1.substring(0, pos1))){
                return -1;
            }else{
                return 1;
            }
        }
        String sub1 = version1.substring(0, pos1);
        String sub2 = version2.substring(0, pos2);
        if(Integer.valueOf(sub1) == Integer.valueOf(sub2)){
            return compareVersion2(version1.substring(pos1+1), version2.substring(pos2+1));
        }else if(Integer.valueOf(sub1)> Integer.valueOf(sub2)){
            return 1;
        }else{
            return 0;
        }
    }
}
