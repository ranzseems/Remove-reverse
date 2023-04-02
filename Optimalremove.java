//Given a string S which consists of only lowercase English alphabets, you have to perform the below operations:
//If the string S contains any repeating character, remove the first repeating character and reverse the string and again perform the above operation on the modified string, otherwise, you stop.
//You have to find the final string.

//Example 1:

//Input: S = "abab"
//Output: ba
//Explanation:
//In 1st operation: The first repeating 
//character is a. After Removing the first 
//character, S = "bab". After Reversing the 
//string, S = "bab".
//In 2nd operation: The first repeating 
//character is b. After Removing the first 
//character, S = "ab". After Reversing the 
//string, S = "ba".
//Now the string S does not contain any 
//repeating character.
    
    
import java.util.Arrays;


public class Optimalremove{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeReverse("aaabbccc"));
    }
}

class Solution 
{ 
    String removeReverse(String S) 
    { 
        int i=0,j=S.length()-1;
        
        int[] map=new int[26]; 
        Arrays.fill(map,0);
        boolean flag=true;
        int cnt=0;
        
        
        for(char ch:S.toCharArray()) map[ch-'a']++;
        
        String begin="",end="";
        
        while(i<=j)
        {
            char ch;
            if(flag) ch=S.charAt(i++);
            else ch=S.charAt(j--);
            
            if(map[ch-'a']>1)
            {
                map[ch-'a']--;
                cnt++;
                flag=!flag;
            }
            else
            {
                if(flag) begin+=ch;
                else end=ch+end;
            }
        }
        
        StringBuffer ans=new StringBuffer(begin+end);
        
        if(cnt%2==1) ans.reverse();
        
            return ans.toString();
        
    }
}
