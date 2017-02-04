package com.example.helloworld.icebreakers;

import java.math.BigInteger;

/**
 * Created by IceBreakers on 1/29/17 HW 1 AddUtil.java
 * Add two numbers or two strings irrespective of the length of the input.
 */
public class AddUtil {

    public static void myassert(boolean  x) {
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        if (!x) {
            throw new IllegalArgumentException("Assert fail") ;
        }
    }
    private static int add(int a, int b)
    {
        //Write your code here
        System.out.println(a+b);
        return a + b;
    }


    private static String add(String a, String b) {
        //Write your code here
        Stack myStack = new Stack();
        int carry = 0;
        int len1 = String.valueOf(a).length();
        int len2 = String.valueOf(b).length();
        len1 = len1 - 1;
        len2 = len2 - 1;
        int s = 0, sum;
        int e,f;
        char c,d;
        String result = "";

        while(true){
            if(len1 < 0){
                c = '0';
                d = b.charAt(len2);
            }
            else if(len2 < 0){
                d = '0';
                c = a.charAt(len1);
            }
            else {
                c = a.charAt(len1);
                d = b.charAt(len2);
            }
            e = Character.getNumericValue(c);
            f = Character.getNumericValue(d);

            s = e + f + carry;

            sum = s % 10;
            carry = s / 10;
            myStack.push(sum);
            len1--;
            len2--;

            if ((len1) < 0 && (len2) < 0){
                if (carry>0){
                    myStack.push(carry);
                }
                break;
            }
        }
        while (!(myStack.empty())){
            result += myStack.pop();
        }
        System.out.println();
        System.out.println(result);

        return result;
    }
    

    private static boolean testStringAdd(String a, String b){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        String s = add(a,b);
        BigInteger sum = new BigInteger(s);
        BigInteger a1 = new BigInteger(a);
        BigInteger b1 = new BigInteger(b);
        return (sum.equals(a1.add(b1)) );
    }

    private static boolean testIntAdd(int a, int b){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        int c = add(a,b);
        return (c == (a+b));
    }
    private static void testBench(){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        myassert(testIntAdd(10,20));
        System.out.println("Pass: 10+20");
        myassert(testStringAdd("11", "22"));
        System.out.println("Pass: 11+22");
        myassert(testStringAdd("1111", "22"));
        System.out.println("Pass: 1111+22");
        myassert(testStringAdd("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000",
                "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"));
        System.out.println("Pass: 100!+100!");
    }

    public static void main(String args[]){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        System.out.println("AddUtil.java");
        System.out.println();
        testBench();
        System.out.println("DONE");
    }
}
