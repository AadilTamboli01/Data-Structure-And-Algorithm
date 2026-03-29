package function;


import java.util.*;

public class IsPrime {
    public static boolean isPrime(int n) {
        int mid = (int) Math.sqrt(n);
        for (int i = 2; i <= mid; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void primeinRange(int n){
        for(int i=1;i<=n;i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
            
        }
    }
    public static void main(String[] args) {
  primeinRange(10);
  
    }
}
