import java.util.*;
public class KMP {
    static int[]  prefix_function(String s){
        int n=s.length();
        int[] pi=new int[n];
        Arrays.fill(pi,0);
        for (int i=1;i<n;i++){
            int j=pi[i-1];
            while (j>0 && s.charAt(i)!=s.charAt(j)){
                j=pi[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){
                j++;
               pi[i]=j;
            }
        }
        return pi;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         String s=sc.next(),p=sc.next();
        int[] prefix=prefix_function(p);
        int pos=-1,i=0,j=0;
        while (i<s.length()){
            if(s.charAt(i)==p.charAt(j)){
               j++;
               i++;
            }else{
                if(j!=0){
                    j=prefix[j-1];
                }else{
                    i++;
                }
            }
            if(j==p.length()){
                pos=i-p.length();
                break;
            }
        }
        System.out.println(pos);
    }
}
