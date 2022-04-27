import java.util.*;

public class KMPTry {
    static int[] prefix_function(String pat){
        int[] pi=new int[pat.length()];
        Arrays.fill(pi,0);
        for (int i=1;i<pi.length;i++){
            int j=pi[i-1];
            while (j>0 && pat.charAt(i)!=pat.charAt(j)){
                j=pi[j-1];
            }
            if (pat.charAt(i)==pat.charAt(j)){
                pi[i]=++j;
            }
        }
        return pi;
    }
    static boolean hasSubstring(String s,String p,int[] pi){
       int i=0,j=0;
       while (i<s.length()){
           if (s.charAt(i)==p.charAt(j)){
               i++;j++;
           }else{
               if(j!=0){
                   j=pi[j-1];
               }else{
                   i++;
               }
           }
           if(j==p.length()){
               System.out.println(i- pi.length);
               return true;
           }
       }
       return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next(),pattern=sc.next();
        int[] prefix=prefix_function(pattern);
        for (int i=0;i< prefix.length;i++){
            System.out.print(prefix[i]+" ");
        }
        System.out.println();
        if(hasSubstring(s,pattern,prefix)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
