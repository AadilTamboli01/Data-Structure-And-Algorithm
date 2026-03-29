import java.util.*;

public class ValidParenthesis {
    public static boolean validParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
          if(str.charAt(i)=='('||str.charAt(i)=='['||str.charAt(i)=='{'){
            // opening brackets  push in stak 
            s.push(str.charAt(i));

          }
          // if opening bracket 
          else{
            if(s.isEmpty()){
                // agar stack is empty hogaaya 
                return false ;  // closing bracke pehle aagaye opening  ke 

            }else {
                if(s.peek()=='('&& str.charAt(i)==')' ||s.peek()=='['&& str.charAt(i)==']' || s.peek()=='{'&& str.charAt(i)=='}' ){
                    s.pop(); // remove paired 
                }
                else {
                    // not paired 
                    return false ;
                }
            }
          }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{{{{]}}}";
        System.out.println(validParenthesis(s));
    }
}
