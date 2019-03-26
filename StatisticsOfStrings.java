import java.util.*;
public class StatisticsOfStrings {
    static ArrayList<String> words=new ArrayList<>();
    public static void main(String args[] ) throws Exception {
         Scanner sc=new Scanner(System.in);
	  int n=sc.nextInt();
	  int a=sc.nextInt();
	  int mod=sc.nextInt();
	  char[] alphabets = new char[a]; 
	  int j=97;
	  for(int i=0;i<a;i++) {
		  alphabets[i]=(char)j++;
	  } 
	      int len = alphabets.length; 
	      int summation=0;
	      GetAllPermutations(alphabets, "", len, n); 
	      for(String s:words)
	         summation+=findZFunctionValues(s);
	      System.out.println(summation%mod);

    }
    
     static void GetAllPermutations(char[] set,  
	                                 String prefix,  
	                                 int len, int n) 
	  {      
	    if (n == 0)  
	      { 
	          //System.out.println(prefix); 
	          words.add(prefix);
	          return; 
	      } 
	    
	      for (int i = 0; i < len; ++i) 
	      { 
	    
	          String newPrefix = prefix + set[i];  
	          GetAllPermutations(set, newPrefix,  
	                                  len, n - 1);  
	      } 
	  } 
	  static int findZFunctionValues(String str) {
		  int n = str.length(); 
		    int Z[]=new int[n];
		    // [L,R] make a window which matches with  
		    // prefix of s 
		    int L = 0, R = 0; 

		    for(int i = 1; i < n; ++i) { 

		        // if i>R nothing matches so we will calculate. 
		        // Z[i] using naive way. 
		        if(i > R){ 

		            L = R = i; 

		            // R-L = 0 in starting, so it will start 
		            // checking from 0'th index. For example, 
		            // for "ababab" and i = 1, the value of R 
		            // remains 0 and Z[i] becomes 0. For string 
		            // "aaaaaa" and i = 1, Z[i] and R become 5 

		            while(R < n && str.charAt(R - L) == str.charAt(R)) 
		                R++; 
		              
		            Z[i] = R - L; 
		            R--; 

		        } 
		        else{ 

		            // k = i-L so k corresponds to number which 
		            // matches in [L,R] interval. 
		            int k = i - L; 

		            // if Z[k] is less than remaining interval 
		            // then Z[i] will be equal to Z[k]. 
		            // For example, str = "ababab", i = 3, R = 5 
		            // and L = 2 
		            if(Z[k] < R - i + 1) 
		                Z[i] = Z[k]; 

		            // For example str = "aaaaaa" and i = 2, R is 5, 
		            // L is 0 
		            else{ 


		            // else start from R and check manually 
		                L = i; 
		                while(R < n && str.charAt(R - L) == str.charAt(R)) 
		                    R++; 
		                  
		                Z[i] = R - L; 
		                R--; 
		            } 
		        }
		    }
		    int max=0;
		    for(int k:Z) {
		    	if(k>max) 
		    		max=k;
		    }
		    return max;
	  }
	  
	  
  }


