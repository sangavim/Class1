import java.util.*;
/**
 * Created by IceBreakers on 2/11/17.
 * Class 3, Easy-1 Problem PrimeNumbers.java
 * 1. Return all 4-digit prime numbers in an ArrayList
 * 2. Print the 2nd largest 6-digit prime number
 */
public class PrimeNumbers {

    public static void myassert(boolean  x) {
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        if (!x) {
            throw new IllegalArgumentException("Assert fail") ;
        }
    }

    private static int secondMaxSixDigitPrime(){
        int num,i,check,max=0;
        for (check = 999999; check >= 100000; check--){
            int count = 0;
            num = check/2;
            for(i = 2; i <= num; i++){
                if(check % i == 0){
                    count++;
                }
            }
            if(count == 0){
                max ++;
                if(max == 2){
                    break;
                }
            }
        }
        return check;
    }

    private static List<Integer> fourDigitPrimes(){
        int i,num,check;
        ArrayList<Integer> primes = new ArrayList<>();
        for (check = 1000; check <= 9999; check++){
            int count = 0;
            num = check/2;
            for(i = 2; i <= num; i++){
                if(check % i == 0){
                    count = count + 1;
                }
            }
            if(count == 0){
                primes.add(check);
            }
        }
        return primes;
    }

    private static void testBench(){
        myassert(secondMaxSixDigitPrime() == 999979);
        System.out.println(secondMaxSixDigitPrime());
        List output = fourDigitPrimes();
        myassert(output.size()==1061);
    }
    public static void main(String args[]){
        System.out.println("PrimeNumbers.java");
        testBench();
        System.out.println("DONE");

    }
}
