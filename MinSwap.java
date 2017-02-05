/**
 * Created by IceBreakers on 2/1/17.

 * Move all the zeroes to the end of the array with minimum swaps
 Given an array of random numbers, Push all the zero’s of a given array to the end of the array.

 * Expected Output Format of your program:
 *
 MinSwamp.java
 Original Array
 1,9,8,4,0,0,2,7,0,6,0,
 swap - 1 - Indexes:4 and 9
 swap - 2 - Indexes:5 and 7
 Swapped Array
 1,9,8,4,6,7,2,0,0,0,0
 DONE

 DONE
 */
public class MinSwap {

    public static void myassert(boolean  x) {
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        if (!x) {
            throw new IllegalArgumentException("Assert fail") ;
        }
    }

    //print array utility
    private static void printArray(int a[]){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + ",");
        }
    }
    private static int minSwaps(int a[]){
        //WRITE YOUR CODE HERE...
        int p1=0, p2 = a.length - 1, temp,swap=0;
        while(p1 < p2){
            if (a[p1] == 0){
                if(a[p2]  != 0){
                    temp = a[p1];
                    a[p1] = a[p2];
                    a[p2] = temp;
                    p1 ++;
                    p2 --;
                    swap ++;
                }
                else{
                    p2 --;
                }
            }
            else if (a[p1] != 0){
                if(a[p2]  == 0){
                    p1 ++;
                    p2 --;
                }
                else{
                    p1 ++;
                }
            }
        }
        printArray(a);
        return swap;
    }
 
    private static void testBench(){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        int[] a1 = {1,2,0,3,0,4,5};
        myassert(2 == minSwaps(a1));
        System.out.println("Pass 1");
        int[] a2 = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        myassert(2 == minSwaps(a2));
        System.out.println("Pass 2" );
    }

    public static void main(String args[]){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        System.out.println("MinSwamp.java");
        testBench();
        System.out.println("DONE");
    }
}
