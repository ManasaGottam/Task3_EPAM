import java.util.*;
public class RodCutting {
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
          int t=sc.nextInt();
          while((t--)!=0)
          {
              int n=sc.nextInt();
              int count=0;
              
              for(int i=3;i<=n;)
              {
                  count=count+1;
                  i=i+(i+1);
              }
              
              System.out.println(count);
}
    }
}
